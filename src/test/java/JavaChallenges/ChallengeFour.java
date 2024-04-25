package JavaChallenges;

public class ChallengeFour {
    /* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
Example 1:
Input: nums = [2,2,1]
Output: 1*/

    public static void main(String[] args) {

        int[] nums = {2,2,1};
        int result = 0;
        for(int i : nums)
        {
           result ^= i;//^ means (bitwise XOR) - Binary XOR Operator copies the bit if it is set in one operand but not both.
        }

        System.out.println("The unique number in the array is : " + result);

    }
}
