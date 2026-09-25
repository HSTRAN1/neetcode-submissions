class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums)
        {
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            int number = entry.getKey();
            int frequency = entry.getValue();

            if (bucket[frequency] == null)
            {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(number);
        }

        int[] result = new int[k];
        int resultIndex = 0;

        for (int i = bucket.length - 1; i > 0; i--)
        {
            if (bucket[i] == null)
                continue;
            for (int num: bucket[i])
            {
                result[resultIndex] = num;
                resultIndex++;

                if (resultIndex == k)
                    return result;
            }
            
        }
        return result;

    }
}
