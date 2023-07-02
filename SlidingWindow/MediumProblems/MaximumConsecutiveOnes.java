package SlidingWindow.MediumProblems;

/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array
if you can flip at most k 0's.

Example:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,(1),1,1,1,1,(1)]
 */

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println("Maximum Consecutive Ones: "+solution(arr,k));

    }

    static int solution(int[] arr,int k){
        int n= arr.length;
        int zeroCount=0;
        int consecutiveOnes=0;
        int left=0;
        for (int right = 0; right < n; right++) {
            if(arr[right]==0){
                zeroCount++;
            }

            while (zeroCount>k){
                if(arr[left]==0){
                    zeroCount--;
                }
                left++;
            }
            consecutiveOnes=Math.max(consecutiveOnes,right-left+1);
        }
        return consecutiveOnes;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)
}
