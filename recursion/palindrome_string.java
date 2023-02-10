import java.util.Scanner;

public class palindrome_string {
    static String rev(String str)
    {
        if(str.isEmpty())
        {
            System.out.println("String is empty");
            return str;
        }
        else{
            return rev(str.substring(1))+str.charAt(0);
        }

    }
    public static void main(String Args[])
    {
        Scanner scanner= new Scanner(System.in);
        String str=scanner.nextLine();
        String ans=rev(str);
        if(ans.equals(str))
        System.out.println("Is palindrome");
        else
        System.out.println("Is not palindrome");
    }
}
