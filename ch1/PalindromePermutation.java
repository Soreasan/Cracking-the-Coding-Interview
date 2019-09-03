/*
1.4 Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards and backwards.  A permutation is 
a rearrangement of letters.  The palindrome does not need to be limited to just dictionary words.  
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco cta", etc.)

My note: This wasn't my approach, I followed the solution in the book because it's very focused
on converting the chars into integers which is an approach I haven't done very much of.  
*/

public class PalindromePermutation{

    public static boolean palindromePermutation(String string){
        int[] table = buildCharFrequencyTable(string);
        return checkMaxOneOdd(table);
    }

    public static boolean checkMaxOneOdd(int[] table){
        boolean foundOdd = false;
        for(int count : table){
            if(count % 2 == 1){
                if(foundOdd){
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    private static int getCharNumber(char c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int A = Character.getNumericValue('A');
        int Z = Character.getNumericValue('Z');

        int val = Character.getNumericValue(c);
        if(a <= val && val <= z){
            return val - a;
        }
        if(A <= val && val <= Z){
            return val - A;
        }
        return -1;
    }

    private static int[] buildCharFrequencyTable(String phrase){
        int[] table = new int[26];
        for(char c : phrase.toCharArray()){
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
            }
        }
        return table;
    }

    private static void unitTest(String testString, boolean expectedResult){
        boolean actualResult = palindromePermutation(testString);
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
        unitTest("Hello World!", false);
        unitTest("Tact Coa", true);
        unitTest("aabbc", true);
        unitTest("aabbcc", true);
        unitTest("no", false);
    }
}