import java.util.*;
public class m_coloring_problem {
    public static boolean ispossible(boolean graph[][],int []color,int node,int col,int n)
    {
        for(int i=0;i<n;i++)
        {
            if(graph[node][i] && color[i]==col) return false;
        }
        return true;
    }
    
    public static boolean solve(int node,boolean graph[][],int color[],int m,int n)
    {
        if(node==n)
        return true;
        
        for(int i=1;i<=m;i++)
        {
            if(ispossible(graph,color,node,i,n))
            {
                color[node]=i;
                if(solve(node+1,graph,color,m,n)) return true;
                color[node]=0;
            }
        }
        return false;
    }
    public static boolean graphColoring(boolean graph[][], int m, int n) {
        int color[]=new int[n];
        return solve(0,graph,color,m,n);
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n -->");
        int N=sc.nextInt();

        System.out.println("Enter the no of colors -->");
        int M=sc.nextInt();

        System.out.println("Enter the no of edges -->");
        int E=sc.nextInt();

        boolean graph[][]=new  boolean[N][N];
        System.out.println("Enter the edges -->");
        for(int i=0;i<E;i++)
        {
            int u=sc.nextInt()-1;
            int v=sc.nextInt()-1;
            graph[u][v]=true;
            graph[v][u]=true;
        }
        System.out.println(graphColoring(graph, M, N));
    }    
}
