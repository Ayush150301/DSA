import java.util.*;
public class sudoku_solver {
    public static  boolean solve(int[][] board)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]==0)
                {

                    for(int c=1;c<=9;c++)
                    {
                        if(isvalid(board,i,j,c))
                        {
                            board[i][j]=c;

                            if(solve(board))
                                return true;
                            else
                                board[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isvalid(int[][] board,int row,int col,int c)
    {
        for(int i=0;i<9;i++)
        {
            if(board[i][col]==c)
            return false;

            if(board[row][i]==c)
            return false;

            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c)
            return false;
        }
        return true;
    }
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        if(solve(grid)==true)
        return true;
        else
        return false;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int i=0;i<=8;i++)
        {
            for(int j=0;j<=8;j++)
            {
                System.out.print(grid[i][j]+" ");
            }
        }
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        int grid[][]=new int[9][9];
        System.out.println("Enter the elements of the grid -->");
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                grid[i][j]=sc.nextInt();
            }
        }
        if(SolveSudoku(grid)==true)
        {
            printGrid(grid);
        }
        else{
            System.out.println("No solution exists");
        }
    }
}
