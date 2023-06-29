package Arrays.EasyProblems;

/*
Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.

Example:
Input: [1,2,4,7,7,5]
Output: Second Smallest : 2
	    Second Largest : 5
*/

import java.util.Arrays;

public class SecondSmallestAndSecondLargest {
    public static void main(String[] args) {
        int[] arr={5,0,2,8,7,4};
        bruteSolution(arr);
        OptimalSolution(arr);

    }

    static void bruteSolution(int[] arr){
        int n= arr.length;
        if(n==0){
            System.out.println("-1");
        }
        Arrays.sort(arr);
        System.out.println("Second Smallest Element Is: "+arr[1]);
        System.out.println("Second Largest Element Is: "+arr[n-2]);
    }
    //Time Complexity:O(N*logN)
    //Space Complexity:O(1)

    static void OptimalSolution(int[] arr){
        int small1=Integer.MAX_VALUE;
        int small2=Integer.MAX_VALUE;
        int large1=Integer.MIN_VALUE;
        int large2=Integer.MIN_VALUE;

        int n= arr.length;

        if(n==0){
            System.out.println("-1");
        }

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i]<small1){
                small2=small1;
                small1=arr[i];
            } else if (arr[i]<small2 && arr[i]!=small1) {
                small2=arr[i];
            }
        }

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i]>large1){
                large2=large1;
                large1=arr[i];
            } else if (arr[i]>large2 && arr[i]!=large1) {
                large2=arr[i];
            }
        }
        System.out.println("SECOND SMALLEST ELEMENT: "+small2);
        System.out.println("SECOND LARGEST ELEMENT: "+large2);
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)

}
