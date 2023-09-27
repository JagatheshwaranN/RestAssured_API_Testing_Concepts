package chaining.java.without_thread;

import java.util.LinkedHashMap;

public class DataStore {

    private DataStore(){

    }

    private static final LinkedHashMap<String, Object> dataMap = new LinkedHashMap<>();

    public static Object getDataMap(String key) {
        return dataMap.get(key);
    }

    public static void setDataMap(String key, Object value) {
        dataMap.put(key, value);
    }

}
