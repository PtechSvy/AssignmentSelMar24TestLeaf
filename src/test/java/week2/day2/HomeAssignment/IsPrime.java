package week2.day2.HomeAssignment;

import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int num = sc.nextInt();
		
		for(int i = 2;i<=num-1;i++)
		{
			if(num%i==0)
			{
				System.out.println("The number is non prime");
				break;
			}
			else
			{
				System.out.println("The number is prime");
				break;
			}
		}

	}

}
