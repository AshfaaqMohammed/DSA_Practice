package NeetCode150.slidingWindow;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {10,1,5,6,7,1};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices){
        int maxP=0;
        int l=0;
        int r = 1;

        while(r < prices.length){
            if (prices[r] > prices[l]){
                maxP = Math.max(maxP,prices[r]-prices[l]);
            }else{
                l = r;
            }
            r++;
        }
        return maxP;
    }

    private static int bruteForce(int[] prices){
        int maxP = 0;
        for (int i=0;i<prices.length;i++){
            int curr = prices[i];
            for (int j=i+1;j<prices.length;j++){
                maxP = Math.max(maxP,prices[j]-curr);
            }
        }
        return maxP;
    }
}
