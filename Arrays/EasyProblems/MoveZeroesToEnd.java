package Arrays.EasyProblems;

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
