package hashtable;
import java.util.LinkedList;
public class RemoveAvoidable {
    String key;
    int value;

    public RemoveAvoidable (String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class MyHashTable {
        LinkedList<RemoveAvoidable >[] buckets;

        public MyHashTable(int size) {
            this.buckets = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                buckets[i] = new LinkedList<RemoveAvoidable >();
            }
        }

        public void put(String key) {
            int hash = Math.abs(key.hashCode() % buckets.length);
            LinkedList<RemoveAvoidable > bucket = buckets[hash];

            for (RemoveAvoidable  node : bucket) {
                if (node.key.equals(key)) {
                    node.value++;
                    return;
                }
            }

            bucket.add(new RemoveAvoidable (key, 1));
        }

        public void remove(String key) {
            int hash = Math.abs(key.hashCode() % buckets.length);
            LinkedList<RemoveAvoidable > bucket = buckets[hash];

            for (RemoveAvoidable  node : bucket) {
                if (node.key.equals(key)) {
                    bucket.remove(node);
                    return;
                }
            }
        }

        public void printFrequencies() {
            for (LinkedList<RemoveAvoidable > bucket : buckets) {
                for (RemoveAvoidable  node : bucket) {
                    System.out.println(node.key + ": " + node.value);
                }
            }
        }
    }

    public class RemoveWord {
        public static void main(String[] args) {
            String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
            String[] words = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

            MyHashTable hashtable = new MyHashTable(words.length / 2);

            for (String word : words) {
                hashtable.put(word);
            }

            hashtable.remove("avoidable");

            hashtable.printFrequencies();
        }
    }
