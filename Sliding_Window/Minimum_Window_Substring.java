// Intuition:
// The problem asks to find the minimum window in s that contains all the characters of t. One way to approach this problem is to use a sliding window technique. We can maintain a window that starts from the beginning of s and moves forward until it contains all the characters of t. Once we have such a window, we can try to shrink it by moving the window's start pointer forward while still keeping all the characters of t in the window. This will give us the minimum window.

// #Approach:

// Check if s is shorter than t. If it is, there is no possible solution, and we return an empty string.
// Create a frequency map of characters in t.
// Initialize count, start, min_length, and min_start to 0.
// Traverse the string s using the end pointer.
// If the current character in s is present in the frequency map, increment the count.
// Decrement the frequency of the current character in the frequency map.
// If the count equals the length of t, it means we have found a window that contains all characters of t. Now we try to shrink the window by moving the start pointer forward until the window still contains all the characters of t.
// If the length of the current window is smaller than the minimum length so far, update the minimum length and the minimum start.
// Increment the frequency of the character at the start pointer and decrement the count.
// Return the minimum window or an empty string if no window exists.
// Complexity:
// Time complexity: O(N), where N is the length of the string s. We traverse the string s once.
// Space complexity: O(M), where M is the length of the string t. We create a frequency map of characters in t.

import java.util.*;

class Minimum_Window_Substring {

    void display(String str) {
        System.out.println(str);
    }

    public String minWindow(String s, String t) {
        String ans = new String();
        int n = s.length();
        int m = t.length();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int c = 0;
        int min_len = Integer.MAX_VALUE;
        int min_start = 0;
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                if (map.get(s.charAt(end)) > 0)
                    c++;
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
            }
            if (c == m) {
                while (start < end && (!map.containsKey(s.charAt(start)) || map.get(s.charAt(start)) < 0)) {
                    if (map.containsKey(s.charAt(start))) {
                        map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                    }
                    start++;
                }
                if (min_len > end - start + 1) {
                    min_len = end - (min_start = start) + 1;
                }
                if (map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) + 1);
                }
                c--;
                start++;
            }
        }
        return min_len == Integer.MAX_VALUE ? "" : s.substring(min_start, min_start + min_len);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String 1 --> ");
        String str1 = sc.next();
        System.out.println("Enter the String 2 --> ");
        String str2 = sc.next();
        Minimum_Window_Substring m = new Minimum_Window_Substring();
        System.out.println("The Inputted String 1 -->");
        m.display(str1);
        System.out.println("The Inputted String 2 -->");
        m.display(str2);
        String ans = m.minWindow(str1, str2);
        System.out.println("The Minimum Window is : " + ans);
    }

}
