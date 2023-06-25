package Arrays.EasyProblems;

public class CheckSortedArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(bruteSolution(arr));
        System.out.println(OptimalSolution(arr));

    }

    static boolean bruteSolution(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[j]<arr[i]){
                    return false;
                }
            }
        }
        return true;
    }
    //Time Complexity:O(N²)
    //Space Complexity:O(1)

    static boolean OptimalSolution(int[] arr){
        for (int i = 1; i < arr.length ; i++) {
            if(arr[i]>arr[i-1]){
                return true;
            }
        }
        return false;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)

}
