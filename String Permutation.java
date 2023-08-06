Given a string S. The task is to find all permutations (need not be different) of a given string.
  Your Task:
This is a function problem. You only need to complete the function permutation that takes S as parameter and returns the list of permutations in lexicographically increasing order. The newline is automatically added by driver code.
  Solution:
  //{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static ArrayList<String> al=new ArrayList<>();
    public ArrayList<String> permutation(String S)
    {   al.clear();
        perm(S,"");
        Collections.sort(al);
        return al;
    }
    static boolean perm(String str,String ans){
        if(str.length()==0)  return al.add(ans);
        for(int i=0;i<str.length();i++) perm(str.substring(0,i)+str.substring(i+1),ans+str.charAt(i)); 
        return true;
    }

	   
}
