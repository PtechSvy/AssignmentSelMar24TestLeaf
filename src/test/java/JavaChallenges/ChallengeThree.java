package JavaChallenges;

import java.util.Locale;
import java.util.Scanner;

public class ChallengeThree {

    /*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
    and removing all non-alphanumeric characters, it reads the same forward and backward.
    Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.*/

    public static boolean phrasePalindrome(String input)
    {
        boolean flag = false;
      //  input = input.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        String paliPhr = " ";
        for(int i = input.length()-1;i>=0;i--) {

            paliPhr = paliPhr + input.charAt(i);

        }

        if(input.equals(paliPhr))
        {
            flag = true;
        }

     return flag;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        value = value.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        value = value.replaceAll("\\s+", "");
        System.out.println(value);
        System.out.println("The value is Palindrome :" + phrasePalindrome(value));


    }


}
