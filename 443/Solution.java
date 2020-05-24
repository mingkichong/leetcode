import java.util.*;

class Solution {

    public int compress(char[] s) {
        int l = 0;
        int count = 1;
        int printI = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[l] == s[i]) {
                count++;
            } else {
                printI = compressChars(s, l, printI, count);
                count = 1;
                l = i;
            }
        }
        // check last char
        if (s[l] == s[s.length - 1]) {
            printI = compressChars(s, l, printI, count);
        }
        return printI;
    }

    private int compressChars(char [] s, int l, int printI, int count) {
        s[printI] = s[l]; printI++;
        if (count > 1) {
            char [] length = Integer.toString(count).toCharArray();
            for (int j = 0; j < length.length; j++, printI++) {
                s[printI] = length[j];
            }
        }
        return printI;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        test(s, "aabbccc");
        test(s, "a");
        test(s, "abbbbbbbbbbbb");
        test(s, "abbbbbbbbbbbc");
        String testStr = "";
        for (int i = 0; i < 1000; i++) {
            testStr += "b";
        }
        test(s, testStr);
    }

    private static void test(Solution s, String str) {
        char [] chars = str.toCharArray();
        int pos = s.compress(chars);
        printArray(chars, pos);
    }

    private static void printArray(char [] chars, int pos) {
        char [] head = new char[pos];
        System.arraycopy(chars, 0, head, 0, pos);
        System.out.println(Arrays.toString(head));
    }
}

