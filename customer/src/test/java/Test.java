public class Test {
    public static void main(String[] args) {
        String str="20200501";
        String s="20200606";
        System.out.println((s==null || str.compareTo(s)>0?str:s));
    }
}
