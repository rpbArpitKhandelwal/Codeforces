// Platform: Codeforces
// Problem: 2110B - Down with Brackets
// Submission ID: 321097109
// Status: Accepted
// URL: https://codeforces.com/contest/2110/submission/321097109

// TODO:

import java.util.*;
public class B_2110 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            if (canBreakString(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
    public static boolean canBreakString(String s) {
        if (isNested(s)) {
            return false;
        }
        return true;
    }
    public static boolean isNested(String s) {
        int n = s.length();
        int balance = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0 && i != n - 1) {
                return false;
            }
        }
        return true;
    }
}
