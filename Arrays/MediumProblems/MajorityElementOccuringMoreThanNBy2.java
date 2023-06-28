package Arrays.MediumProblems;

/*
Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array.

Example :
Input Format:  N = 7, nums[] = {2,2,1,1,1,2,2}
Result: 2

 */

import java.util.HashMap;
import java.util.Map;

public class MajorityElementOccuringMoreThanNBy2 {
    public static void main(String[] args) {
        int[] arr={2, 2, 1, 1, 1, 2, 2};
        int x=BruteSolution(arr);
        System.out.println("The Element Occuring More Than N/2 Times: "+x);

        int[] arr2={4, 4, 2, 4, 3, 4, 4, 3, 2, 4};
        int y=BetterSolution(arr2);
        System.out.println("The Element Occuring More Than N/2 Times: "+y);

        int[] arr3={4, 4, 2, 4, 3, 4, 4, 3, 2, 4};
        int z=OptimalSolution(arr3);
        System.out.println("The Element Occuring More Than N/2 Times: "+z);

    }

    static int BruteSolution(int[] arr){
        int n= arr.length;
        for (int i = 0; i <n ; i++) {
            int count=0;
            for (int j = 0; j <n ; j++) {
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>(n/2)){
                return arr[i];
            }
        }
        return -1;
    }
    //Time Complexity:O(N²)
    //Space Complexity:O(1)

    static int BetterSolution(int[] arr){
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i <n ; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }

        for(Map.Entry<Integer,Integer>i:map.entrySet()){
            if(i.getValue()>(n/2)){
                return i.getKey();
            }
        }
        return -1;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(N)

    static int OptimalSolution(int[] arr){
        int n=arr.length;
        int count=0;
        int element=0;

        for (int i = 0; i <n ; i++) {
            if(count==0){
                count=1;
                element=arr[i];
            } else if (element==arr[i]) {
                count++;
            }else {
                count--;
            }
        }

        int occurences=0;
        for (int i = 0; i <n ; i++) {
            if(arr[i]==element){
                occurences++;
            }
        }

        if (occurences >(n/2)){
            return element;
        }

        return -1;
    }
}
