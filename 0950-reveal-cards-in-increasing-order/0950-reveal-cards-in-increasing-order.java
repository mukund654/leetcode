class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
      ArrayList<Integer> a = new ArrayList<>();
      Arrays.sort(deck);
        for(int i =0 ;i<deck.length;i++){
            a.add(deck[i]);
        }
        findans(a,0,0);
        for(int i = 0;i<deck.length;i++){
            deck[i] = a.get(i);
        }
        return deck;
    }
    public static void findans(ArrayList<Integer> arr, int size, int cnt){
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        if(arr.size()==1){
            return;
        }
        if(size%2!=0){
            cnt++;
        }
        if(cnt%2==0){    
            for(int i = 0;i<(arr.size()+1)/2;i++){
                a1.add(arr.get(i));
            }
            for(int i = (arr.size()+1)/2;i<arr.size();i++){
                a2.add(arr.get(i));
            }
            findans(a2,arr.size(),cnt);   
        }
        else{
             for(int i = 0;i<arr.size()/2;i++){
                a2.add(arr.get(i));
            }
            for(int i = arr.size()/2 ;i<arr.size();i++){
                a1.add(arr.get(i));
            }
            findans(a1,arr.size(),cnt);
        }
         int j = 0;
            int k = 0;
            for(int i = 0;i<arr.size();i++){
                if(i%2==0){
                    arr.set(i,a1.get(j));
                    j++;
                }
                else{
                    arr.set(i, a2.get(k));
                    k++;
                }
            }
    }
}