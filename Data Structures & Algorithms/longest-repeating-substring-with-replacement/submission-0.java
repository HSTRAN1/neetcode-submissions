class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFrequency = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++)
        {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch,0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(ch));

            while ((right - left + 1) - maxFrequency > k) {
                char charLeft = s.charAt(left);
                map.put(charLeft, map.get(charLeft) - 1);
                left++;
            }
            result = Math.max(right - left + 1, result);

        }
        return result;


    }
}
