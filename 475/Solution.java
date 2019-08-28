import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int findRadius(int[] houses, int[] heaters) {
        houses = Arrays.stream(houses).distinct().toArray();
        heaters = Arrays.stream(heaters).distinct().toArray();

        int maxHouse = Integer.MIN_VALUE;
        int minHouse = Integer.MAX_VALUE;

        HashSet<Integer> heatersSet = new HashSet<>();
        for(int h : heaters){
            heatersSet.add(h);
            maxHouse = Math.max(maxHouse, h);
            minHouse = Math.min(minHouse, h);
        }
        ArrayList<Integer> newHouses = new ArrayList<>();
        for(int h : houses){
            if(!heatersSet.contains(h)){
                newHouses.add(h);
            }
            maxHouse = Math.max(maxHouse, h);
            minHouse = Math.min(minHouse, h);
        }

        houses = new int[newHouses.size()];
        for(int i = 0; i < houses.length; i++){
            houses[i] = newHouses.get(i);
        }

        int l = 0, r = maxHouse-minHouse;
        int mid = 0;
        int prevMid = 0;
        boolean isAllHeated = true;
        while(l < r){
            isAllHeated = true;
            mid = l + (r-l) / 2;
            for(int i = 0; i < houses.length; i++){
                boolean isHouseHeated = false;
                for(int j = 0; j < heaters.length; j++){
                    if(houses[i] <= heaters[j] + mid && houses[i] >= heaters[j] - mid){
                        isHouseHeated = true;
                        break;
                    }
                }
                if(!isHouseHeated){
                    isAllHeated = false;
                }
            }
            if(isAllHeated){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }

    public static void main(String args[]){
        Solution s = new Solution();

        //161834419
        int [] houses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int [] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};

        // int [] houses = {1};
        // int [] heaters = {10};

        // int [] houses = {1,2,3,4,5,6,7,8};
        // int [] heaters = {4};

        System.out.println(s.findRadius(houses, heaters));
    }
}
