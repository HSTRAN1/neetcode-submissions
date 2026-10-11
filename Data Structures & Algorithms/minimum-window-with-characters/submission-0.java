class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>();
        int left = 0;
        Map<Character,Integer> window = new HashMap<>();
        int bestStart = 0;
        int bestLength = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++)
        {
            char c = t.charAt(i);
            need.put(c,need.getOrDefault(c,0) + 1);
        }

        int have = 0;
        int required = need.size();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c,window.getOrDefault(c,0) + 1);

            if (need.containsKey(c) && window.get(c).equals(need.get(c))) {
                have++;
            }

            while(have == required) {
                int currentLength = right - left + 1;
                if (currentLength < bestLength) {
                    bestLength = currentLength;
                    bestStart = left;
                }

                char leftChar = s.charAt(left);

                if (need.containsKey(leftChar)) {
                    if (window.get(leftChar).equals(need.get(leftChar))) {
                        have--;
                    }

                    window.put(leftChar,window.get(leftChar) - 1 );
                    
                } 
                left++;
            }

        }
        return bestLength == Integer.MAX_VALUE?"":s.substring(bestStart,bestStart + bestLength);
    }
}
