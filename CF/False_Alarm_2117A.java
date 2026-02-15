// Platform: Codeforces
// Problem: 2117A - False Alarm
// Submission ID: 323500849
// Status: Accepted
// URL: https://codeforces.com/contest/2117/submission/323500849

// TODO:
import java.util.*;
public class A_2117 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] doors = new int[n];

            for (int i = 0; i < n; i++) {
                doors[i] = sc.nextInt();
            }

            boolean canPass = false;

            // Try pressing the button at every time from 0 to n
            for (int startTime = 0; startTime <= n; startTime++) {
                boolean possible = true;

                for (int i = 0; i < n; i++) {
                    // If door is open, or within the effect of button
                    if (doors[i] == 0) continue;
                    if (i >= startTime && i < startTime + x) continue;

                    // Otherwise, the door is closed and not within the effect
                    possible = false;
                    break;
                }

                if (possible) {
                    canPass = true;
                    break;
                }
            }

            System.out.println(canPass ? "YES" : "NO");
        }

        sc.close();
    }
}
