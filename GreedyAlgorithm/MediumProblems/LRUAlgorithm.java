package GreedyAlgorithm.MediumProblems;

/*
Given a sequence of pages in an array pages[] of length N and memory capacity C,
find the number of page faults using Least Recently Used (LRU) Algorithm.

Example :
N = 9, C = 4
pages = {5, 0, 1, 3, 2, 4, 1, 0, 5}
Output: 8
 */

import java.util.*;

public class LRUAlgorithm {
    public static void main(String[] args) {
        int[] pages = {5, 0, 1, 3, 2, 4, 1, 0, 5};
        int capacity = 4;

        int pageFaults = solution(pages, capacity);
        System.out.println("Number of page faults: " + pageFaults);
    }

    static int solution(int[] pages, int capacity){
        HashSet<Integer> set=new HashSet<>();
        ArrayList<Integer> list=new ArrayList<>();
        int pagefault=0;

        for(int page:pages){
            if(!set.contains(page)){
                if(set.size()==capacity){
                    int leastRecentlyUsedPage= list.get(0);
                    set.remove(leastRecentlyUsedPage);
                    set.remove(0);
                }
                set.add(page);
                list.add(page);
                pagefault++;
            }
            else {
                list.remove(Integer.valueOf(page));
                list.add(page);
            }
        }
        return pagefault;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(C)     C -> length of capacity
}