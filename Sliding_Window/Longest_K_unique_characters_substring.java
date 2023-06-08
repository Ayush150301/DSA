import java.util.*;

class Longest_K_unique_characters_substring {
    void display(String str) {
        System.out.println(str);
    }

    public int longestkSubstr(String s, int k) {
        int str_len = -1;
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if(map.size()==k)
            {
                str_len=Math.max(str_len,j-i+1);
            }
            while (map.size() > k) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)-1);
                if(map.get(s.charAt(i))==0)
                {
                    map.remove(s.charAt(i));
                }
                i++;
            }
            j++;
        }
        return str_len;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string --> ");
        String str = sc.next();
        System.out.println("Enter the value of k -->");
        int k = sc.nextInt();
        Longest_K_unique_characters_substring obj = new Longest_K_unique_characters_substring();
        System.out.println("The Inputted str --> ");
        obj.display(str);
        int ans = obj.longestkSubstr(str, k);
        System.out.println("The length of the longest substring is " + ans);
    }
}
