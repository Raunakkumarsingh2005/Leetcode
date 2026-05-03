// LFU Cache
class LFUCache {

    class Node {
        int key, val, freq;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            val = v;
            freq = 1;
        }
    }

    class DLList {
        Node head, tail;
        int size;

        DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node last = tail.prev;
                remove(last);
                return last;
            }
            return null;
        }
    }

    private int capacity, minFreq;
    private Map<Integer, Node> map;
    private Map<Integer, DLList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            update(node);
        } else {
            if (map.size() == capacity) {
                DLList list = freqMap.get(minFreq);
                Node toRemove = list.removeLast();
                map.remove(toRemove.key);
            }

            Node node = new Node(key, value);
            minFreq = 1;
            freqMap.computeIfAbsent(1, k -> new DLList()).add(node);
            map.put(key, node);
        }
    }

    private void update(Node node) {
        int freq = node.freq;
        DLList list = freqMap.get(freq);
        list.remove(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DLList()).add(node);
    }
}