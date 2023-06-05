import java.util.*;

class Number_of_Substrings_Containing_All_Three_Characters {

    void display(String str) {
        System.out.println(str);
    }

    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int n = s.length();
        int j = 0;
        int i = 0;
        while (j < n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (!map.containsKey('a') || !map.containsKey('b') || !map.containsKey('c')) {
                j++;
            } else {
                while (map.containsKey('a') && map.containsKey('b') && map.containsKey('c')) {
                    count += n - j;
                    char c = s.charAt(i);
                    map.put(c, map.getOrDefault(c,0) - 1);
                    if (map.get(c) == 0)
                        map.remove(c);
                        i++;
                }
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string --> ");
        String s = sc.next();
        Number_of_Substrings_Containing_All_Three_Characters ls = new Number_of_Substrings_Containing_All_Three_Characters();
        System.out.println("The Inputted String -->");
        ls.display(s);
        int ans = ls.numberOfSubstrings(s);
        System.out.println("The Longest substring --> " + ans);
    }
}
