package coding_practice;

public class MyHashMap <K, V> {
    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;
        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private int capacity;
    private Node<K, V> [] buckets;
    int size;

    public MyHashMap() {
        this.capacity = 16;
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    int hash(K key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>>16);
    }

    public void put(K key, V value) {
        int hash = hash(key);
        int index = ( capacity -1 ) & hash;
        Node<K, V> head = buckets[index];
        if(head == null) {
            buckets[index] = new Node<>(hash, key, value, null);
            size++;
        } else {
            Node<K , V> current = head;
            while(current != null){
                if((current.hash == hash) && (current.key == key || (key.equals(current.key)))) {
                    current.value = value;
                    return;
                }
                current = current.next;

            }
            buckets[index] = new Node<>(hash, key, value, head);
            size++;
        }
    }

    public V get(K key){
        int hash = hash(key);
        int index = ( capacity -1 ) & hash;
        Node<K, V> head = buckets[index];
        Node<K, V> current = head;
        while(current != null) {
            if((current.hash == hash) && (current.key == key || (key.equals(current.key)))) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < capacity; i++) {
            Node<K, V> current = buckets[i];
            while (current != null) {
                sb.append(current.key).append("=").append(current.value).append(", ");
                current = current.next;
            }
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2); // Remove last comma and space
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println(map);

        System.out.println(map.get("two"));
        System.out.println(map.get("four"));

        map.put("two", 22);
        System.out.println(map);
    }

}
