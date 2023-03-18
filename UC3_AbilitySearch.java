package hashtable;

public class UC3_AbilitySearch {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    class BinaryTree {
        TreeNode root;

        public BinaryTree() {
            this.root = null;
        }

        public void add(int val) {
            // implementation of add method here
        }

        public boolean search(int val) {
            return search(root, val);
        }

        private boolean search(TreeNode node, int val) {
            if (node == null) {
                return false;
            } else if (node.val == val) {
                return true;
            } else if (val < node.val) {
                return search(node.left, val);
            } else {
                return search(node.right, val);
            }
        }
    }

    public class SearchBinaryTree {
        public static void main(String[] args) {
            BinaryTree bt = new BinaryTree();

            bt.add(50);
            bt.add(30);
            bt.add(70);
            bt.add(20);
            bt.add(40);
            bt.add(60);
            bt.add(80);

            int target = 63;
            boolean found = bt.search(target);

            if (found) {
                System.out.println("The value " + target + " was found in the binary tree.");
            } else {
                System.out.println("The value " + target + " was not found in the binary tree.");
            }
        }
    }
}
