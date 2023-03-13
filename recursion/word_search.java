import java.util.*;
public class word_search {
    public  static boolean search(char[][] board,int i,int j,int k,String word)
    {
        if(i>=0 && j>=0 && i<board.length && j<board[0].length)
        {
            if(board[i][j]!=word.charAt(k)) return false;
            if(k == word.length()-1) return true;
            char value=board[i][j];
            board[i][j]=Character.MIN_VALUE;
            boolean e=search(board,i+1,j,k+1,word)||search(board,i-1,j,k+1,word)||search(board,i,j+1,k+1,word)||search(board,i,j-1,k+1,word);
            board[i][j]=value;
            return e;
        }
        return false;
    }
    public  static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(search(board,i,j,0,word))
                return true;
            }
        }
        return false;
    }
    public static void main(String[] Args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of rows --> ");
        int row=sc.nextInt();
        System.out.println("enter the number of cols-> ");
        int col=sc.nextInt();
        char[][] board=new char[row][col];
        System.out.println("Enter the elements of the array --> ");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                board[i][j]=sc.next().charAt(0);
            }
        }
        System.out.println("enter the word to be searched");
        String word=sc.next();
        boolean ex=exist(board, word);
        System.out.println("The word exist --> "+ ex);
    }
}
