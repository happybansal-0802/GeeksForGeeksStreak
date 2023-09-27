//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        // code here
           ArrayList<Integer> res=new ArrayList<>();
        int l=arr.length-1;
        int h=0;
        int i=0,j=0; // to store the index values of a pair with closest difference to given X value
        int min=Integer.MAX_VALUE;
        while(l>=0 && h<brr.length){
            int sum=arr[l]+brr[h];
            int diff=Math.abs(x-sum);
            if(diff<min){
                i=l;j=h;
                min=diff;
            }
            if(sum==x){
                res.add(arr[l]);
                res.add(brr[h]);
                return res;
            }
            else if(sum<x){
                h++;
            }else{
                l--;
            }
        }
        res.add(arr[i]);
        res.add(brr[j]);
        return res;
    }
}
