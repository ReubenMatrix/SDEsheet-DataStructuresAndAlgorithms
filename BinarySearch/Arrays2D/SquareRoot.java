package BinarySearch.Arrays2D;

/*
You are given a positive integer n.
Your task is to find and return its square root. If ‘n’ is not a perfect square, then return the floor value of ‘sqrt(n)’.

Example :
Input Format: n = 36
Result: 6
6 is the square root of 36.
 */
public class SquareRoot {
    public static void main(String[] args) {
        int n=65;
        System.out.println("The square root of " +n+ " is: "+bruteSolution(n));

        int x=16;
        System.out.println("The square root of " +x+ " is: "+OptimalSolution(x));

    }

    static int bruteSolution(int n){
        int ans=0;
        for (int i = 0; i <= n; i++) {
            int val=i*i;
            if (val<=n){
                ans=i;
            }else {
                break;
            }
        }
        return ans;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)

    static int OptimalSolution(int n){
        int low=1;
        int high=n;
        while (low<=high){
            int mid=(low + high)/2;
            int val=mid*mid;
            if(val <= n){
                low=mid + 1;
            }
            else {
                high=mid-1;
            }
        }
        return high;
    }
    //Time Complexity: O(logN)
    //Space Complexity: O(1)
}
