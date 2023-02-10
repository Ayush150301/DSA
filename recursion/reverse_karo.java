import java.util.Scanner;

public class reverse_karo {
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
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String s=rev(str);
        System.out.println("the reverse string is -->"+s);
    }
}
