package NeetCode150.stacks;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {22,21,20};
        System.out.println(Arrays.toString(dailyTemp(temperatures)));

    }
    private static int[] dailyTemp(int[] temperatures){
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i=0;i< temperatures.length;i++){
            if (stack.isEmpty()){
                stack.push(new int[]{i,temperatures[i]});
            }else{
                while (!stack.isEmpty()){
                    if (temperatures[i] > stack.peek()[1]){
                        result[stack.peek()[0]] = i - stack.peek()[0];
                        stack.pop();
                    }else{
                        break;
                    }
                }
                stack.push(new int[]{i,temperatures[i]});
            }
        }
        return result;
    }
}
