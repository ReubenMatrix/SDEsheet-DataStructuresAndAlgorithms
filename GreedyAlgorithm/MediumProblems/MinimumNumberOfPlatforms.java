package GreedyAlgorithm.MediumProblems;

/*
We are given two arrays that represent the arrival and departure times of trains that stop at the platform.
We need to find the minimum number of platforms needed at the railway station so that no train has to wait.

Examples :
Input: N=6,
arr[] = {9:00, 9:45, 9:55, 11:00, 15:00, 18:00}
dep[] = {9:20, 12:00, 11:30, 11:50, 19:00, 20:00}
Output:3
 */

import java.util.Arrays;

public class MinimumNumberOfPlatforms {
    public static void main(String[] args) {
        int[] arr={900, 945, 955, 1100, 1500, 1800};
        int[] dep={920, 1200, 1130, 1150, 1900, 2000};

        System.out.println("Number Of Platforms Required: "+BruteSolution(arr,dep,6));

        System.out.println("Number Of Platforms Required: "+OptimalSolution(arr,dep,6));

    }

    static int BruteSolution(int[] arrival, int[] departure,int n){
        int ans=1;
        for (int i = 0; i <n ; i++) {
            int count=1;
            for (int j = i+1; j <n ; j++) {
                if( arrival[i]>=arrival[j] && arrival[i]<=departure[j] || arrival[j]>=arrival[i] && arrival[j]<=departure[i]){
                    count++;
                }
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
    //Time Complexity:O(N²)
    //Space Complexity:O(1)

    static int OptimalSolution(int[] arrival,int[] departure,int n){
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int result=1;
        int platform=1;
        int i=1,j=0;

        while(i<n && j<n){
            if(arrival[i]<=departure[j]){
                platform++;
                i++;
            } else if (arrival[i]>departure[j]) {
                platform--;
                j++;
            }
            if(platform>result){
                result=platform;
            }
        }
        return result;
    }
    //Time Complexity:O(N logN)
    //Space Complexity:O(1)
}
