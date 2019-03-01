package other;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dengyouquan
 **/
public class LRUCache1 {
    private static final int cacheSize = 4;
    private static Map<String, String> lru = new LinkedHashMap<String, String>((int) Math.ceil(cacheSize / 0.75f) + 1, .75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
            return lru.size() > cacheSize;
        }
    };

    public static void main(String[] args) {
        lru.put("1", "1");
        lru.put("2", "2");
        lru.put("3", "3");
        lru.put("4", "4");
        lru.put("1", "1");
        lru.put("5", "5");
        System.out.println(lru);
    }
}
