package JavaChallenges;

public class ChallengeFifteen {
    /*Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.

Example 1:

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true */

    public static boolean isTwoStringSame(String[] arr1,String[] arr2)
    {
      String word1 = " ";
      String word2  = " ";
      for(int i = 0; i<arr1.length;i++)
      {
          word1+=arr1[i];
      }
      for(int j = 0;j< arr2.length;j++)
      {
          word2+=arr2[j];
      }
      return word2.equals(word1);
    }

    public static void main(String[] args) {

        String[] val = {"ab", "c"};
        String[] val1 = {"a", "bc"};
        System.out.println("Is the  values in two string are same :" + " " + isTwoStringSame(val,val1) );
    }
}
