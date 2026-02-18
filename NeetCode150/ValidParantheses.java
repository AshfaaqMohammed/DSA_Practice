package NeetCode150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParantheses {
    public static void main(String[] args) {
        System.out.println(isValid(")("));
    }
    public static boolean isValid(String s){

        String opening = "({[";
        String closing = ")}]";

        Stack<Character> stack = new Stack<>();

        for (Character ch : s.toCharArray()){
            if (opening.indexOf(ch) != -1){
                stack.push(ch);
            }else{
                if (stack.isEmpty()){
                    return false;
                }
                Character ele = stack.pop();
                if (opening.indexOf(ele) != closing.indexOf(ch)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
