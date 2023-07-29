

//User function Template for Java

class Tree
{
     public static void inorder(Node root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
    public static float findMedian(Node root)
    {
        // code here.
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        int n=arr.size();
        if(n%2==0){
            int n1=n/2;
            
            float res= ((float)(arr.get(n1) +arr.get(n1-1)))/2;
            return res;  
        }
        else{
            return arr.get(n/2);
        }
    }
}
