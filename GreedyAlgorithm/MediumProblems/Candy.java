package GreedyAlgorithm.MediumProblems;
/*
There are N children standing in a line. Each child is assigned a rating value given in the integer array ratings.
You are giving candies to these children subjected to the following requirements:
    1. Each child must have atleast one candy.
    2. Children with a higher rating get more candies than neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Examle:
N = 3  ratings [ ] = {1, 0, 2}
Output: 5
Explanation:
You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 */

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int[] ratings= {1, 0, 2};
        System.out.println("No. Of Candies Required: "+solution(ratings));

    }

    static int solution(int[] ratings){
        int n= ratings.length;

        int[] candies=new int[n];
        Arrays.fill(candies,1);

        for (int i = 1; i <n ; i++) {
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }

        for (int i = n-2; i >=0 ; i--) {
            if(ratings[i]>ratings[i+1]){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            }
        }
        int totalcandies=0;
        for (int i = 0; i <n ; i++) {
            totalcandies+=candies[i];
        }

        return totalcandies;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(N)
}
