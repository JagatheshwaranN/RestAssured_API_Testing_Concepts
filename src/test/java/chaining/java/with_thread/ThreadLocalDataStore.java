package chaining.java.with_thread;

import java.util.LinkedHashMap;

public class ThreadLocalDataStore {

    private ThreadLocalDataStore(){

    }

    private static final ThreadLocal<LinkedHashMap<String, Object>> dataMap = ThreadLocal.withInitial(LinkedHashMap::new);

    public static Object getDataMap(String key) {
        return dataMap.get().get(key);
    }

    public static void setDataMap(String key, Object value) {
        dataMap.get().put(key, value);
    }

}
