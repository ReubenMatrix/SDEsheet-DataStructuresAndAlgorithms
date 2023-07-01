package GreedyAlgorithm.MediumProblems;

/*
Given an array of intervals where intervals[i] = [starti, endi],
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
[1,3] can be removed and the rest of the intervals are non-overlapping.
 */

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals={
                {1,2},
                {2,3},
                {3,4},
                {1,3},
        };
        System.out.println("No. Of Intervals Removed: "+solution(intervals));

    }

    static int solution(int[][] intervals){
        int n= intervals.length;

        if(n==0){
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a->a[1]));

        int count=1;
        int end=intervals[0][1];

        for (int i = 1; i < n; i++) {
            if(intervals[i][0]>=end){
                count++;
                end=intervals[i][1];
            }
        }

        return intervals.length-count;
    }
    //Time Complexity: O(N logN)
    //Space Complexity: O(1)
}
