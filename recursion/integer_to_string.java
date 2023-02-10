import java.util.Scanner;

public class integer_to_string {
    // static int solve(String str, int i, int sign, int res) {
    //     if (i >= str.length() || !Character.isDigit(str.charAt(i)))
    //         return sign * res;

    //     int val=str.charAt(i)-'0';
    //     if(res>Integer.MAX_VALUE/10 ){
    //         if(sign==-1)
    //           return (Integer.MIN_VALUE);
    //         else
    //           return Integer.MAX_VALUE;
    //     }
    //     if(res==Integer.MAX_VALUE/10 && val>7 ){
    //         if(sign==-1)
    //           return (Integer.MIN_VALUE);
    //         else
    //           return Integer.MAX_VALUE;
    //     }
    //     res = (res * 10) + val;
    //     return solve(str, i++, sign, res);
    // }

    public static int recursion(int i,int sign, String s,int num) {
        
        if(i>=s.length() || !Character.isDigit(s.charAt(i))  ){
          return sign*num;
        }
        
        int val=s.charAt(i)-'0';

        if(num>Integer.MAX_VALUE/10 ){
            if(sign==-1)
              return (Integer.MIN_VALUE);
            else
              return Integer.MAX_VALUE;
        }
        if(num==Integer.MAX_VALUE/10 && val>7 ){
            if(sign==-1)
              return (Integer.MIN_VALUE);
            else
              return Integer.MAX_VALUE;
        }
        num=(num*10)+val;

        return recursion(i+1,sign,s,num);
    }  

 
    public static int myAtoi(String s) {
        //return solve1(s);

        int len=s.length();
        int sign=1;
        int i=0;
        int num=0;
        if(len<1){return 0;}
        while(i<len && s.charAt(i)==' '){
           i++;
        }
        if(i<len && s.charAt(i)=='-' || i<len && s.charAt(i)=='+'){
          if(s.charAt(i)=='-')
             sign=-1;
          i++;
        }

        return recursion(i,sign,s,num);

    }
    public static void main(String Args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string ==> ");
        String str = scanner.nextLine();
        // str = str.trim();
        // int sign = 1;
        // int i = 0;
        // int res = 0;
        // if(i<str.length() && str.charAt(i)=='-' || i<str.length() && str.charAt(i)=='+'){
        //     if(str.charAt(i)=='-')
        //        sign=-1;
        //     i++;
        // }
        int ans = myAtoi(str);
        System.out.print("The answer of the string is ==> " + ans);
    }
}
