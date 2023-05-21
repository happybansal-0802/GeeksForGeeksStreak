You are conductor of a bus .There are n chairs and n passengers in the bus. You are given an array chairs of length n, where chairs[i] is the position of the ith chair. You are also given the array passengers of length n, where passengers[j] is the position of the jth passenger.

You may perform the following move any number of times:

Increase or decrease the position of the ith passenger by 1 (i.e., moving the ith passenger from position x to x + 1 or x - 1)
Return the minimum number of moves required to move each passenger to a chair such that no two passengers are in the same chair and every passenger gets a chair.

Note that there may be multiple chairs or passengers in the same position at the beginning.
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
            
            
            int[] chairs = IntArray.input(br, n);
            
            
            int[] passengers = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.findMoves(n, chairs, passengers);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int findMoves(int n, int[] chairs, int[] passengers) {
        Arrays.sort(chairs);
        Arrays.sort(passengers);
        
        int count=0;
        for(int i=0;i<n;i++){
            count=count+(int)Math.abs(chairs[i]-passengers[i]);
        }
        return count;
    }
}
        
