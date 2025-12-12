import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Ryan Weinswig
 * @version: December 10th
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        // Call the helper function
        return helperSearch(root, val);
    }

    // Helper function
    public  boolean helperSearch(BSTNode n, int val) {
        // If the tree itself is empty
        if (n == null) {
            // Then value can't be there
            return false;
        }

        // If we have the value, return true because it is in it
        if (n.getVal() == val) {
            return true;
        }

        // If the root of the smaller tree is less than value, then we will go right
        // Then we will rerun this function to see if it is there
        if (n.getVal() < val) {
            return helperSearch(n.getRight(), val);
        }

        // If the root is bigger than value
        // Go right and traverse that smaller tree
        if (n.getVal() > val) {
            return helperSearch(n.getLeft(), val);
        }

        // If we went throguh everything, and the value does not exist, return false
        return false;

    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */

    // Go inorder traversal
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // Create the list which has all the values inorder
        ArrayList<BSTNode> list = new ArrayList<>();
        helperInorder(root, list);
        return list;
    }

    // Helper function
    public void helperInorder(BSTNode n, ArrayList<BSTNode> array) {
        // If the tree is now empty underneath, stop going through
        if (n == null) {
            return;
        }

        // Go down all the way left, calling function over and over
        // Add all of the left
        helperInorder(n.getLeft(), array);
        // Add the root
        array.add(n);
        // Go down the tree adding everything that is on the right
        helperInorder(n.getRight(), array);

    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        // Gets the preorder list by creating another list
        ArrayList<BSTNode> list2 = new ArrayList<>();
        helperPreorder(root, list2);
        return list2;
    }

    public void helperPreorder(BSTNode n, ArrayList<BSTNode> array) {
        // If tree is empty, then return since the tree is over
        if (n == null) {
            return;
        }
        // Add the root first
        array.add(n);

        // Traverse the left subtree
        helperPreorder(n.getLeft(), array);

        // Traverse the right subtree
        helperPreorder(n.getRight(), array);

    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        // Creates a list and calls helper to get postover
        ArrayList<BSTNode> list3 = new ArrayList<>();
        helperPostorder(root, list3);
        return list3;
    }

    // Helper function
    public void helperPostorder(BSTNode n, ArrayList<BSTNode> array) {
        // If tree is empty, return
        if (n == null) {
            return;
        }
        // Add the left side first, going all the way down
        helperPostorder(n.getLeft(), array);

        // Add the right side now to the list
        helperPostorder(n.getRight(), array);
        // Add the root
        array.add(n);

    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // Calls the helper
        root = helperInsert(root, val);
        // TODO: Complete insert
    }

    public BSTNode helperInsert(BSTNode n, int val) {
        // If the val equals the root, then just return the tree we already have
        // No duplicates are allowed
        if (n == null) {
            return new BSTNode(val);
        }

        if (val == n.getVal()) {
            return n;
        }

        // If the root is bigger than value, then go left
        if (n.getVal() > val) {
            // Goes left and recalls with function by going left
            n.setLeft(helperInsert(n.getLeft(), val));
        }
        else{
            // Otherwise go right and look at trees
            n.setRight(helperInsert(n.getRight(), val));
        }

        // return the new tree

        return n;

    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        ArrayList<BSTNode> sol2 = tree.getInorder();
        printNodes(sol2);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
       sol = tree.getInorder();
       printNodes(sol);
    }
}
