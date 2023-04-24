Given an array where each element (arr[i]) represents the height of the tower. Find for each tower, the nearest possible tower that is shorter than it. You can look left or right on both sides.
Note : 

If two smaller towers are at the same distance, pick the smallest tower.

If two towers have the same height then we choose the one with a smaller index.
  SOLUTION:
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr){
		int n = arr.length;
		int[] ans = new int[n];
		Arrays.fill(ans, -1);
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i < n; i++){
		    while(!st.isEmpty() && arr[st.peek()] > arr[i]){
		        ans[st.pop()] = i; 
		    }
		    st.push(i);
		}
		st.clear();
	    
	    
	    for(int i =  n - 1; i >= 0; i--){
	        
	        while(!st.isEmpty() && arr[st.peek()] > arr[i]){
	           int index = ans[st.peek()];
	           if(index == -1) {
	               ans[st.pop()] = i; 
	           }
	            else{
	                int diff1 = Math.abs(st.peek()-index);
	                int diff2 = Math.abs(st.peek()-i);
	                if(diff1 > diff2)  ans[st.pop()] = i; 
	                else if(diff2 > diff1)  ans[st.pop()] = index;
	                else if (diff1 == diff2){
	                    if(arr[index] < arr[i])
	                        ans[st.pop()] = index;
	                   else
	                        ans[st.pop()] = i; 
	                }
	                else break;
	            }
	        }
	        st.push(i);
	    }
		return ans;
	}
}
