import java.util.*;

class Solution {

    final int [] BALLOON = getHisto("balloon");

    public int maxNumberOfBalloons(String text) {
        int [] histoText = getHisto(text);
        int count = 0;
        while(hasBalloon(histoText)){
            count++;
            removeBalloon(histoText);
        }
        return count;
    }

    private void removeBalloon(int[] histo){
        for(int i = 0; i < histo.length; i++){
            histo[i] -= BALLOON[i];
        }
    }

    private boolean hasBalloon(int[] histo){
        for(int i = 0; i < histo.length; i++){
            if(histo[i] < BALLOON[i]){
                return false;
            }
        }
        return true;
    }

    private int[] getHisto(String word){
        int [] histo = new int[26];
        for(char a : word.toCharArray()){
            histo[a - 'a']++;
        }
        return histo;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.maxNumberOfBalloons("loonbalxballpoon"));
    }
}

