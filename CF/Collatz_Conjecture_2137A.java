// Platform: Codeforces
// Problem: 2137A - Collatz Conjecture
// Submission ID: 337423436
// Status: Accepted
// URL: https://codeforces.com/contest/2137/submission/337423436

// TODO:
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            int x = sc.nextInt();
            for (int i = 0; i < k; i++) {
                x *= 2;
            }
            
            System.out.println(x);
        }
    }
}
