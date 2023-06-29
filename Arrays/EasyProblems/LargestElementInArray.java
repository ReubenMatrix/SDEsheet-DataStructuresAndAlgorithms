package Arrays.EasyProblems;

/*
 Given an array, we have to find the largest element in the array.

 Example :
Input: arr[] = {2,5,1,3,0};
Output: 5
*/

import java.util.Arrays;

public class LargestElementInArray {
    public static void main(String[] args) {
        int[] arr={4,7,1,2,9,3};
        System.out.println("Largest Element In The Array is: "+bruteSolution(arr));
        System.out.println("Largest Element In The Array is: "+optimalSolution(arr));

    }

    static int bruteSolution(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
    //Time Complexity:O(N*logN)
    //Space Complexity:O(N)

    static int optimalSolution(int[] arr){
        int max=arr[0];
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)
}
