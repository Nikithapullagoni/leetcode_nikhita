class Data {
    String value;
    int timestamp;

    public Data(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    Map<String, ArrayList<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        ArrayList<Data> list = map.get(key);
        int left = 0, right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid).timestamp == timestamp) {
                return list.get(mid).value;
            } else if (list.get(mid).timestamp < timestamp) {
                result = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}