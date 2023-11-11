//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        // Your code here
          if(str1.length()!=str2.length()){
            return false;
        }
        // Your code here
        int s1[]=new int [256];
        int s2[]=new int [256];
        Arrays.fill(s1,-1);
        Arrays.fill(s2,-1);
        
        for(int i=0;i<str1.length();i++){
            char ss=str1.charAt(i);
            char tt=str2.charAt(i);
            
            if(s1[ss]==-1 && s2[tt]==-1){
                s1[ss]=tt;
                s2[tt]=ss;
            }
            else if(s1[ss]!=tt || s2[tt]!=ss){
                return false;
            }
            
        }
        return true;
    }
}
