package Arrays.EasyProblems;
/*
 Given an integer array sorted in non-decreasing order, remove the duplicates in place such that each unique element appears only once. 
 The relative order of the elements should be kept the same.

Example : 
Input: arr[1,1,2,2,2,3,3]
Output: arr[1,2,3]
*/

import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr={3, 3, 4, 5, 6, 6, 8, 9};
        int x=BruteSolution(arr);
        System.out.println("Array After Eliminating Duplicates:");
        for (int i = 0; i <x ; i++) {
            System.out.print(arr[i]+" ");
        }

        int[] arr2 = {1, 1, 1, 2, 3, 7, 10, 11, 11};
        int y = OptimalSolution(arr2);
        System.out.println("\nArray After Eliminating Duplicates:");
        for (int j = 0; j < y; j++) {
            System.out.print(arr2[j] + " ");
        }
    }

    static int BruteSolution(int[] arr){
        if(arr.length==0){
            return 0;
        }
        HashSet<Integer> set=new HashSet<>();

        for (int i = 0; i < arr.length ; i++) {
            set.add(arr[i]);
        }
        int k= set.size();
        int j=0;
        for(int x:set){
            arr[j++]=x;
        }
        return k;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(N)

    static int OptimalSolution(int[] arr){
        if(arr.length==0){
            return 0;
        }
        int i=0;
        for (int j = 1; j < arr.length ; j++) {
            if(arr[i]!=arr[j]){
                i++;
                if (i != j) {
                    arr[i] = arr[j];
                }
            }
        }
        return i+1;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)

}
