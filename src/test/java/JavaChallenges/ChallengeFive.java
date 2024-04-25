package JavaChallenges;

import java.util.Scanner;

public class ChallengeFive {

    /*Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not. */

    public static boolean  happyNumber(int n)
    {
        boolean result = false;
        int sum = 0,r;
        while(n!=1)
        {
            r = n%10;
            sum += r * r;
            n = n/10;

        }
        if(n==1)
        {
            result = true;
        }

        return result;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("Is the number Happy :" + " " + happyNumber(num));


    }
}
