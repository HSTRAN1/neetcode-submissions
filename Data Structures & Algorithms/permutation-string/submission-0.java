class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int[] target = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++)
        {
            target[s1.charAt(i) - 'a']++;
        }

        for (int right = 0; right < s2.length(); right++)
        {
            window[s2.charAt(right) - 'a']++;
            if (right - left + 1 > s1.length()) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }

            if (Arrays.equals(target, window))
                return true;
        }
        return false;

    }
}
