package com.personal;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by pr250155 on 2/13/16.
 */
public class StockProfitMax {
    public static void main(String[] args) {
        int[] stockPrices = {100, 180, 260, 310, 40, 535, 695};
        int answer = new StockProfitMax().maxProfit(stockPrices);
        System.out.println(answer);
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int minElement = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            profit = Math.max(profit, prices[i]-minElement);
            minElement = Math.min(minElement, prices[i]);
        }
        return profit;
    }


}
