Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.
  Solution:
//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
         int lis[] = new int[size];
        int len = 1; // Length of the longest increasing subsequence

        lis[0] = a[0];

        for (int i = 1; i < size; i++) {
            if (a[i] > lis[len - 1]) {
                lis[len] = a[i];
                len++;
            } else {
                // Binary search to find the position to insert a[i] in the LIS
                int idx = Arrays.binarySearch(lis, 0, len, a[i]);
                if (idx < 0) {
                    idx = -idx - 1;
                }
                lis[idx] = a[i];
            }
        }

        return len;
    }
} 
