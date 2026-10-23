class TimeMap {

    Map<String, List<Entry>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Entry entry = new Entry(timestamp,value);
        if (!map.containsKey(key)) {
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(entry);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key) || timestamp < map.get(key).get(0).timestamp()) {
            return "";
        } else {
            //when the record exist and the timestamp meet meet requirement
            List<Entry> list = map.get(key);

            int left = 0;
            int right = list.size() - 1;

            while (left <= right) {
                int mid = left + (right - left)/2;
                if (list.get(mid).timestamp() <= timestamp){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return list.get(right).value();
            
        }
            
    }

    record Entry(int timestamp, String value) {}
}
