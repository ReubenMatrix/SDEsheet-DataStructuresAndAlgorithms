package GreedyAlgorithm.MediumProblems;

/*
You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

Input: nums = [2,3,1,1,4]
Output: true
Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */

public class Jump1 {
    public static void main(String[] args) {
        int[] arr={2, 3, 1, 1, 4};
        System.out.println(solution(arr));
    }

    static boolean solution(int[] arr){
        int lastpos=arr.length-1;

        for (int i = arr.length-2; i >= 0 ; i--) {
            if(i+arr[i] >= lastpos){
                lastpos=i;
            }
        }
        return lastpos==0;
    }

}
