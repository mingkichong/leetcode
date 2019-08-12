import java.util.*;

class Solution {
    // time: O(log n) binary search
    public boolean searchMatrix(int[][] matrix, int target) {
        final int R = matrix.length;
        if(R == 0){
            return false;
        }
        final int C = matrix[0].length;
        if(C == 0){
            return false;
        }
        Index l = new Index(R, C, 0), r = new Index(R, C, R * C - 1);
        while(l.index <= r.index){
            Index m = new Index(R, C, (l.index + r.index) / 2);
            if(matrix[m.i][m.j] == target){
                return true;
            }
            else if(matrix[m.i][m.j] < target){
                l = new Index(R, C, m.index + 1);
            }
            else{
                r = new Index(R, C, m.index - 1);
            }
        }
        return false;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        // int [][] matrix = {{1,   3,  5,  7},
        //                    {10, 11, 16, 20},
        //                    {23, 30, 34, 50}};
        Random random = new Random();
        int maxValue = 100, maxSize = 10;
        int target = random.nextInt(maxValue);
        final int R = random.nextInt(maxSize) + 1;
        final int C = random.nextInt(maxSize) + 1;
        int [][] matrix = new int[R][C];
        int [] values = new int[R * C];
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < values.length; i++){
            int value;
            do{
                value = random.nextInt(maxValue);
            }while(set.contains(value));
            values[i] = value;
            set.add(value);
        }
        Arrays.sort(values);
        for(int i = 0; i < values.length; i++){
            Index index = new Index(R, C, i);
            matrix[index.i][index.j] = values[i];
        }
        System.out.println("Target: " + target + "\nSize: " + R + "x" + C);
        print(matrix);
        System.out.println(s.searchMatrix(matrix, target));
    }

    static void print(int [][] matrix){
        for(int [] row : matrix){
            for(int c : row){
                System.out.print(fillFrontSpaces(c)+ c);
            }
            System.out.println();
        }
        System.out.println();
    }

    static String fillFrontSpaces(int d){
        return (d >= 0 && d <= 9) ? "  " : " ";
    }
}

class Index{
    public
        int R, C, i, j, index, size;

    public Index(int R, int C, int i, int j){
        this.size = R * C;
        this.R = R; this.C = C;
        this.i = i; this.j = j;
        convert(i, j);
    }

    public Index(int R, int C, int index){
        this.size = R * C;
        this.R = R; this.C = C;
        this.index = index;
        convert(index);
    }

    void convert(int index){
        this.i = index / C;
        this.j = index % C;
    }

    void convert(int i, int j){
        this.index = i * C + j;
    }
}
