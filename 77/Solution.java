import java.util.*;

class Solution {
    public List<List<Integer>> combine(final int N, int k) {
        int [] vals = new int[N];
        for(int i = 0; i < vals.length; i++){
            vals[i] = i+1;
        }
        boolean isReverse = k > (N+1)/2;
        if(isReverse){
            k = N - k;
        }
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(new ArrayList<Integer>());
        combine(vals, k, lists);
        if(isReverse){
            reverseCombine(N, lists);
        }
        return lists;
    }

    void reverseCombine(final int N, List<List<Integer>> lists){
        int L = lists.size();
        List<Integer> nL = new ArrayList<Integer>();
        for(int i = 0; i < N; i++){
            nL.add(i+1);
        }
        for(int j = 0; j < L; j++){
            List<Integer> tL = new ArrayList<Integer>(nL);
            List<Integer> list = lists.get(j);
            for(int i = 0; i < list.size(); i++){
                tL.remove(N - list.get(i));
            }
            lists.add(tL);
        }
        for(int j = 0; j < L; j++){
            List<Integer> list = lists.remove(0);
        }
    }

    void combine(final int[] vals, int k, List<List<Integer>> lists){
        if(k == 0){
            return;
        }
        combine(vals, k-1, lists);
        int L = lists.size();
        for(int j = 0; j < L; j++){
            List<Integer> list = lists.get(j);
            for(int i = 0; i < vals.length; i++){
                if(list.size() > 0 && list.get(list.size()-1) >= vals[i]){
                    continue;
                }
                List<Integer> l = new ArrayList<Integer>(list);
                l.add(vals[i]);
                lists.add(l);
            }
        }
        for(int j = 0; j < L; j++){
            List<Integer> list = lists.remove(0);
        }
    }

    public static void main(String args[]){
        Solution s = new Solution();
        final int N = 5, K = 4;
        List<List<Integer>> sets = s.combine(N,K);
        print(sets);
        System.out.println("Size: " + sets.size());
    }

    static void print(final List<List<Integer>> sets){
        System.out.println("[");
        for(int i = 0; i < sets.size(); i++){
            System.out.print("  [");
            for(int j = 0; j < sets.get(i).size(); j++){
                System.out.print(sets.get(i).get(j));
                if(j < sets.get(i).size() - 1){
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if(i < sets.size() - 1){
                System.out.println(",");
            }
        }
        System.out.println("\n]");
    }
}
