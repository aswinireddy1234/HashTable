package hashtable;

    class MyBinaryNode<K extends Comparable<K>> implements INode<K> {
        K key;
        MyBinaryNode<K> left;
        MyBinaryNode<K> right;

        public MyBinaryNode(K key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
        public int compareTo(K key) {
            return this.key.compareTo(key);
        }
    }

    class MyBST<K extends Comparable<K>> {
        MyBinaryNode<K> root;

        public MyBST() {
            this.root = null;
        }

        public void add(K key) {
            MyBinaryNode<K> node = new MyBinaryNode<K>(key);

            if (root == null) {
                root = node;
                return;
            }

            MyBinaryNode<K> current = root;
            while (current != null) {
                int cmp = node.compareTo(current.key);
                if (cmp < 0) {
                    if (current.left == null) {
                        current.left = node;
                        return;
                    }
                    current = current.left;
                } else if (cmp > 0) {
                    if (current.right == null) {
                        current.right = node;
                        return;
                    }
                    current = current.right;
                } else {
                    return;
                }
            }
        }
    }

    public class CreateBST {
        public static void main(String[] args) {
            MyBST<Integer> bst = new MyBST<Integer>();
            bst.add(56);
            bst.add(30);
            bst.add(70);
    }
 }
