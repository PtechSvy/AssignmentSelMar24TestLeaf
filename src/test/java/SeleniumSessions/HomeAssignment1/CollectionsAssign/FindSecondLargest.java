package SeleniumSessions.HomeAssignment1.CollectionsAssign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargest {

    public static List<Integer> secondLargest(int[] arr1)
    {
        List<Integer> result = new ArrayList<>();
        for(int num : arr1)
        {
            result.add(num);
        }
        Collections.sort(result);

        return result;


    }
    public static void main(String[] args) {

        int[] num = {3, 2, 11, 4, 6, 7};
        List<Integer> resultList = secondLargest(num);
        System.out.println("Second Largest number is : " + " " + resultList.get(4));

    }
}
