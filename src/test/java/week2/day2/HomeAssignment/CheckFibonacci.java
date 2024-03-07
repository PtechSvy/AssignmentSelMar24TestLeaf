package week2.day2.HomeAssignment;

import java.util.Scanner;

public class CheckFibonacci {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = sc.nextInt();
		int sum = 0, a=1, b= 0;
		//fibonacci series - – 0, 1, 1, 2, 3, 5, 8, and 13.
	  System.out.println(b + " ");
		for (int i = 0 ;i<=n;i++)
		{
				
         sum = a + b;
         System.out.println(" " + sum);
         a = b;
         b = sum;
        
			
		}

	}

}
