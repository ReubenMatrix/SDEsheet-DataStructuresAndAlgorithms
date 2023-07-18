package BinarySearch.Arrays1D;

public class LowerBound {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int x = 9;
        System.out.println("The Lower Bound is : "+solution(arr, x));

        int[] arr2 = {3, 5, 8, 15, 19};
        int y = 9;
        System.out.println("The Lower Bound is : "+optimalSolution(arr2, y));

    }

    static int solution(int[] arr, int x){
        int n= arr.length;
        for (int i = 0; i < n; i++) {
            if(arr[i]>=x){
                return i;
            }
        }
        return n;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)

    static int optimalSolution(int[] arr, int x){
        int n= arr.length;
        int high=n-1;
        int low=0;
        int ans=n;
        while (low <= high){
            int mid= (low+high)/2;

            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    //Time Complexity: O(logN)
    //Space Complexity: O(1)
}
