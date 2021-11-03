package com.feichai.test.job.input;

import com.feichai.test.domain.SysMenu;
import com.feichai.test.job.output.OutputWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class InputFromDBConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Resource
    private ItemWriter<? super SysMenu> outputWriter;

    @Autowired
    DataSource dataSource;

    @Bean
    public Job inPutDBJob(){
        return jobBuilderFactory.get("inPut")
                .start(reader())
                .build();
    }

    @Bean
    public Step reader() {
        return stepBuilderFactory.get("reader")
                .<SysMenu,SysMenu>chunk(10)
                .reader(read(dataSource))
                .writer(outputWriter)
                .build();
    }


    @Bean
    public JdbcPagingItemReader<SysMenu> read(DataSource dataSource) {
        JdbcPagingItemReader<SysMenu> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(dataSource);
        reader.setFetchSize(10);
        reader.setRowMapper(((resultSet, i) -> {
            return SysMenu.builder()
                    .menuId(resultSet.getInt("menu_id"))
                    .parentId(resultSet.getInt("parent_id"))
                    .build();
        }));

        MySqlPagingQueryProvider queryProvider = new MySqlPagingQueryProvider();
        queryProvider.setSelectClause("menu_id,parent_id");
        queryProvider.setFromClause("from sys_menu");
        Map<String, Order> sorts = new HashMap<>(1);
        sorts.put("menu_id",Order.ASCENDING);
        queryProvider.setSortKeys(sorts);

        reader.setQueryProvider(queryProvider);

        return reader;
    }
}
