class Solution{
   
    // Function for finding maximum and value pair
    public long sumXOR (int arr[], int n) {
        //Complete the function
        
         long ans = 0;


        for (int i = 0; i < 32; i++) {

            long zero_cnt = 0;
            long one_cnt = 0;

            for (int j = 0; j < n; j++) {

                if (arr[j] % 2 == 0) {
                    zero_cnt++;
                } else {
                    one_cnt++;
                }


                arr[j] = arr[j] / 2;

            }
            ans += (zero_cnt * one_cnt) * (1 << i);
        }


        return ans;

    }
    
}
