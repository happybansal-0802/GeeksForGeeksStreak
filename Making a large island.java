//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution{
     public void count(int[][] grid, int i, int j, int[][] temp){          //finds the count of a island
        if(i<0 || i>=n || j<0 || j>=n || grid[i][j] != 1 || temp[i][j] == -1) return;
        
        c++;
        temp[i][j] = -1;
        count(grid, i+1, j, temp);
        count(grid, i-1, j, temp);
        count(grid, i, j+1, temp);
        count(grid, i, j-1, temp);
    }
    
    public void set (int i, int j, int[][] temp) {                   //set the temp[i][j] to count of numbers in island and also deciding the parent to curPar
        if(i<0 || i>=n || j<0 || j>=n || temp[i][j] != -1) return;
        
        temp[i][j] = c;
        par[i][j] = curPar;
        set(i+1, j, temp);
        set(i-1, j, temp);
        set(i, j+1, temp);
        set(i, j-1, temp);
    }
    
    public boolean isValid(int i, int j) {
        return !(i<0 || j<0 || i>=n || j>=n);
    }
    
    int c, curPar, n, max; // made this global so no need to call mention in function parameter
    int[][] par;

    public int largestIsland(int N,int[][] grid) {
        n = N;
        int[][] temp = new int[n][n];
        par = new int[n][n];
        curPar = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1 && temp[i][j]==0){
                    c=0;
                    curPar++;
                    count(grid, i, j, temp);
                    max = Math.max(c, max);
                    set(i, j, temp);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    HashMap<Integer, Integer> map = new HashMap<>();
                    if(isValid(i+1, j) && temp[i+1][j]!=0 && !map.containsKey(par[i+1][j])) map.put(par[i+1][j], temp[i+1][j]);
                    if(isValid(i-1, j) && temp[i-1][j]!=0 && !map.containsKey(par[i-1][j])) map.put(par[i-1][j], temp[i-1][j]);
                    if(isValid(i, j+1) && temp[i][j+1]!=0 && !map.containsKey(par[i][j+1])) map.put(par[i][j+1], temp[i][j+1]);
                    if(isValid(i, j-1) && temp[i][j-1]!=0 && !map.containsKey(par[i][j-1])) map.put(par[i][j-1], temp[i][j-1]); 
                    int sum=0;
                    
                    for(int k : map.keySet()){
                        sum+=map.get(k);
                    }
                    max = Math.max(max, sum+1);
                }
            }
        }
        
        return max;
    }
}
