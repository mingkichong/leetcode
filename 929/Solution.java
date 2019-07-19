import java.util.*;

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();
        for(String email : emails){
            StringBuilder sb = new StringBuilder();
            String [] emailSplit = email.split("@");
            String local = emailSplit[0];
            String domain = emailSplit[1];
            sb.append(local.split("\\+")[0]
                           .replace(".", ""));
            sb.append("@");
            sb.append(domain);
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String [] inputs = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(s.numUniqueEmails(inputs));
    }
}
