class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String element: strs)
        {
            result.append(element.length());
            result.append("#");
            result.append(element);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        
        int i = 0;

        while (i < str.length())
        {
            int j = i;

            while (str.charAt(j) != '#')
            {
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));
            int wordStart = j + 1;
            int wordEnd = j + len + 1;

            result.add(str.substring(wordStart, wordEnd));

            i = wordEnd;
            
        }
        
        return result;
    }
}
