Given a binary matrix mat[][] of dimensions NxM such that 1 denotes land and 0 denotes water. Find the number of closed islands in the given matrix.

Note: A closed island is a group of 1s surrounded by only 0s on all the boundaries (except diagonals). In simple words, a closed island is an island whose none of the 1s lie on the edges of the matrix.
  Solution:
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int closedIslands(int[][] matrix, int N, int M)
    {
        int ans=0;
        for(int i=1;i<N-1;i++){
            for(int j=1;j<M-1;j++){
                if(matrix[i][j]==1){
                    if(dfs(i,j,N,M,matrix)){
                        ans++;
                       
                    }
                }
            }
        }
        return ans;
    }
    boolean dfs(int i ,int j,int N ,int M ,int[][] matrix){
        if(i==0 || j==0 || i==N-1 || j==M-1){
            if(matrix[i][j]==1)return false;
            return true;
        }
        matrix[i][j]=0;
        boolean up=true,down=true,left=true,right=true;
        if(i+1<N && matrix[i+1][j]==1 ){
            up=dfs(i+1,j,N,M,matrix);
        }
        if(i-1>=0 && matrix[i-1][j]==1){
            down=dfs(i-1,j,N,M,matrix);
        }
        if(j+1<M && matrix[i][j+1]==1)right=dfs(i,j+1,N,M,matrix);
        if(j-1>=0 && matrix[i][j-1]==1)left=dfs(i,j-1,N,M,matrix);
        return left &&  right && up && down;
    }
}
