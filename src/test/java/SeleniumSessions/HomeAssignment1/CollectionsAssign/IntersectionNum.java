package SeleniumSessions.HomeAssignment1.CollectionsAssign;

import java.util.*;

public class IntersectionNum {

    public static List<Integer>intersection(int[]arr1 ,int[]arr2)
    {
        Set<Integer> number1 = new HashSet<>();
        for(int num : arr1)
        {
            number1.add(num);
        }

        List<Integer> interSectionList = new ArrayList<>();
        for(int num : arr2)
        {
            if(number1.contains(num) && !interSectionList.contains(num))
            {
                interSectionList.add(num);
            }
        }
        return interSectionList;
    }

    public static void main(String[] args) {

        int[] num1 = {3, 2, 11, 4, 6, 7};
        int[] num2 = {1, 2, 8, 4, 9, 7};

        List<Integer> interResult = intersection(num1,num2);
        System.out.println("Intersection values are"+" " + interResult);

    }
}
