class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        ArrayList<int[]> ans = new ArrayList<>();
        int[] st = {intervals[0][0], intervals[0][1]};
        ans.add(st);
        for(int i = 0;i<intervals.length;i++){
            if(intervals[i][0]<=ans.get(ans.size()-1)[1]){
              ans.get(ans.size()-1)[1] =  Math.max(ans.get(ans.size()-1)[1] , intervals[i][1]) ;
            }
            else{
                int[] arr = {intervals[i][0], intervals[i][1]};
                ans.add(arr);

            }
        }
        int[][] ansarr = ans.toArray(new int[ans.size()][]);
                return ansarr;
    }
}