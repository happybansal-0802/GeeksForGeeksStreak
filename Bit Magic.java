Given an integer array arr[] of size n which contains only 1 and 0. Your task is to make the array perfect. An array is said to be perfect if for each i from 0 to n-1 arr[i]==arr[n-1-i] is satisfied. 

To Make the array perfect you are allowed to do the following operation  :

In one operation you can choose two different indexes i and j and set value of both arr[i] and arr[j] to arr[i]^arr[j].

Your task is to make the array perfect in minimum possible number of operations and return the number of operations.

Note: 0-based indexing is used.
  Solution:
//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
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
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.bitMagic(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int bitMagic(int n, int[] arr) {
       int l = 0, r = n-1 , count = 0;
        while(l<=r) if(arr[l++]!=arr[r--]) count++;
        return (count+1)/2;
    }
}
        
