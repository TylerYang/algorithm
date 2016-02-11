public class MorrisTraversal {
    public void inorder(TreeNode root) {
        while(root != null) {
            if(root.left == null) {
                print(root);
                root = root.right;
            } else {
                TreeNode node = root.left;
                while(node.right != null && node.right != root) {
                    node = node.right;
                }
                if(node.right == null) {
                    node.right = root;
                    root = root.left;
                } else {
                    node.right = null;
                    print(root);
                    root = root.right;
                }
            }     
        }
        System.out.println("");
    }
    public void preorder(TreeNode root) {
        while(root != null) {
            if(root.left == null) {
                print(root);
                root = root.right;
            } else {
                TreeNode node = root.left;
                while(node.right != null && node.right != root) {
                    node = node.right;
                }
                if(node.right == null) {
                    node.right = root;
                    print(root);
                    root = root.left;
                } else {
                    node.right = null;
                    root = root.right;
                }
            }
        }
        System.out.println("");
    }
    public void postorder(TreeNode root) {
        TreeNode dump = new TreeNode(0);
        dump.left = root;
        TreeNode curr = dump;
        while(curr != null) {
            if(curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode node = curr.left;
                while(node.right != null && node.right != curr) node = node.right;
                if(node.right == null) {
                    node.right = curr;
                    curr = curr.left;
                } else {
                    printReverse(curr.left, node);
                    node.right = null;
                    curr = curr.right; 
                }
            }
        }
        System.out.println("");
    }
    private void printReverse(TreeNode from, TreeNode to) {
        reverse(from, to); 
        TreeNode node = to;
        while(true) {
            print(node);
            if(node == from) break;
            node = node.right;
        } 

        reverse(to, from); 
    }
    private void reverse(TreeNode from, TreeNode to) {
        if(from == to) return;
        TreeNode x = from, y = from.right, z;     
        while(true) {
            z = y.right;
            y.right = x;
            x = y;
            y = z;
            if(x == to) break;
        }
    }
    private void print(TreeNode root) {
        System.out.print(root.val + " ");
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.right = n6;
        n6.left = n7;
        n3.right = n8;

        MorrisTraversal mt = new MorrisTraversal();
        
        System.out.println("Morris preorder traversal:");
        mt.preorder(n1);

        System.out.println("Morris inorder traversal:");
        mt.inorder(n1);

        System.out.println("Morris postorder traversal:");
        mt.postorder(n1);
    }
}
