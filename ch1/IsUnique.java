/*
1.1 Is Unique: Implement an algoorithm to determine if a string has all unique characters.  
What if you cannot use additional data structures?
*/
import java.util.*;

public class IsUnique{

    public static boolean allUniqueCharacters(String string){
        Set<Character> characters = new HashSet<>();
        for(int i = 0; i < string.length(); i++){
            if(characters.contains(string.charAt(i))){
                return false;
            }
            characters.add(string.charAt(i));
        }
        return true;
    }

    private static void unitTest(String testString, boolean expectedResult){
        boolean actualResult = allUniqueCharacters(testString);
        StringBuilder sb = new StringBuilder();
        if(expectedResult == actualResult){
            sb.append("PASSED: ");
        }else{
            sb.append("FAILED: ");
        }
        sb.append("Test for \"" + testString + "\", expected result was " + expectedResult + " and actual result was " + actualResult);
        System.out.println(sb.toString());
    }

    public static void main(String[] args){
        unitTest("Hello", false);
        unitTest("hey", true);
        unitTest("worldofwarcraft", false);
        unitTest("yourface", true);
    }
}