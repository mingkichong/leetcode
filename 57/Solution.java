import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] insert(int[][] intval, int[] newInterval) {
        Interval [] intervals = new Interval [intval.length + 1];
        for(int i = 0; i < intval.length; i++){
            intervals[i] = new Interval(intval[i]);
        }
        intervals[intervals.length - 1] = new Interval(newInterval);
        Arrays.sort(intervals);
        ArrayList<Interval> intervalsList =
            new ArrayList<Interval>(Arrays.stream(intervals).collect(Collectors.toList()));

        boolean hasMerged = false;
        do
        {
            hasMerged = false;
            for(int i = 0; i < intervalsList.size() - 1; i++){
                for(int j = i+1; j < intervalsList.size(); j++){
                    if(intervalsList.get(i).isOverlapped(intervalsList.get(j))){
                        Interval merged = Interval.merge(intervalsList.get(i), intervalsList.get(j));
                        intervalsList.remove(j);
                        intervalsList.remove(i);
                        intervalsList.add(i, merged);
                        hasMerged = true;
                        break;
                    }
                }
                if(hasMerged){
                    break;
                }
            }
        }while(hasMerged);

        int[][] result = new int[intervalsList.size()][];
        for(int i = 0; i < result.length; i++){
            result[i] = intervalsList.get(i).getInterval();
        }
        return result;
    }

    void printList(List<Interval> list){
        for(Interval interval : list){
            System.out.print(interval + ", ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int [] newInterval = {4,8};
        // int [][] intervals = {{0,3},{1,2}};
        // int [][] intervals = createIntervals(10, 100, 10);
        // int [] newInterval = randomInterval(100, 10)
        for(int[] interval : intervals){
            System.out.print(Arrays.toString(interval));
            System.out.print(", ");
        }
        System.out.print("{" + Arrays.toString(newInterval) + "}");
        System.out.println();
        System.out.println(Arrays.deepToString(s.insert(intervals, newInterval)));
    }

    static int [] randomInterval(int maxStart, int maxRange){
        int [] result = new int [2];
        Random ran = new Random();
        result[0] = ran.nextInt(maxStart);
        result[1] = result[0] + ran.nextInt(maxRange);
        return result;
    }

    static int [][] createIntervals(int N, int maxStart, int maxRange){
        int[][] results = new int[N][];
        for(int i = 0; i < results.length; i++){
            results[i] = randomInterval(maxStart, maxRange);
        }
        return results;
    }
}

class Interval implements Comparable<Interval> {
    int start;
    int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    public Interval(int [] interval){
        this.start = interval[0];
        this.end = interval[1];
    }

    public int getStart(){
        return start;
    }

    public int getEnd(){
        return end;
    }

    public int[] getInterval(){
        return new int[]{start, end};
    }

    public String toString(){
        return "[" + start + "," + end + "]";
    }

    public boolean isOverlapped(Interval o){
        return !(end < o.getStart() || o.getEnd() < start);
    }

    public static Interval merge(Interval o1, Interval o2){
        if(!o1.isOverlapped(o2)){
            return null;
        }
        int start = Math.min(o1.getStart(), o2.getStart());
        int end = Math.max(o1.getEnd(), o2.getEnd());
        Interval result = new Interval(start, end);
        return result;
    }

    public int compareTo(Interval o){
        int oStart = o.getStart();
        int oEnd = o.getEnd();

        if(start == oStart && end == oEnd){
            return 0;
        }
        if(start < oStart){
            return -1;
        }
        else if(start > oStart){
            return 1;
        }
        else{
            if(end < oEnd){
                return -1;
            }
            else{
                return 1;
            }
        }
    }
}
