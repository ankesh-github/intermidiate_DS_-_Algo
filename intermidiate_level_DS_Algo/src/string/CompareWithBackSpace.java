package string;

public class CompareWithBackSpace {
    public static void main(String[] args) {
        String s1= "geee#e#kss";
        String s2 = "gee##eeks";

        String str1 = s1.replace("#", "");
        String str2 = s2.replace("#", "");

        System.out.println(str1+"  , "+ str2 +"  "+ str1.equals(str2));
    }
}
