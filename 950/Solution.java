import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = deck.length - 1; i >= 0; i--){
            if(!list.isEmpty()){
                list.addLast(list.removeFirst());
            }
            list.add(deck[i]);
        }
        for(int i = 0; i < deck.length; i++){
            deck[i] = list.removeLast();
        }
        return deck;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int nums[] = new int[]{17,13,11,2,3,5,7};
        if(Solution.RANDOM_INPUT){
            Random random = new Random();
            HashSet<Integer> set = new HashSet<>();
            nums = new int[random.nextInt(46) + 5];
            for(int i = 0; i < nums.length; i++){
                do{
                    nums[i] = random.nextInt(100);
                }while(set.contains(nums[i]));
            }
        }
        System.out.println(Arrays.toString(s.deckRevealedIncreasing(nums)));
    }
}

