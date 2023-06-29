package Arrays.EasyProblems;

/*
You are given an array of integers, your task is to move all the zeros in the array to the end of the array 
and move non-negative integers to the front by maintaining their order.

Input: 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
*/
public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] arr={0, 1, 4, 0, 8, 7, 0, 2};
        solution(arr);

    }
    static void solution(int[] arr){
        int n= arr.length;
        int left=0;
        int right=1;
        while (right<n){
            if(arr[left]!=0){
                left++;
                right++;
            } else if (arr[right]==0) {
                right++;
            }else {
                int temp=arr[right];
                arr[right]=arr[left];
                arr[left]=temp;
            }
        }
        for (int i = 0; i <n ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
