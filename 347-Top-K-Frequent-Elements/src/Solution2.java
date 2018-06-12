import java.util.*;

public class Solution2 {

    private class Freq{
        public int key;
        public int freq;

        Freq(int key1, int freq1) { key = key1; freq = freq1; }
        Freq() { this(0, 0); }
    }

    private class FreqComparator implements Comparator<Freq> {
        @Override
        public int compare(Freq a, Freq b) { return a.freq - b.freq; }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for (int num : nums) {
            if (tm.containsKey(num))
                tm.put(num, tm.get(num) + 1);
            else
                tm.put(num, 1);
        }

        //PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());
        PriorityQueue<Freq> pq = new PriorityQueue<>(new Comparator<Freq>() {
            @Override
            public int compare(Freq a, Freq b) {
                return a.freq - b.freq;
            }
        });
        for (int key : tm.keySet()) {
            int keyfreq = tm.get(key);
            if (pq.size() < k)
                pq.add(new Freq(key, keyfreq));
            else if (pq.peek().freq < keyfreq) {
                pq.remove();
                pq.add(new Freq(key, keyfreq));
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty())
            res.add(pq.remove().key);
        return res;
    }
}
