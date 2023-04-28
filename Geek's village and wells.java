Geek's village is represented by a 2-D matrix of characters of size n*m, where

H - Represents a house
W - Represents a well
. - Represents an open ground
N - Prohibited area(Not allowed to enter this area)

Every house in the village needs to take the water from the well, as the family members are so busy with their work, so every family wants to take the water from the well in minimum time, which is possible only if they have to cover as less distance as possible. Your task is to determine the minimum distance that a person in the house should travel to take out the water and carry it back to the house.

A person is allowed to move only in four directions left, right, up, and down. That means if he/she is the cell (i,j), then the possible cells he/she can reach in one move are (i,j-1),(i,j+1),(i-1,j),(i+1,j), and the person is not allowed to move out of the grid.

Note: For all the cells containing 'N', 'W' and '.' our answer should be 0, and for all the houses where there is no possibility of taking water our answer should be -1.
  SOLUTION:
//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char c[][]=new char[n][m];
            for(int i=0;i<n;i++){
                s=in.readLine().trim().split(" ");
                for(int j=0;j<m;j++){
                    c[i][j]=s[j].charAt(0);
                }
            }
            Solution ob=new Solution();
            int ans[][]=ob.chefAndWells(n, m, c);

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    out.print(ans[i][j]+" ");
                }
                out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Pair{
    int i;
    int j;
    int val;
    
    Pair(int i, int j, int val){
        this.i=i;
        this.j=j;
        this.val=val;
    }
}


class Solution
{
    public int[][] chefAndWells(int n,int m,char c[][])
    {
     
        int[][] ans =new int[n][m];
        boolean[][] vis =new boolean[n][m];
        
        
        
        Queue<Pair> qq = new LinkedList<>();
        int[] row={0,0,-1,1};
        int[] col={-1,1,0,0};
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(c[i][j]=='W'){
                    vis[i][j]=true;
                    qq.add(new Pair(i,j,0));
                    
                }
                
            }
        }
        
        while(!qq.isEmpty()){
            
            Pair p = qq.poll();
            int inew,jnew,valnew;
            for(int k=0;k<4;k++){
                 inew = p.i+row[k];
                 jnew = p.j+col[k];
                 valnew= p.val+2;
                 
                 if(inew>=0 && jnew>=0 && inew<c.length && jnew<c[0].length 
                 && vis[inew][jnew]==false && c[inew][jnew]!='N')
                 {
                     vis[inew][jnew]=true;
                     if(c[inew][jnew]=='H') ans[inew][jnew]=valnew;
                     
                     qq.add(new Pair(inew,jnew,valnew));
                 }
            }
        }
        
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ans[i][j]==0 && c[i][j]=='H') ans[i][j]=-1;
            }
        }
        
        return ans;
    }
    
}
