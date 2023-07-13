class Solution {
    public static boolean isFrequencyUnique(int n, int[] arr) {
        // Map to maintain count of frequencies
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int val: arr) 
            hm.put(val, hm.getOrDefault(val, 0)+1);
            
        HashSet<Integer> set = new HashSet<>();
        for(int val: hm.values()) {
            if(set.contains(val)) 
                return false;
            
            set.add(val);
        }
        
        return true;
    }
}
