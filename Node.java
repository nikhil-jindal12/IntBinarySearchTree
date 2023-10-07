/**
 * Class that contains the implementation for a node of a binary search tree that holds integers
 */
public class Node {

    // instance field that holds the key of the node
    private int key;

    // instance field that holds the left child of the node
    private Node left;

    // instance field that holds the right child of the node
    private Node right;

    // constructor that initializes the key of the node
    public Node(int key) {
        this.key = key;
    }

    /**
     * Returns the key of the node
     * @return the key of the node
     */
    public int getKey() {
        return this.key;
    }

    /**
     * Returns the left child of the node
     * @return the left child of the node
     */
    public Node getLeft() {
        return this.left;
    }

    /**
     * Sets the left child of the node
     * @param left  the left child of the node
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Returns the right child of the node
     * @return the right child of the node
     */
    public Node getRight() {
        return this.right;
    }

    /**
     * Sets the right child of the node
     * @param right  the right child of the node
     */
    public void setRight(Node right) {
        this.right = right;
    }

}
