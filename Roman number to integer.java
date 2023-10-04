//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
           int ans = 0;
        HashMap<Character,Integer> h = new HashMap<>(8);
        h.put('I',1);
        h.put('V',5);
        h.put('X',10);
        h.put('L',50);
        h.put('C',100);
        h.put('D',500);
        h.put('M',1000);
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(i > 0 && h.get(ch) > h.get(str.charAt(i - 1))){
                ans += h.get(ch) - 2 * h.get(str.charAt(i - 1));
            }else {
                ans += h.get(ch);
            }
        }
        return ans;
    }
}
