import java.util.LinkedList;
import java.util.Queue;

/**
 * Removes nodes from a binary search tree and traverses the tree preorder and postorder
 *
 * @author Tyler Lynch
 * 2022
 * 
 * @param <K> Key for a map
 * @param <V> Value for a map
 */
public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBinarySearchTree<K,V> {

    /**
     * Removes the mapping for a key from this map if it is present
     * (optional operation).   More formally, if this map contains a mapping
     * from key <tt>k</tt> to value <tt>v</tt> such that
     * <code>(key==null ?  k==null : key.equals(k))</code>, that mapping
     * is removed.  (The map can contain at most one such mapping.)
     *
     * <p>Returns the value to which this map previously associated the key,
     * or <tt>null</tt> if the map contained no mapping for the key.
     *
     * <p>If this map permits null values, then a return value of
     * <tt>null</tt> does not <i>necessarily</i> indicate that the map
     * contained no mapping for the key; it's also possible that the map
     * explicitly mapped the key to <tt>null</tt>.
     *
     * <p>The map will not contain a mapping for the specified key once the
     * call returns.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with <tt>key</tt>, or
     *      <tt>null</tt> if there was no mapping for <tt>key</tt>.
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *                                       is not supported by this map
     * @throws ClassCastException            if the key is of an inappropriate type for
     *                                       this map
     *                                       (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if the specified key is null and this
     *                                       map does not permit null keys
     *                                       (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    @SuppressWarnings("unchecked")
    @Override
    public V remove(Object key) {
        if (key == null) throw new NullPointerException("Specified key is null.");
    
        Node target = getRoot();
        boolean found = false;
    
        // Search for the node
        while (target != null) {
            int cmp = target.getKey().compareTo((K) key);
            if (cmp < 0) {
                target = target.getRightChild();
            } else if (cmp > 0) {
                target = target.getLeftChild();
            } else {
                found = true;
                break;
            }
        }
    
        if (!found) return null;
    
        V value = target.getValue();
    
        if (target.isLeaf()) {
            removeLeaf(target);
        } else if (target.hasLeftChild() && !target.hasRightChild()) {
            replaceNodeWithChild(target, target.getLeftChild());
        } else if (!target.hasLeftChild() && target.hasRightChild()) {
            replaceNodeWithChild(target, target.getRightChild());
        } else {
            Node successor = target.getRightChild();
            while (successor.hasLeftChild()) {
                successor = successor.getLeftChild();
            }
    
            if (successor.getParent() != target) {
                transplant(successor, successor.getRightChild());
                successor.setRightChild(target.getRightChild());
                if (successor.getRightChild() != null)
                    successor.getRightChild().setParent(successor);
            }
    
            transplant(target, successor);
            successor.setLeftChild(target.getLeftChild());
            if (successor.getLeftChild() != null)
                successor.getLeftChild().setParent(successor);
    
            if (target.isRoot()) {
                setRoot(successor);
            }
        }
    
        decrementSize();
        return value;
    }

    /**
     * Removes a leaf node from the Binary Search Tree.
     *
     * A leaf is a node that has no children. This method disconnects the
     * leaf from its parent and clears its parent reference.
     *
     * Example:
     *    Before removal of 3:
     *              2
     *             / \
     *            1   3
     *
     *    After removal of 3:
     *              2
     *             /
     *            1
     *
     * @param node the node to be removed (must be a leaf)
     */
    private void removeLeaf(Node node) {
        if (node.isRoot()) {
            setRoot(null);
        } else {
            Node parent = node.getParent();
            if (parent.getLeftChild() == node) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        }
        node.setParent(null);
    }
    
    /**
     * Replaces a node in the tree with its only child.
     *
     * Used when a node has only one child and needs to be removed.
     * The child takes the place of the node, and parent/child pointers
     * are updated accordingly.
     *
     * Example:
     *    Before:
     *              2
     *             /
     *            1
     *
     *    Remove 2:
     *    After:
     *            1
     *
     * @param node the node to be removed
     * @param child the only child of the node that will replace it
     */
    private void replaceNodeWithChild(Node node, Node child) {
        if (node.isRoot()) {
            setRoot(child);
            child.setParent(null);
        } else {
            Node parent = node.getParent();
            child.setParent(parent);
            if (parent.getLeftChild() == node) {
                parent.setLeftChild(child);
            } else {
                parent.setRightChild(child);
            }
        }
    }
    
    /**
     * Replaces one node with another in the tree structure.
     *
     * Used during deletion to transplant a successor or child node
     * into the position of a node being removed. Updates parent-child
     * links accordingly.
     *
     * Example:
     *    Replacing node 2 with node 3:
     *              4
     *             / \
     *            2   5
     *             \
     *              3
     *
     *    After transplant:
     *              4
     *             / \
     *            3   5
     *
     * @param oldNode the node to be replaced
     * @param newNode the node to replace oldNode
     */
    private void transplant(Node oldNode, Node newNode) {
        if (oldNode.isRoot()) {
            setRoot(newNode);
        } else {
            Node parent = oldNode.getParent();
            if (parent.getLeftChild() == oldNode) {
                parent.setLeftChild(newNode);
            } else {
                parent.setRightChild(newNode);
            }
        }
        if (newNode != null) {
            newNode.setParent(oldNode.getParent());
        }
    }    

    /**
     * Recursive Algorithm: Postorder Binary Tree Traversal
     *    1. Postorder traverse the left subtree.
     *    2. Postorder traverse the right subtree.
     *    3. Visit the root.
     *
     * Example:
     *    Tree
     *              4
     *             / \
     *            2   5
     *           / \
     *          1   3
     *
     *    Postorder traversal: 1, 3, 2, 5, 4
     *
     * @param visitor Lambda expression to process the key and value of each node.
     *                For example: (key, value) -> System.out.println( key )
     */
    @Override
    public void traversePostorder(Visitor visitor) {
        traversePostorderHelper( getRoot() , visitor);
    }

    // Helper method used by the traversePostorder method
    // Recursive Solution
    private void traversePostorderHelper(Node node, Visitor visitor) {
        if (node == null) return;
        traversePostorderHelper(node.getLeftChild(), visitor);
        traversePostorderHelper(node.getRightChild(), visitor);
        visitor.visit(node.getKey(), node.getValue());
    }

    /**
     * Recursive Algorithm: Inorder Binary Tree Traversal
     *    1. Inorder traverse the left subtree.
     *    2. Visit the root.
     *    3. Inorder traverse the right subtree.
     *
     * Example:
     *    Tree
     *              4
     *             / \
     *            2   5
     *           / \
     *          1   3
     *
     *    Inorder traversal: 1, 2, 3, 4, 5
     *
     * This traversal is commonly used in Binary Search Trees
     * to retrieve values in sorted (ascending) order.
     *
     * @param visitor Lambda expression to process the key and value of each node.
     *                For example: (key, value) -> System.out.println(key)
     */
    @Override
    public void traverseInorder(Visitor visitor) {
        traverseInorderHelper(getRoot(), visitor);
    }

    // Helper method used by the traverseInorder method
    // Recursive Solution
    private void traverseInorderHelper(Node node, Visitor visitor) {
        if (node == null) return;
        traverseInorderHelper(node.getLeftChild(), visitor);
        visitor.visit(node.getKey(), node.getValue());
        traverseInorderHelper(node.getRightChild(), visitor);
    }

    /**
     * Iterative Algorithm: Level order Binary Tree Traversal
     *    Beginning at the root, visit each node in a level, from left to right
     *    then proceeding to the next level and repeat until all nodes are visited.
     *
     * Example:
     *    Tree
     *              4
     *             / \
     *            2   5
     *           / \
     *          1   3
     *
     *    Level order traversal: 4, 2, 5, 1, 3
     *
     * Hint: Every time you visit a node, add its children to a queue.
     *
     * @param visitor Lambda expression to process the key and value of each node.
     *                For example: (key, value) -> System.out.println( key )
     */
    @Override
    public void traverseLevelorder(Visitor visitor) {
        if ( getRoot() == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add( getRoot() );
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            visitor.visit(current.getKey(), current.getValue());
            if (current.hasLeftChild()) queue.add(current.getLeftChild());
            if (current.hasRightChild()) queue.add(current.getRightChild());
        }
    }
}