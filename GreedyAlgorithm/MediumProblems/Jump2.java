package GreedyAlgorithm.MediumProblems;

/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i],
you can jump to any nums[i + j] where:
 1. 0 <= j <= nums[i] and
 2. i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

Input: nums = [2,3,1,1,4]
Output: 2
The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */


public class Jump2 {
    public static void main(String[] args) {
        int[] arr={2, 3, 1, 1, 4};
        System.out.println("No. Of Jumps: "+solution(arr));

    }

    static int solution(int[] arr){
        int n= arr.length;
        int jumps=0;
        int farthestJump=0;
        int currentJump=0;

        for (int i = 0; i < n-1; i++) {
            farthestJump=Math.max(farthestJump, i+arr[i]);

            if(i==currentJump){
                jumps++;
                currentJump=farthestJump;
            }
        }

        return jumps;
    }

    //Time Complexity:O(N)
    //Space Complexity:O(1)
}
