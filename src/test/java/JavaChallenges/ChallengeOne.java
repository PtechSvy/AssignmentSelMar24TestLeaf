package JavaChallenges;

import java.util.Scanner;

public class ChallengeOne {

    public static int lengthOfLastWord(String word)
    {
        boolean flag = false;
        int len = 0;
        for(int i = word.length()-1;i>=0;i--)
        {
            if(Character.isLetter(word.charAt(i)))
            {
                flag = true;
                len++;
            }
            else
            {
                if(flag==true)
                {
                    return len;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        /**
         * Given a string s consisting of words and spaces, return the length of the last word in the string.
         *A word is a maximal substring consisting of non-space characters only.
         * Input: s = "Hello World"
         * Output: 5
         * Explanation: The last word is "World" with length 5.
         * Algorithm:-
         * Iterate from the end of the string
         * Declare integer count as 0 to count length of last word
         * Each time it pass a character ,increase count by 1
         * stop the loop when it reach space and return the count number
         */
        Scanner  sc = new Scanner(System.in);
        System.out.println("Enter the word for which length needs to be calculated:");
        String nm = sc.nextLine();
        System.out.println("The length of last word is :" + " " + lengthOfLastWord(nm));


    }
}
