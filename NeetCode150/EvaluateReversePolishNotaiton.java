package NeetCode150;

import java.util.Stack;

public class EvaluateReversePolishNotaiton {
    public static void main(String[] args) {
        String[] tokens = {"1","2","+","3","*","4","-"};
        System.out.println(evalRPN(tokens));
    }

    private static int evalRPN(String[] tokens){
        String defaultSigns = "+-*/";
        Stack<Integer> nums = new Stack<>();
        int result;
        for (String token : tokens){
            if (defaultSigns.contains(token)){
                int first = nums.pop();
                int second = nums.pop();
                result = switch (token) {
                    case "+" -> first + second;
                    case "-" -> second - first;
                    case "*" -> first * second;
                    case "/" -> second / first;
                    case null, default -> 0;
                };
                nums.push(result);
            }else {
                nums.push(Integer.parseInt(token));
            }
        }
        return nums.peek();
    }
}
