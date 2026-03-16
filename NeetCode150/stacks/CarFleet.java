package NeetCode150.stacks;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public static void main(String[] args) {
        int target = 10;
        int[] position = {0,4,2};
        int[] speed = {2,1,3};
        System.out.println(carFleet(target,position,speed));
    }
    private static int carFleet(int target, int[] position, int[] speed){
        int n = position.length;
        double[][] cars = new double[n][2];
        for(int i=0;i<n;i++){
            cars[i][0] = position[i];
            cars[i][1] = (double) (target-position[i])/speed[i];
        }
        Arrays.sort(cars,(a,b)->Double.compare(b[0],a[0]));

        Stack<Double> stack = new Stack<>();

        for (double[] pos : cars){
            if (stack.isEmpty() || pos[1] > stack.peek()){
                stack.push(pos[1]);
            }
        }
        return stack.size();
    }
}
