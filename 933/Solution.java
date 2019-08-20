import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    static class RecentCounter {
        ArrayList<Integer> times;
        public RecentCounter() {
            times = new ArrayList<Integer>();
        }

        public int ping(int t) {
            times.add(t);
            int count = 0;
            for(int i = 0; i < times.size(); i++){
                if(t - times.get(i) <= 3000){
                    count++;
                }
            }
            for(int i = 0; i < count; i++){
                if(t - times.get(0) > 3000){
                    times.remove(0);
                }
            }
            return count;
        }
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String[] actions = {"RecentCounter","ping","ping","ping","ping","ping","ping","ping","ping","ping"};
        Integer[] ts = {null,1,100,3001,3002,6000,6001,6002,6003,6007};
        Integer[] results = new Integer[ts.length];
        RecentCounter counter = null;

        for(int i = 0; i < actions.length; i++){
            String action = actions[i];
            Integer t = ts[i];
            if(action.equals("RecentCounter")){
                counter = new RecentCounter();
            }
            else if(action.equals("ping")){
                results[i] = counter.ping(t);
            }
        }
        System.out.println(Arrays.toString(results));
    }
}

