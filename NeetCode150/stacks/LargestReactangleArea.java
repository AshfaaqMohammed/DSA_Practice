package NeetCode150.stacks;

import java.util.HashMap;
import java.util.Stack;

public class LargestReactangleArea {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(bruteForce(heights));
    }
    private static int largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i=0;i<=n;i++){
            int curr = (i == n) ? 0 : heights[i];

            while(!stack.isEmpty() && curr < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;
                maxArea = Math.max(maxArea,(height*width));
            }
            stack.push(i);
        }

        return maxArea;
    }
    private static int bruteForce(int[] heights){
        int maxArea = 0;
        int n = heights.length;

        for (int i =0;i<n;i++){
            int height = heights[i];
            int left = i;
            while (left-1 >=0 && heights[left-1] >= height){
                left--;
            }

            int right = i;
            while(right + 1 < n && heights[right+1] >= height){
                right++;
            }
            int width = right - left + 1;
            maxArea = Math.max(maxArea,(height*width));
        }


        return maxArea;
    }

    private HashMap<Character,Integer> helper(String string){
        HashMap<Character,Integer> map = new HashMap<>();
        for (char i : string.toCharArray()){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        return map;
    }
}
