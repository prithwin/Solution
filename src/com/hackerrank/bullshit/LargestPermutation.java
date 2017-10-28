package com.hackerrank.bullshit;

import java.util.*;

/**
 * Created by prajeeva on 10/25/17.
 */
public class LargestPermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        int n = Integer.parseInt(firstLine.split("\\s")[0]);
        int m = Integer.parseInt(firstLine.split("\\s")[1]);
        List<String> nums = new ArrayList<>();
        List<String> smun = new ArrayList<>();
        Map<String, Integer> reg = new HashMap<>();
        int a = 0;
        for(String num : secondLine.split("\\s")) {
            nums.add(num);
            smun.add(num);
            reg.put(nums.get(a) , a);
            a++;
        }
        Collections.sort(smun);
        Collections.reverse(smun);

        for(int i = 0 ; i < nums.size() ; i++) {
            if(m==0) break;
            String temp = nums.get(i);
            nums.set(i , smun.get(i));
            nums.set(reg.get(smun.get(i)) , temp);
            m--;
        }

        StringBuilder response = new StringBuilder();
        for(String val : nums) {
            response.append(val).append(" ");
        }
        System.out.println(response.toString().trim());
    }
}
