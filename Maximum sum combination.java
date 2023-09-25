  PriorityQueue<Integer>p=new PriorityQueue<>();
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=N-1;i>=0;i--){
            for(int j=N-1;j>=0;j--){
                int t=A[i]+B[j];
                if(p.size()<K){
                    p.add(t);
                }
                else if(p.peek()<t){
                    p.poll();
                    p.add(t);
                }
                else{
                    break;
                }
            }
            
            
        }
        List<Integer>l=new ArrayList<>();
        while(!p.isEmpty()){
            l.add(p.poll());
        }
        Collections.sort(l,Collections.reverseOrder());
        return l;
