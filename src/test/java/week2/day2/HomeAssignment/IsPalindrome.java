package week2.day2.HomeAssignment;

import java.util.Scanner;

public class IsPalindrome {
	
	static int reversNumber(int n)
    {
        int reversed_n = 0;
        while (n > 0) {
            reversed_n = reversed_n * 10 + n % 10;
            n = n / 10;
        }
        return reversed_n;
    }
 
    // Main function
    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the number : ");
       int n = sc.nextInt();
        int reverseN = reversNumber(n);
        System.out.println("Reverse of n = " + reverseN);
 
        // Checking if n is same
        // as reverse of n
        if (n == reverseN)
            System.out.println("Palindrome = Yes");
        else
            System.out.println("Palindrome = No");
    }
	

}
