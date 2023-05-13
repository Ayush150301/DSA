import java.util.*;

class First_non_repeating_character_in_a_stream {
    void display(String s) {
        System.out.println(s);
    }

    public String FirstNonRepeating(String A) {
        StringBuffer ans = new StringBuffer("");
        HashSet<Character> count=new HashSet<>();
        Queue<Character> q = new ArrayDeque<>();
        count.add(A.charAt(0));
        q.add(A.charAt(0));
        ans.append(A.charAt(0));
        int i=1;
        while(i<A.length()) {
            if(count.contains(A.charAt(i))){
                q.remove(A.charAt(i));
            }
            else{
                q.offer(A.charAt(i));
            }

            count.add(A.charAt(i));
            if(q.isEmpty()){
                ans.append('#');
            }
            else{
                ans.append(q.peek());
            }
            i++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string ==> ");
        String s = sc.nextLine();
        First_non_repeating_character_in_a_stream f = new First_non_repeating_character_in_a_stream();
        System.out.println("The Inputted String ==> ");
        f.display(s);
        System.out.println("The Modified String ==> ");
        f.display(f.FirstNonRepeating(s));
    }
}
