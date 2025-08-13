class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        } 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer,ArrayList<Integer>> freq = new HashMap<>();
        for(int key: map.keySet()){
            pq.add(map.get(key));
            freq.putIfAbsent(map.get(key), new ArrayList<>());
            freq.get(map.get(key)).add(key);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<k;i++){
            int num = pq.poll();
            for(int j = 0;j<freq.get(num).size();j++){
                ans.add(freq.get(num).get(j));
                i++;
            }
            i--;
        }
        int[] anss = new int[k];
        for(int i = 0;i<k;i++){
            anss[i] = ans.get(i);
        }
        return anss;

    }
}