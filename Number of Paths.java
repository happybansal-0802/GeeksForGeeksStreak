//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int M = Integer.parseInt(inputLine[0]);
		    int N = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(M, N));
		}
	}
}




// } Driver Code Ends


class Solution{
      int mod = 1000000007;
    long numberOfPaths(int M, int N) {
        // Code Here
        int n = M+N-2;
        int r = M-1<N-1?M-1:N-1;
        long res = 1;
        
        for(int i=1; i<=r; i++){
            res = (res*(n-r+i)%mod * modInverse(i,mod))%mod;
        }
        return res;
    }
    
    long modInverse(int a, int b){
        int x = 1, y = 0;
        while(a>1){
            int q = a/b, temp = b;
            b = a%b;
            a = temp;
            temp = y;
            y = x-q*y;
            x = temp;
        }
        return x<0?x+mod:x;
    }
    
}
