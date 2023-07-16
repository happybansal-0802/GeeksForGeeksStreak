class GfG{
    //Function to reverse the queue.
    public Queue<Integer> rev(Queue<Integer> q){
        //add code here.
        Stack<Integer> s=new Stack<>();
        while(q.size()!=0)
            s.push(q.remove());
        while(s.size()!=0)
            q.add(s.pop());
        return q;
    }
}
