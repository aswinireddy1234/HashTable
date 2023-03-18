package hashtable;
import java.util.LinkedList;

public class AbilityFrequency {
        String key;
        int value;

        public MyMapNode(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class MyHashTable {
        LinkedList<MyMapNode>[] buckets;

        public MyHashTable(int size) {
            this.buckets = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                buckets[i] = new LinkedList<MyMapNode>();
            }
        }

        public void put(String key) {
            int hash = Math.abs(key.hashCode() % buckets.length);
            LinkedList<MyMapNode> bucket = buckets[hash];

            for (MyMapNode node : bucket) {
                if (node.key.equals(key)) {
                    node.value++;
                    return;
                }
            }

            bucket.add(new MyMapNode(key, 1));
        }

        public int get(String key) {
            int hash = Math.abs(key.hashCode() % buckets.length);
            LinkedList<MyMapNode> bucket = buckets[hash];

            for (MyMapNode node : bucket) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }

            return 0;
        }

        public void printFrequencies() {
            for (LinkedList<MyMapNode> bucket : buckets) {
                for (MyMapNode node : bucket) {
                    System.out.println(node.key + ": " + node.value);
                }
            }
        }
    }

    public class WordFrequency {
        public static void main(String[] args) {
            String sentence = "To be or not to be";
            String[] words = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

            MyHashTable hashtable = new MyHashTable(words.length);

            for (String word : words) {
                hashtable.put(word);
            }

            hashtable.printFrequencies();
    }
}
