package com.hackerrank.bullshit;

import java.util.*;

/**
 * Created by prajeeva on 10/25/17.
 */
public class LuckItSeems {
    private static class Contest implements Comparable<Contest> {
        int L;
        int T;
        boolean see = false;

        Contest(int L , int T) {
            this.L = L;
            this.T = T;
        }

        @Override
        public int compareTo(Contest that) {
            if(L < that.L) return -1;
            if(L > that.L) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineOne = scanner.nextLine();
        int N = Integer.parseInt(lineOne.split("\\s")[0]);
        int K = Integer.parseInt(lineOne.split("\\s")[1]);
        List<Contest> contests = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            String dataLine = scanner.nextLine();
            contests.add(new Contest(Integer.parseInt(dataLine.split("\\s")[0]),
                    Integer.parseInt(dataLine.split("\\s")[1])));
        }

        contests.sort(Collections.reverseOrder());
        int luck = 0;
        for(int i = 0 ; i < N ; i++) {
            Contest c = contests.get(i);
            if(c.T ==0) {
                luck += c.L;
                c.see = true;
            }
        }
        for(int i = 0 ; i < N ; i++) {
            Contest c = contests.get(i);
            if(!c.see) {
                if (K == 0) break;
                luck += c.L;
                if (c.T == 1) {
                    K--;

                }
                c.see = true;
            }
        }
        for(int i = 0 ; i < N ; i++) {
            Contest c = contests.get(i);
            if(!c.see) {
                luck -= c.L;
            }
        }
        System.out.println(luck);
    }
}
