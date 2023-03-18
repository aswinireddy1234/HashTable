package hashtable;

public class UC2_BinaryTree {

        int val;
        BinaryTree left;
        BinaryTree right;
        BinaryTree (int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    class BinaryTree {
        BinaryTree  root;

        public BinaryTree() {
            this.root = null;
        }

        public void add(int val) {
            BinaryTree  newNode = new BinaryTree (val);

            if (root == null) {
                root = newNode;
                return;
            }

            Queue < BinaryTree > q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                BinaryTree  node = q.poll();

                if (node.left == null) {
                    node.left = newNode;
                    return;
                } else {
                    q.add(node.left);
                }

                if (node.right == null) {
                    node.right = newNode;
                    return;
                } else {
                    q.add(node.right);
                }
            }
        }

        public int size() {
            return size(root);
        }

        private int size(BinaryTree  node) {
            if (node == null) {
                return 0;
            } else {
                return size(node.left) + 1 + size(node.right);
            }
        }
    }

    public class CreateBinaryTree {
        public static void main(String[] args) {
            BinaryTree bt = new BinaryTree();

            bt.add(1);
            bt.add(2);
            bt.add(3);
            bt.add(4);
            bt.add(5);
            bt.add(6);
            bt.add(7);

            System.out.println("The size of the binary tree is: " + bt.size());
    }
}
