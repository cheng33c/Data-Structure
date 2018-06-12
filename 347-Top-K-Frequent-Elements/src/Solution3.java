import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution3 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for (int num : nums) {
            if (tm.containsKey(num))
                tm.put(num, tm.get(num) + 1);
            else
                tm.put(num, 1);
        }

        // 使用匿名类方法简短代码
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return tm.get(a) - tm.get(b);
            }
        });
        for (int key : tm.keySet()) {
            int keyfreq = tm.get(key);
            if (pq.size() < k)
                pq.add(key);
            else if (tm.get(pq.peek()) < keyfreq) {
                pq.remove();
                pq.add(key);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty())
            res.add(pq.remove());
        return res;
    }
}
