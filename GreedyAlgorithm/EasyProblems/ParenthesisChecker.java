package GreedyAlgorithm.EasyProblems;

import java.util.Stack;
/*
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

Input: s = "(*)"
Output: true
 */

public class ParenthesisChecker {
    public static void main(String[] args) {
        String name=new String("(()");
        System.out.println(solution(name));

    }

    static boolean solution(String S){
        Stack<Integer> paranthesisStack=new Stack<>();
        Stack<Integer> starStack=new Stack<>();

        for (int i = 0; i <S.length() ; i++) {
            if(S.charAt(i)=='('){
                paranthesisStack.push(i);
            } else if (S.charAt(i)==')') {
                if (!paranthesisStack.isEmpty()){
                    paranthesisStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                }
                else {
                    return false;
                }
            }
            else {
                starStack.push(i);
            }

        }

        while(!paranthesisStack.isEmpty()){
            if(starStack.isEmpty()){
                return false;
            }
            if(starStack.peek()<paranthesisStack.peek()){
                return false;
            }
            paranthesisStack.pop();
            starStack.pop();
        }
        return true;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(N)
}
