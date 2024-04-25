package JavaChallenges;

import java.util.Scanner;

public class ChallengeTwo {
    /*
    Given a non-negative integer x, compute and return the square root of x.
Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
Example 1:
Input: x = 4
Output: 2
Example 2:
     */

    public static int squareRootNum(double num)
    {
        double result;
        double squareRoot = num/2;
       do
        {
          result = squareRoot;
          squareRoot = (result + (num/result))/2;
        }
       while((result - squareRoot)!=0);

            return (int)squareRoot;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double val = sc.nextDouble();
        System.out.println("The sqrt value of number is :" + " " + squareRootNum(val) );
    }
}
