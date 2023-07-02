package SlidingWindow.MediumProblems;

import java.util.HashSet;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example:
Input: s = "abcabcbb"
Output: 3
The answer is "abc", with the length of 3.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println("Longest Substring With No Repeated Characters: " +solution(s));

    }

    static int solution(String s){
        int n=s.length();
        int i=0,j=0;
        int length=0;

        HashSet<Character> set=new HashSet<>();

        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                length=Math.max(length,j-i);
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return length;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(N) -> Worst Case

}
