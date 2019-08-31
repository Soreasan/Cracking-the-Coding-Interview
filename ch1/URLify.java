/*
1.3 URLify: Write a method to replace all spaces in a string with '%20'.  You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true" 
length of the string.  (Note: if implementing in Java, please use a character array so that you can 
perform this operation in place)
EXAMPLE
Input:  "Mr John Smith    ", 13
Output: "Mr%20John%20Smith"

My Note: the 13 represents the length of the "Mr John Smith" part ignoring spaces.
*/

public class URLify{
    public static String urlify(String string, int trueLength){
        char[] charArr = string.toCharArray();
        int charToReplaceIndex = charArr.length - 1;
        int currCharIndex = trueLength - 1;
        for(;currCharIndex >= 0; currCharIndex--){
            if(charArr[currCharIndex] == ' '){
                charArr[charToReplaceIndex--] = '0';
                charArr[charToReplaceIndex--] = '2';
                charArr[charToReplaceIndex--] = '%';
            }else{
                charArr[charToReplaceIndex--] = charArr[currCharIndex];
            }
        }
        return new String(charArr);
    }

    private static void unitTest(String testString, int trueLength, String expectedResult){
        String actualResult = urlify(testString, trueLength);
        StringBuilder sb = new StringBuilder();
        if(expectedResult.equals(actualResult)){
            sb.append("PASSED: ");
        }else{
            sb.append("FAILED: ");
        }
        sb.append("Test for \"" + testString + "\" with trueLength of \"" + trueLength + ", expected result was " + expectedResult + " and actual result was " + actualResult);
        System.out.println(sb.toString());
    }

    public static void main(String[] args){
        unitTest("Mr John Smith    ", 13, "Mr%20John%20Smith");
    }
}