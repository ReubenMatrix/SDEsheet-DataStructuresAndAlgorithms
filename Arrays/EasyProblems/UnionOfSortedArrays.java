package Arrays.EasyProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UnionOfSortedArrays {
    public static void main(String[] args) {
        int[] arr1={3, 4, 1, 8, 9, 8};
        int[] arr2={9, 8, 3, 2, 9, 1};
        ArrayList<Integer>union=BruteSolution(arr1,arr2);
        System.out.println("Union Of Two Arrays:");
        for(int i:union){
            System.out.print(i+" ");
        }

        System.out.println(" ");

        int[] temp1={3, 4, 1, 8, 9, 8};
        int[] temp2={9, 8, 3, 2, 9, 1};
        ArrayList<Integer>unify=BetterSolution(temp1,temp2);
        System.out.println("Union Of Two Arrays:");
        for(int j:unify){
            System.out.print(j+" ");
        }

        System.out.println(" ");

        int[] set1={1, 2, 3, 4, 4, 7};
        int[] set2={5, 7, 8, 9, 9};
        ArrayList<Integer>unity=OptimalSolution(set1,set2);
        System.out.println("Union Of Two Arrays: "+unity);



    }

    static ArrayList<Integer> BruteSolution(int[] arr1, int[] arr2){
        HashMap<Integer,Integer> set=new HashMap<>();
        ArrayList<Integer> union=new ArrayList<>();

        int n= arr1.length;
        int m= arr2.length;
        for (int i = 0; i <n ; i++) {
            set.put(arr1[i],set.getOrDefault(arr1[i],0)+1);
        }

        for (int i = 0; i <m ; i++) {
            set.put(arr2[i], set.getOrDefault(arr2[i],0)+1);
        }

        for(int i: set.keySet()){
            union.add(i);
        }
        return union;
    }
    //Time Complexity:O( (N+M)log(N+M) )
    //Space Complexity:O(N+M)

    static ArrayList<Integer> BetterSolution(int[] arr1, int[] arr2){
        int n= arr1.length;
        int m= arr2.length;

        HashSet<Integer> set=new HashSet<>();
        ArrayList<Integer> union=new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i <m ; i++) {
            set.add(arr2[i]);
        }

        for(int val:set){
            union.add(val);
        }
        return union;
    }
    //Time Complexity:O( (N+M)log(N+M) )
    //Space Complexity:O(N+M)

    static ArrayList<Integer> OptimalSolution(int[] arr1, int[] arr2){
        int n=arr1.length;
        int m= arr2.length;

        ArrayList <Integer> union=new ArrayList<>();

        int i=0,j=0;
        int prev=Integer.MIN_VALUE;

        while(i<n && j<m){
            if(arr1[i]<=arr2[j]){
                if(arr1[i]!=prev) {
                    union.add(arr1[i]);
                    prev=arr1[i];
                }
                i++;
            }
            else {
                if(arr2[j]!=prev){
                    union.add(arr2[j]);
                    prev=arr2[j];
                }
                j++;
            }
        }

        while(i<n){
            if(arr1[i]!=prev) {
                union.add(arr1[i]);
                prev=arr1[i];
            }
            i++;
        }

        while(j<m){
            if(arr2[j]!=prev){
                union.add(arr2[j]);
                prev=arr2[j];
            }
            j++;
        }

        return union;
    }
    //Time Complexity:O(N+M)
    //Space Complexity:O(N+M)

}
