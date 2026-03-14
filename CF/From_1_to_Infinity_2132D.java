// Platform: Codeforces
// Problem: 2132D - From 1 to Infinity
// Submission ID: 334921877
// Status: Accepted
// URL: https://codeforces.com/contest/2132/submission/334921877

// TODO:
import java.util.*;

public class D_2132 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long k = sc.nextLong();
            System.out.println(solve(k));
        }
        sc.close();
    }

    public static long solve(long k) {
        long sum = 0, digit = 1, start = 1;
        while (true) {
            long cnt = 9 * start;
            long blk = cnt * digit;
            if (k > blk) {
                sum += rangeSum(start, start + cnt - 1);
                k -= blk;
                digit++;
                start *= 10;
            } else break;
        }
        long full = k / digit;
        long rem = k % digit;
        if (full > 0) {
            sum += rangeSum(start, start + full - 1);
            start += full;
        }
        if (rem > 0) {
            String s = Long.toString(start);
            for (int i = 0; i < rem; i++) sum += s.charAt(i) - '0';
        }
        return sum;
    }

    public static long prefixSum(long n) {
        if (n <= 0) return 0;
        long res = 0, f = 1;
        while (n / f > 0) {
            long low = n - (n / f) * f;
            long cur = (n / f) % 10;
            long high = n / (f * 10);
            res += high * (f * 45);
            res += cur * (cur - 1) / 2 * f;
            res += cur * (low + 1);
            f *= 10;
        }
        return res;
    }

    public static long rangeSum(long l, long r) {
        return prefixSum(r) - prefixSum(l - 1);
    }
}
