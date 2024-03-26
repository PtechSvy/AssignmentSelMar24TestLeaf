package SeleniumSessions.HomeAssignment1.CollectionsAssign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingNumFromList {
//needs to be corrected
    public static void main(String[] args) {

        List<Integer> missnValues = new ArrayList<>();
        int[] arr1 = {1, 2, 3, 4, 10, 6, 8};
        for(int num:arr1)
        {
            missnValues.add(num);
        }

        Collections.sort(missnValues);
        int a,b;
        List<Integer> missListVal = new ArrayList<>();
       int val = missnValues.size();
       for(int i = 0 ;i<val;i++)
       {
           {
               a = missnValues.get(i)+1;
               b = missnValues.get(i);
               if(a!=b)
               {
                   missListVal.add(a);
               }
           }
       }
        System.out.println("Missing values in the list are" + " " + missListVal);

    }
}
