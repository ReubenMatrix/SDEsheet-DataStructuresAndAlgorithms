package GreedyAlgorithm.MediumProblems;

/*
You are given a set of N jobs where each job comes with a deadline and profit.
The profit can only be earned upon completing the job within its deadline.
Find the number of jobs done and the maximum profit that can be obtained.
Each job takes a single unit of time and only one job can be performed at a time.

Example :
Input: N = 4, Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
Output: 2 60
The 3rd job with a deadline 1 is performed during the first unit of time .The 1st job is performed during the second unit of time as its deadline is 4.
Profit = 40 + 20 = 60
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class job{
    int id;
    int profit;
    int deadline;
    job(int x, int y, int z){
        this.id=x;
        this.deadline=y;
        this.profit=z;
    }
}

public class JobSequencing {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number Of Jobs: ");
        int x= sc.nextInt();
        job[] arr=new job[x];

        for (int i = 0; i < x; i++) {
            System.out.println("Enter details for Job " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            System.out.print("Deadline: ");
            int deadline = sc.nextInt();
            System.out.print("Profit: ");
            int profit = sc.nextInt();
            arr[i] = new job(id, deadline, profit);
        }

        int[] result = solution(arr);
        System.out.println("Job Sequence:"+Arrays.toString(result));



    }

    static int[] solution(job[] arr){
        int n= arr.length;
        Arrays.sort(arr,(a,b)->(b.profit-a.profit));

        int max=0;
        for (int i = 0; i <n ; i++) {
            if(arr[i].deadline>max){
                max=arr[i].deadline;
            }
        }

        int[] result=new int[max+1];

        for (int i = 0; i <= max; i++) {
            result[i]=-1;
        }

        int jobcount=0;
        int totalprofit=0;

        for (int i = 0; i < n ; i++) {
            for (int j =arr[i].deadline ; j >0 ; j--) {
                if (result[j]==-1){
                    result[j]=i;
                    jobcount++;
                    totalprofit+=arr[i].profit;
                    break;
                }

            }
        }

        int[] ans=new int[2];
        ans[0]=jobcount;
        ans[1]=totalprofit;

        return ans;
    }
    //Time Complexity: O(N log N) + O(N*M)         M: no. of deadlines
    //Space Complexity:O(M)

}
