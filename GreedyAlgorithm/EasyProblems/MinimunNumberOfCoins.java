package GreedyAlgorithm.EasyProblems;

import java.util.Vector;
/*
Given a value V, if we want to make a change for V Rs,
and we have an infinite supply of each of the denominations in Indian currency, i.e.,
we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes,
what is the minimum number of coins and/or notes needed to make the change.

Input: V = 70
Output: 2
Explaination: We need a 50 Rs note and a 20 Rs note.
 */

public class MinimunNumberOfCoins {
    public static void main(String[] args) {
        int[] arr={1,2,5,10,20,50,100,500,1000};
        solution(arr,49);
    }

    static void solution(int[] arr,int v){
        Vector<Integer> ans=new Vector<>();
        for (int i = arr.length-1; i >=0 ; i--) {
            while (v>=arr[i]){
                v-=arr[i];
                ans.add(arr[i]);
            }
        }
        for (int i = 0; i <ans.size() ; i++) {
            System.out.print(" "+ans.elementAt(i));

        }
    }
    //Time complexity:O(V)
    //Space complexity:O(1)
}
