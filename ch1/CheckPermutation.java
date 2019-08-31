//1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
import java.util.*;

public class CheckPermutation{

    static String sort(String s){
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    static boolean permutation(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        return sort(s).equals(sort(t));
    }

    private static void unitTest(String testString, String testString2, boolean expectedResult){
        boolean actualResult = permutation(testString, testString2);
        StringBuilder sb = new StringBuilder();
        if(expectedResult == actualResult){
            sb.append("PASSED: ");
        }else{
            sb.append("FAILED: ");
        }
        sb.append("Test for \"" + testString + "\" and \"" + testString2 + ", expected result was " + expectedResult + " and actual result was " + actualResult);
        System.out.println(sb.toString());
    }

    public static void main(String args[]){
        unitTest("hello", "elloh", true);
        unitTest("haha", "no", false);
        unitTest("length", "abcdef", false);
        unitTest("tacocat", "catocat", true);
    }
}