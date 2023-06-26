package Arrays.EasyProblems;

public class LeftRotateArrayByOne {
    public static void main(String[] args) {
        int[] arr={1, 4, 2, 7, 9};
        BruteSolution(arr);

        int[] arr2={4, 5, 6, 7, 8, 9, 10};
        OptimalSolution(arr2);
    }
    static void BruteSolution(int[] arr){
        int n= arr.length;
        int[] temp=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            temp[i-1]=arr[i%n];
        }
        System.out.println("The Rotated Array Is:");
        for (int i = 0; i <n ; i++) {
            System.out.print(temp[i]+" ");
        }
    }
    //Time Complexity:O(N)
    //Space Complexity:O(N)

    static void OptimalSolution(int[] arr){
        int n= arr.length;
        int temp=arr[0];
        for (int i = 0; i <n-1 ; i++) {
            arr[i]=arr[i+1];
        }
        arr[n-1]=temp;
        System.out.println("\nThe Rotated Array Is: ");
        for (int i = 0; i <n ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)
}
