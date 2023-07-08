class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
         Arrays.sort(arr);
        for(int i=0; i<n; i++){
            int left=i+1,right=n-1;
            while(left<right){
                if(arr[i]+arr[left]+arr[right]<0){
                    left++;
                }
                else if(arr[i]+arr[left]+arr[right]>0){
                    right--;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
}
