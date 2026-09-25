

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++)
        {
            int[] counts = new int[26];
            char characters[] = strs[i].toCharArray();
            for (char ch : characters) {
                counts[ch - 'a']++;
            }  
            StringBuilder signature = new StringBuilder();

            for (int count: counts)
            {
                signature.append("#");
                signature.append(count);
            }
            String key = signature.toString();

            if (!map.containsKey(key)){
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                map.put(key,group);
            } else {
                map.get(key).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}
