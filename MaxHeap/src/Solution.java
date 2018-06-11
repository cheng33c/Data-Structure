// Leetcode 349
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;

public class Solution {

    private class Freq implements Comparable<Freq> {
        public int key;
        public int freq;

        Freq(int key1, int freq1) { key = key1; freq = freq1; }
        Freq() { this(0, 0); }

        @Override
        public int compareTo(Freq another) {
            // 应用在优先队列中，越小越往前排，可以把频率小的元素快速出队
            if (freq < another.freq)
                return 1;
            else if (freq == another.freq)
                return 0;
            else
                return -1;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for (int num : nums) {
            if (tm.containsKey(num))
                tm.put(num, tm.get(num) + 1);
            else
                tm.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key : tm.keySet()) {
            int keyfreq = tm.get(key);
            if (pq.getSize() < k)
                pq.enqueue(new Freq(key, keyfreq));
            else if (pq.getFront().freq < keyfreq) {
                    pq.dequeue();
                    pq.enqueue(new Freq(key, keyfreq));
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty())
            res.add(pq.dequeue().key);
        return res;
    }
}
