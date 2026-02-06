// Platform: Codeforces
// Problem: 2180A - Carnival Wheel
// Submission ID: 354194025
// Status: Accepted
// URL: https://codeforces.com/contest/2180/submission/354194025

// TODO:

import java .util.*;
public class People_With_Secret {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int l = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = gcd(l, b);
            int len = l / k;
            int posi = a;
            int maxPrize = posi;
            for (int i = 0; i < len; i++) {
                maxPrize = Math.max(maxPrize, posi);
                posi = (posi + b) % l;
            }
            System.out.println(maxPrize);
        }
        sc.close();
    }
    
    public static int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}
