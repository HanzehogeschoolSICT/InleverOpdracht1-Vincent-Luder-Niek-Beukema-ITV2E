package model;

public class MergeSort {
    /** The method for sorting the numbers */
    public static boolean sortArray(int[] list, boolean status) {
        boolean isSorted = status;
        if (list.length > 1) {// Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            sortArray(firstHalf, isSorted);
            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            sortArray(secondHalf, isSorted);
            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
        return false;
    }
    /** Merge two sorted lists */
    public static void merge(int[] list1, int[] list2, int[] temp){
        int current1 = 0; // Current
        int current2 = 0; // Current
        int current3 = 0; // Current

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }
        while (current1 < list1.length)
            temp[current3++] = list1[current1++];
        while (current2 < list2.length)
            temp[current3++] = list2[current2++];

    }
}