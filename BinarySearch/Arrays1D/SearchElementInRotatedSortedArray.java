package BinarySearch.Arrays1D;

/*
Given an integer array arr of size N, sorted in ascending order (with distinct values) and a target value k.
Now the array is rotated at some pivot point unknown to you.
Find the index at which k is present and if k is not present return -1.

Example:
Input: arr = [4,5,6,7,0,1,2,3], x = 0
Result: 4
 */

import java.util.ArrayList;
import java.util.Arrays;

public class SearchElementInRotatedSortedArray {
    public static void main(String[] args) {
        ArrayList <Integer> arr=new ArrayList<>(Arrays.asList(1, 2, 5, 7, 8, 10, 13, 15));
        int ans=bruteSolution(arr, 10);
        if(ans==-1){
            System.out.println("Target Not Found !");
        }else {
            System.out.println("Target at Position " +ans);
        }


        ArrayList <Integer> arr2=new ArrayList<>(Arrays.asList(1, 2, 5, 7, 8, 10, 13, 15));
        int ans2=OptimalSolution(arr2, 5);
        if(ans2==-1){
            System.out.println("Target Not Found !");
        }else {
            System.out.println("Target at Position " +ans2);
        }


    }

    static int bruteSolution(ArrayList<Integer> arr, int x){
        int n= arr.size();
        for (int i = 0; i < n; i++) {
            if(arr.get(i)==x){
                return i;
            }
        }
        return -1;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)

    static int OptimalSolution(ArrayList<Integer> arr,int x){
        int n= arr.size();
        int low=0;
        int high=n-1;

        while (low<=high){
            int mid=(low + high)/2;

            if(arr.get(mid)==x){
                return mid;
            }

            if(arr.get(low)<= arr.get(mid)){
                if(arr.get(low)<=x && x<=arr.get(mid)){
                    high=mid-1;
                }
                else {
                    low=mid+1;
                }
            }else {
                if(arr.get(mid)<=x && x<=arr.get(high)){
                    low=mid+1;
                }
                else {
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
