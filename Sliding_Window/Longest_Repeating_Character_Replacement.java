import java.util.*;

public class Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        int len = 0;
        int ans = 0;
        int[] freq = new int[26];
        int start = 0;
        int end = 0;
        for (end = 0; end < s.length(); end++) {
            freq[s.charAt(end) - 'A']++;
            len = Math.max(len, freq[s.charAt(end) - 'A']);
            if (end - start + 1 - len > k) {
                freq[s.charAt(start) - 'A']--;
                start++;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }

    void display(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string --> ");
        String s = sc.next();
        System.out.println("Enter the value of k -->");
        int k = sc.nextInt();
        Longest_Repeating_Character_Replacement ls = new Longest_Repeating_Character_Replacement();
        ls.display(s);
        int ans = ls.characterReplacement(s, k);
        System.out.println("The Longest substring --> " + ans);
    }
}
