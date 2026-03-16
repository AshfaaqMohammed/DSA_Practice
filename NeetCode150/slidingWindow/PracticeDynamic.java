package NeetCode150.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PracticeDynamic {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,3};
//        int k = 3;
//        System.out.println(subarraySum(nums,k));
//        String s = "aabaaab";
//        int k=2;
//        System.out.println(longestKSubstring(s,k));

//        String s = "pwwkew";
//        System.out.println(lengthOfLongestSubstring(s));
        String s = "OUZODYXAZV";
        String t = "XYZ";
        System.out.println(minWindow(s,t));

    }
    private static int subarraySum(int[] nums, int k){
        int i=0,j=0;
        int count=0,sum=0;
        while (j<nums.length){
            if (sum < k){
                sum+=nums[j];
                j++;
            }else if(sum == k){
                count++;
                j++;
            }
            else{
                while(sum > k){
                    sum = sum - nums[i];
                    i++;
                }
                j++;
            }
        }
        return count;
    }

    private static int longestKSubstring(String s,int k){
        int i=0,j=0;
        int ans = -1;

        HashMap<Character, Integer> count = new HashMap<>();

        while (j<s.length()){
            count.put(s.charAt(j),count.getOrDefault(s.charAt(j),0)+1);
            if (count.size() < k){
                j++;
            }else if(count.size() == k){
                ans = Math.max(ans,(j-i+1));
                j++;
            }else {
                while (count.size() > k){
                    count.put(s.charAt(i),count.get(s.charAt(i))-1);
                    if (count.get(s.charAt(i)) == 0){
                        count.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return ans;
    }

    private static int lengthOfLongestSubstring(String s){
        int i=0,j=0;
        int len = 0;

        Set<Character> track = new HashSet<>();

        while(j<s.length()){
            if (!track.contains(s.charAt(j))){
                track.add(s.charAt(j));
                len = Math.max(len,track.size());
            }else{
                while (track.contains(s.charAt(j))){
                    track.remove(s.charAt(i));
                    i++;
                }
                track.add(s.charAt(j));
            }
            j++;
        }
        return len;
    }

    private static String minWindow(String s, String t){
        int i=0,j=0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        HashMap<Character,Integer> tMap = new HashMap<>();
        for (Character ch : t.toCharArray()){
            tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        }

        int count = tMap.size();

        while(j<s.length()){
            if (tMap.containsKey(s.charAt(j))){
                tMap.put(s.charAt(j),tMap.get(s.charAt(j))-1);
                if (tMap.get(s.charAt(j)) == 0){
                    count--;
                }
            }
            while(count == 0){
                if (j-i+1 < minLen){
                    minLen = j-i+1;
                    start = i;
                }
                if (tMap.containsKey(s.charAt(i))){
                    tMap.put(s.charAt(i),tMap.get(s.charAt(i))+1);
                    if (tMap.get(s.charAt(i)) > 0){
                        count++;
                    }
                }
                i++;
            }
            j++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}
