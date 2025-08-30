class Solution {
    public String minWindow(String s, String t) {
        int[] arr = new int[58];
    
        for(int i = 0;i<t.length();i++){
           arr[t.charAt(i)-'A']++;
        }
        int start = 0;
        int fstart = -1;
        int fend = -1;
        int end = 0;
        for(int i = 0;i<s.length();i++){
            arr[s.charAt(i)-'A']--;
            if(arr[s.charAt(i)-'A']<=0){
                 while(start<s.length() && arr[s.charAt(start)-'A']<0){
                        arr[s.charAt(start)-'A']++;
                        start++;
                    }
                int flag = 0;
                for(int j = 0;j<58;j++){
                    if(arr[j]>0){
                        break;
                    }
                    if(j==57){
                        flag = 1;
                    }
                }
                if(flag==1){
                    end = i;
                   
                    if(fstart==-1){
                        fend = i;
                        fstart = start;
                    }
                    else if(fend-fstart>i-start){
                        fend = i;
                        fstart = start;
                    }
                }
            }
        }
        if(fend == -1){
            return "";
        }
        else{
            return s.substring(fstart,fend+1);
        }
    }
}