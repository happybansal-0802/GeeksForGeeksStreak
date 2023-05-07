You are given a string str of length n. You want to choose a non-zero integer k (k<=n), such that you can perform the following operation:
Take the prefix of the string of length k and append the reverse of it to itself.
Your task is to find the lexicographically smallest string you can get.
  Solution:
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String stringMirror(String str) {
        StringBuilder str1=new StringBuilder();
        str1.append(str.charAt(0));
        
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)<str.charAt(i-1)){ //next element should be smaller than previous then only we add
                str1.append(str.charAt(i));
            }else if(str.charAt(i)==str.charAt(i-1) && i!=1){ //equal other than first string
                str1.append(str.charAt(i));
            }else{
                break;
            }
                
        }
        
        StringBuilder rev=new StringBuilder(str1);
        
        rev.reverse();
        
        str1.append(rev);
        
        return str1.toString();
    }
}
        
