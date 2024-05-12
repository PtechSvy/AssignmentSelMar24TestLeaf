package JavaChallenges;

import java.util.*;
import java.util.stream.Collectors;

public class ChallengeSeven {
    //Given an integer array nums,
    // return true if any value appears at least twice in the array, and return false if every element is distinct.
    //Example 1:
    //Input: nums = [1,2,3,1]
    //Output: true

    public static boolean duplicateNumVerify(int[] val)
    {
        boolean result = false;
       // List<Integer> numbers = new ArrayList<>();
        //convert array into list
     //   numbers = Arrays.stream(val).boxed().collect(Collectors.toList());
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i<val.length;i++){
            set.add(val[i]);
        }

        // if it contains duplicate then the size of
        // set will not equal to the length
        // of the array
        if(set.size() < val.length)
            result = true;

        return result;
    }

    /*without using set

    public boolean containsDuplicate(int[] nums) {

        // sorting the array
        Arrays.sort(nums);

        for(int index = 1; index < nums.length; index++) {
            if(nums[index ] == nums[index - 1]) {
                return true;
            }
        }

        return false;
    }
     */
    public static void main(String[] args) {

        int[] providedInput = {1,2,3,1};
        System.out.println("Array contains duplicate values:"+" " + duplicateNumVerify(providedInput) );

    }
}
