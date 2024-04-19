package SeleniumSessions.HomeAssignment1.CollectionsAssign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumFromList {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 10, 6, 8};
        Arrays.sort(arr1);

        // Initialize a list to store missing numbers
        List<Integer> missingNumbers = new ArrayList<>();

        // Iterate through the array to find missing numbers
        int expected = arr1[0]; // Start with the first element
        for (int num : arr1) {
            while (expected < num) {
                missingNumbers.add(expected);
                expected++;
            }
            expected++; // Move to the next expected number
        }

        // Print the missing numbers
        System.out.println("Missing numbers from the array: " + missingNumbers);


    }
}
