package SearchIntoBinarySearchTree;

public interface Tree<E> {
    /**
     * Insert element e into the binary search tree.
     * Return true if the element is inserted successfully.
     */
    public boolean insert(E e);
    /**
     * Inorder traversal from the root
     */
    public void Inorder();
    /**
     * Get the number of nodes in the tree
     */
    public int getSize();

    /**
     * Search element in the tre
     */

    public TreeNode search(TreeNode<E> root, E data);
}