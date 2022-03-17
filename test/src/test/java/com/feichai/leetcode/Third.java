package com.feichai.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Third {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int result = 0, start = 0;
        for (int end = 0; end < chars.length; end++) {
            if (map.containsKey(chars[end])){
                start = Math.max(map.get(chars[end]), start);
            }
            map.put(chars[end], end + 1);//为了发现重复后，指针能
            result = Math.max(result, end - start + 1);
        }

        return result;
    }

    public static void main(String[] args) {

        int a = lengthOfLongestSubstring("pwewkaw");
        System.out.println(a);
    }
}
