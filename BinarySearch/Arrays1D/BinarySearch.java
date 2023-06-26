package BinarySearch.Arrays1D;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={3,5,6,8,10,15};
        System.out.println(IterativeBinarySearch(arr,10));
        System.out.println(RecursiveBinarySearch(arr,0, arr.length, 10));

    }

    static int IterativeBinarySearch(int[] arr,int target){
        int n=arr.length;
        int low=0;
        int high=n-1;
        while (low<=high){
            int mid=(low + high)/2;
            if(arr[mid]==target){
                return mid;
            } else if (target>arr[mid]) {
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
    //Time Complexity:O(logN)

    static int RecursiveBinarySearch(int[] arr,int low,int high,int target){
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(arr[mid]==target){
            return mid;
        } else if (target>arr[mid]) {
           return RecursiveBinarySearch(arr,mid+1,high,target);
        }
        return RecursiveBinarySearch(arr,low,mid-1,target);

    }
}
