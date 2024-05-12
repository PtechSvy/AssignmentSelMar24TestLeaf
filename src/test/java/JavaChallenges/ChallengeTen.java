package JavaChallenges;

import java.util.HashSet;
import java.util.Scanner;

public class ChallengeTen {

    //You're given strings jewels representing the types of stones that are jewels,
    // and stones representing the stones you have. Each character in stones is a type of stone you have.
    // You want to know how many of the stones you have are also jewels.
    //Letters are case sensitive, so "a" is considered a different type of stone from "A".
    //Example 1:
    //Input: jewels = "aA", stones = "aAAbbbb"
    //Output: 3

    public static  int countOfJewels(String val1, String val2)
    {
        HashSet<Character> hashSet = new HashSet<>();

        //Adding the jewels in an hashset such that searching jewels becomes an O(1) task
        for(int i=0;i<val1.length();i++)
            hashSet.add(val1.charAt(i));

        //This is the counter(our answer)
        int count = 0;

        for(int i=0;i<val2.length();i++){

            char c = val2.charAt(i);
            //If that stone is also a jewel,ie present in the hashset of jewels, we can increment the counter
            if(hashSet.contains(c))
                count++;

        }
        return count;
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String jewels = sc.nextLine();
        System.out.println("Enter the jewels" + " " + jewels);
        Scanner sc1 = new Scanner(System.in);
        String stones = sc1.nextLine();
        System.out.println("Enter the stones" + " " + stones);
        System.out.println("The number of jewels in stones is " + " " + countOfJewels(jewels,stones));
    }
}
