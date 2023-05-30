import java.util.*;

class longest_substring_without_repeating_character {

    void display(String str)
    {
        System.out.println(str);
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int n=s.length();
        if(n<=1)
        return n;
        int max_length = 0;
        int start = 0;
        for(int end=0;end<n;end++)
        {
            if(m.containsKey(s.charAt(end)))
            {
                start=Math.max(start,m.get(s.charAt(end))+1);
            }
            m.put(s.charAt(end), end);
            max_length=Math.max(max_length,end-start+1);
        }
        return max_length;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string --> ");
        String s=sc.next();

        longest_substring_without_repeating_character ls = new longest_substring_without_repeating_character();
        ls.display(s);
        int ans = ls.lengthOfLongestSubstring(s);
        System.out.println("The Longest substring --> "+ans);
    }
}