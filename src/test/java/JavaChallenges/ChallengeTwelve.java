package JavaChallenges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChallengeTwelve {
    /*
    Given an array of integers arr, return true if the number of occurrences of each value in
     the array is unique, or false otherwise.
Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
     */

    public static boolean checkUniqueFrequency(int n,int[]arr)
    {

        HashMap<Integer,Integer> val = new HashMap<>();
        for(int i = 0;i<n;i++) {
            val.put(arr[i], val.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> val1 = new HashSet<>();
        for(Map.Entry<Integer,Integer>entry:val.entrySet())
        {
            val1.add(entry.getValue());

        }


        return val1.size()==val.size();
    }

    public static void main(String[] args) {
        int[]ar = {1,2,2,1,1,3};
        int n = ar.length;
        if(checkUniqueFrequency(n,ar))
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }
}
