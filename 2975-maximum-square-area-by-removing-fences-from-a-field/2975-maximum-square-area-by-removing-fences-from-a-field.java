class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        set.add(m-1);
        for(int i = 0;i<hFences.length-1;i++){
            set.add(hFences[i]-1);
            for(int j = i+1;j<hFences.length;j++){
                set.add(hFences[j]-hFences[i]);
            }
            set.add(m-hFences[i]);    
        }
        set.add(hFences[hFences.length-1]-1);
        set.add(m-hFences[hFences.length-1]);
        if(set.contains(n-1)){
            long ans = (long)(n-1)*(n-1);
            int a = (int)(ans%1000000007);
             return a;
        }
        int max = 0;
        
        
        for(int i = 0;i<vFences.length;i++){
            if(set.contains(vFences[i]-1)){
                max = Math.max(max,vFences[i]-1);
            }
            for(int j = i+1;j<vFences.length;j++){
                if(set.contains(vFences[j]-vFences[i])){
                     max = Math.max(max,vFences[j]-vFences[i]);
                }
            }
            if(set.contains(n-vFences[i])){
                max = Math.max(max,n-vFences[i]);
            }
            
        }
        if(set.contains(vFences[vFences.length-1]-1)){
            max = Math.max(max,vFences[vFences.length-1]-1);
        }
        if(set.contains(n-vFences[vFences.length-1])){
            max = Math.max(max,n-vFences[vFences.length-1]);
        }
        if(max==0){
            return -1;
        }
        long ans =(long) max*max;
        int a = (int)(ans%1000000007);
        return a;

    }
}