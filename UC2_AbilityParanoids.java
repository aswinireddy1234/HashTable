package hashtable;
import java.util.LinkedList;
public class AbilityParanoids {
    String key;
    int value;

    public AbilityParanoids(String key, int value) {
        this.key = key;
        this.value = value;
        }
    }

    class MyHashTable {
        LinkedList<AbilityParanoids>[] buckets;

        public MyHashTable(int size) {
            this.buckets = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                buckets[i] = new LinkedList<AbilityParanoids>();
            }
        }

        public void put(String key) {
            int hash = Math.abs(key.hashCode() % buckets.length);
            LinkedList<AbilityParanoids> bucket = buckets[hash];

            for (AbilityParanoids node : bucket) {
                if (node.key.equals(key)) {
                    node.value++;
                    return;
                }
            }

            bucket.add(new AbilityParanoids(key, 1));
        }

        public int get(String key) {
            int hash = Math.abs(key.hashCode() % buckets.length);
            LinkedList<AbilityParanoids> bucket = buckets[hash];

            for (AbilityParanoids node : bucket) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }

            return 0;
        }

        public void printFrequencies() {
            for (LinkedList<AbilityParanoids> bucket : buckets) {
                for (AbilityParanoids node : bucket) {
                    System.out.println(node.key + ": " + node.value);
                }
            }
        }
    }

    public class WordFrequency {
        public static void main(String[] args) {
            String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
            String[] words = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

            MyHashTable hashtable = new MyHashTable(words.length / 2);

            for (String word : words) {
                hashtable.put(word);
            }

            hashtable.printFrequencies();
    }
 }

