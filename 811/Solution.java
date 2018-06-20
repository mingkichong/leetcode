import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap();
        for(String s : cpdomains){
        	int index = s.indexOf(" ");
        	int count = Integer.parseInt(s.substring(0, index));
        	String domain = s.substring(index+1);
			map.put(domain, count + map.getOrDefault(domain, 0));
			for(int i = 0; i < domain.length(); i++){
				if(domain.charAt(i) == '.'){
					String subdomain = domain.substring(i+1);
					map.put(subdomain, count + map.getOrDefault(subdomain, 0));
				}
			}        	
        }
        for(Map.Entry<String, Integer> set : map.entrySet()){
        	list.add(set.getValue() + " " + set.getKey());
        }
        return list;
    }

    public static void main(String args[]){
    	System.out.println(
    		new Solution().subdomainVisits(
    			new String[]{
    				"900 google.mail.com",
    				"50 yahoo.com",
    				"1 intel.mail.com",
    				"5 wiki.org"
    			}
    		)
    	);
    }
}