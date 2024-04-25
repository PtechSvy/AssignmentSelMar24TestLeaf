package JavaChallenges;

import java.util.Arrays;
import java.util.List;

public class ChallengeSix {
    /*Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
Example 1:
Input: nums = [3,2,3]
Output: 3
Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2 */
    public static void main(String[] args) {

        int [] nums = {2,2,1,1,1,2,2};
        int maxCount = 0;
        int index = -1;
        for(int i =0;i< nums.length;i++)
        {
            int count = 0;

            for(int j = 0;j<nums.length;j++)
            {
                if(nums[i]==nums[j])
                {
                    count++;
                }
            }
            if(count>maxCount)
            {
                maxCount = count;
                index = i;
            }
        }



        if(maxCount>(nums.length)/2)
        {
            System.out.println("The majority element is :" + nums[index]);
        }

    }
}
