import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public String validIPAddress(String IP) {
        if(isIPv4(IP)){
            return "IPv4";
        }
        if(isIPv6(IP)){
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4(String IP){
        if(IP.length() < 1 || IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.'){
            return false;
        }
        String [] nums = IP.split("\\.");
        if(nums.length != 4){
            return false;
        }
        for(String n : nums){
            if(n.length() > 3 || n.length() < 1){
                return false;
            }
            if(n.length() > 1 && n.charAt(0) == '0'){
                return false;
            }
            for(char a : n.toCharArray()){
                if(!isDigit(a)){
                    return false;
                }
            }
            if(Integer.parseInt(n) > 255){
                return false;
            }
        }
        return true;
    }

    private boolean isDigit(char a){
        return a >= '0' && a <= '9';
    }

    private boolean isAtoF(char a){
        return a >= 'a' && a <= 'f';
    }

    private boolean isIPv6(String IP){
        if(IP.length() < 1 || IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':'){
            return false;
        }
        String [] nums = IP.split(":");
        if(nums.length != 8){
            return false;
        }
        for(String n : nums){
            if(n.length() > 4 || n.length() < 1){
                return false;
            }
            n = n.toLowerCase();
            for(char a : n.toCharArray()){
                if(!isDigit(a) && !isAtoF(a)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.validIPAddress("127.0.0.1"));
        System.out.println(s.validIPAddress(""));
        System.out.println(s.validIPAddress("255.256.255.255"));
        System.out.println(s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(s.validIPAddress("0:0:0:0:0:0:0:0"));
        System.out.println(s.validIPAddress("0:0:0:0:0:0:1:0:"));
    }
}

