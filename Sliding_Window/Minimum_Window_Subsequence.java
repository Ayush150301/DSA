import java.util.*;


class Minimum_Window_Subsequence {
    void display(String str) {
        System.out.println(str);
    }

    public String minWindow(String str1, String str2) {
        String str="";
        int j=0;
        int min=str1.length()+1;
        for(int i=0;i<str1.length();i++)
        {
            if(str1.charAt(i)==str2.charAt(j))
            {
                j++;
            }
            if(j>=str2.length())
            {
                int end=i+1;
                j--;
                while(j>=0)
                {
                    if(str2.charAt(j)==str1.charAt(i))
                    {
                        j--;
                    }
                    i--;
                }
                i++;
                j++;
                if(end-i<min)
                {
                    min=end-i;
                    str=str1.substring(i, end);
                }
            }
        }
        return str;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String 1 --> ");
        String str1 = sc.next();
        System.out.println("Enter the String 2 --> ");
        String str2 = sc.next();
        Minimum_Window_Subsequence m = new Minimum_Window_Subsequence();
        System.out.println("The Inputted String 1 -->");
        m.display(str1);
        System.out.println("The Inputted String 2 -->");
        m.display(str2);
        String ans = m.minWindow(str1, str2);
        System.out.println("The Minimum Window is : " + ans);
    }
}
