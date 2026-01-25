// Platform: Codeforces
// Problem: 2180B - Ashmal
// Submission ID: 354197954
// Status: Accepted
// URL: https://codeforces.com/contest/2180/submission/354197954

// TODO:
import java .util.*;
public class Ashmal {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = "";
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                if(s.isEmpty()){
                    s = str;
                } 
                else{
                    String first = str + s;
                    String last = s + str;
                    if(first.compareTo(last) < 0){
                        s = first;
                    } 
                    else{
                        s = last;
                    }
                }
            }
            System.out.println(s);
        }
        sc.close();
    }
}
