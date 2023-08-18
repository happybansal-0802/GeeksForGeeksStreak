class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        int max=arr[n-1],k=0;
        ArrayList<Integer> a=new ArrayList<Integer>();
       for(int i=n-2;i>=0;i--)
       {
           if(arr[i]>=max){
           max=arr[i];
           a.add(arr[i]);
           }
       }
        a.add(arr[n-1]);
        Collections.sort(a);
        Collections.reverse(a);
        return a;
    }
}
