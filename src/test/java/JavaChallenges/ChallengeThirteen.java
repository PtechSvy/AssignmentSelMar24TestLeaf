package JavaChallenges;

public class ChallengeThirteen {
    /*
    A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
You are given an array of strings sentences, where each sentences[i] represents a single sentence.
Return the maximum number of words that appear in a single sentence.
Example 1:
Input: sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
Output: 6
     */

    public static int maxWords(String[]sentence)
    {
        int maxwords = 0 ;
        //split the sentence into words
        for(String Sentence:sentence)
        {
            String[]words = Sentence.split("\\s+");
            maxwords = Math.max(maxwords,words.length);

        }

        return maxwords;

    }

    public static void main(String[] args) {

        String[] Sentence = {"alice and bob love leetcode", "i think so too", "this is great thanks very much "};
        System.out.println("Maximum words in user defined sentence is" + " " + maxWords(Sentence));

    }
}
