package NeetCode150.slidingWindow;

import java.util.*;

public class PracticeStatic {
    public static void main(String[] args) {
//        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
//        System.out.println(firstNegInt(arr,3));

//        int[] arr = {100,200,300,400};
//        System.out.println(maxSubarraySum(arr,2));

//        String txt = "aabaabaa";
//        String pat = "aaba";
//        System.out.println(search(pat,txt));
        int[] nums = {-7,-8,7,5,7,1,6,0};
        int k = 4;
        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }
    private static int[] maxSlidingWindow(int[] nums, int k){
        int i=0,j=0;
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> quee = new ArrayDeque<>();

        while (j<nums.length){
            if (quee.isEmpty()){
                quee.offerFirst(nums[j]);
            }else{
                while(!quee.isEmpty()){
                    if (quee.peekLast() >= nums[j]){
                        break;
                    }else{
                        quee.pollLast();
                    }
                }
                quee.offerLast(nums[j]);
            }
            if (j-i+1 == k){
                ans[i] = quee.peekFirst();
                if(nums[i] == quee.peekFirst()){
                    quee.pollFirst();
                }
                i++;
            }
            j++;
        }
        return ans;
    }
    private static List<Integer> search(String pat, String txt){
        List<Integer> count = new ArrayList<>();
        int i=0,j=0;
        HashMap<Character,Integer> patMap = new HashMap<>();
        for (Character ch : pat.toCharArray()){
            patMap.put(ch, patMap.getOrDefault(ch,0)+1);
        }
        while (j<txt.length()){
            if (patMap.containsKey(txt.charAt(j))){
                patMap.put(txt.charAt(j),patMap.get(txt.charAt(j))-1);
            }
            if (j-i+1 == pat.length()){
                boolean flag = true;
                for (Integer value: patMap.values()){
                    if (value != 0){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    count.add(i);
                }
                if (patMap.containsKey(txt.charAt(i))){
                    patMap.put(txt.charAt(i), patMap.get(txt.charAt(i))+1);
                }
                i++;
            }
            j++;
        }
        return count;
    }

    private static int maxSubarraySum(int[] arr, int k) {
        int i=0,j=0;
        int best = 0;
        int curr = 0;
        while (j<arr.length){
            curr = curr + arr[j];
            if ((j - i + 1) == k) {
                best = Math.max(best, curr);
                curr = curr - arr[i];
                i++;
            }
            j++;
        }
        return best;
    }
    private static List<Integer> firstNegInt(int[] arr, int k){
        List<Integer> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        int i = 0,j=0;

        while (j<arr.length){
            if (arr[j] < 0){
                tempList.add(arr[j]);
            }
            if ((j - i + 1) == k) {
                if (tempList.isEmpty()) {
                    result.add(0);
                } else {
                    result.add(tempList.getFirst());
                    if (tempList.getFirst() == arr[i]) {
                        tempList.removeFirst();
                    }
                }
                i++;
            }
            j++;
        }
        return result;
    }
}
