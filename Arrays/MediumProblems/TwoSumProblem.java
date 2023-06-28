package Arrays.MediumProblems;

/*
Problem Statement: Given an array of integers arr[] and an integer target.
                   Return indices of the two numbers such that their sum is equal to the target.
                   Otherwise, we will return {-1, -1}.

Example 1:
Input Format: arr[] = {2,6,5,8,11}, target = 14
Result: [1, 3]
 */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumProblem {
    public static void main(String[] args) {
        int[] arr={2, 6 ,5, 8, 11};
        int target=14;
        System.out.println(Arrays.toString(BruteSolution(arr, target)));

        int[] arr2={4, 6, 7, 5, 1};
        int target2=10;
        System.out.println(Arrays.toString(BetterSolution(arr2,target2)));

        int[] arr3={4, 6, 7, 5, 1};
        int target3=10;
        System.out.println(Arrays.toString(OptimalSolution(arr3,target3)));


    }

    static int[] BruteSolution(int[] arr, int target){
        int[] ans=new int[2];
        int n=arr.length;

        ans[0]=ans[1]=-1;

        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j <n ; j++) {
                if(arr[i]+arr[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }
        return ans;
    }
    //Time Complexity:O(N²)
    //Space Complexity:O(1)

    static int[] BetterSolution(int[] arr, int target){
        int n=arr.length;
        
        int[] ans=new int[2];
        ans[0]=ans[1]=-1;

        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i <n ; i++) {
            int x=arr[i];
            int need=target-x;
            if(map.containsKey(need)){
                ans[0]=map.get(need);
                ans[1]=i;
            }
            map.put(arr[i],i);
        }
        return ans;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(N)

    static int[] OptimalSolution(int[] arr, int target){
        int n=arr.length;
        int left=0;
        int right=n-1;

        Arrays.sort(arr);

        int[] ans=new int[2];
        ans[0]=ans[1]=-1;

        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum==target){
                ans[0]=arr[left];
                ans[1]=arr[right];
                return ans;
            }
            else if(sum< target){
                left++;
                right--;
            }
        }
        return ans;
    }
  //Time Complexity:O(N)
  //Space Complexity:O(1)

}
