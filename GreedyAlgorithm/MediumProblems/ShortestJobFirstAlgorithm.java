package GreedyAlgorithm.MediumProblems;

/*
Given an array of integers bt of size n. Array bt denotes the burst time of each process. Calculate the average waiting time of all the processes

Example :
Input:
n = 5
bt = [4,3,7,1,2]
Output: 4
Explanation: After sorting burst times by shortest job policy, calculated average waiting time is 4.
 */
import java.util.Arrays;

public class ShortestJobFirstAlgorithm {
    public static void main(String[] args) {
        int[] bt = {4,3,7,1,2};
        System.out.println("Average Waiting Time: "+WaitingTimeCalculator(bt));
    }

    static int WaitingTimeCalculator(int[] BurstTime){
        int n= BurstTime.length;
        int[] SortedBurstTime=Arrays.copyOf(BurstTime,n);
        Arrays.sort(SortedBurstTime);
        int WaitingTime=0;
        int TotalWaitingTime=0;

        System.out.print("Waiting Time \t Burst Time");
        System.out.println();
        for (int i = 0; i <n ; i++) {
            TotalWaitingTime+=WaitingTime;
            WaitingTime+=SortedBurstTime[i];
            System.out.print(WaitingTime+"\t\t\t\t"+SortedBurstTime[i]);
            System.out.println();
        }

        return TotalWaitingTime/n;
    }
    //Time Complexity:O(N logN)
    //Space Complexity:O(N)
}
