package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0050_02_FirstCharacterInStream {
    int count[]=new int[256];
    int index=1;

    //Insert one char from stringstream
    public void Insert(char ch) {
        if(count[ch]==0){
            count[ch]=index++;
        } else{
            count[ch]=-1;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int ind = Integer.MAX_VALUE;
        char res = '#';
        for(int i = 0; i < count.length; i++){
            if (count[i] > 0 && count[i] < ind) {
                ind =  count[i];
                res = (char)i;
            }
        }
        return res;
    }
}
