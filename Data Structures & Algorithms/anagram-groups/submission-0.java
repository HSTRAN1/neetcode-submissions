class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i< strs.length; i++)
        {
            char[] characters = strs[i].toCharArray();
            Arrays.sort(characters);
            String signature = new String(characters);

            if (!map.containsKey(signature)) {
                List<String> group = new ArrayList<String>();
                group.add(strs[i]);
                map.put(signature, group);
            }
            else {
                map.get(signature).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
        
    }
}
