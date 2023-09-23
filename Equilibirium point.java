//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {

        // Your code here
         long sum=0,sum2=0;
            if(n==0)
               return -1;
            if(n==1)
               return 1;
            for(int i=0;i<n;i++)
            {
                sum+=arr[i];
            }
            sum2=sum;
            long sum1=arr[0];
            for(int j=1;j<n;j++)
            {
                sum=sum-arr[j]-sum1;
                if(sum==sum1)
                    return j+1;
                sum1+=arr[j];
                sum=sum2;
                
            }
            return -1;
    }
}
