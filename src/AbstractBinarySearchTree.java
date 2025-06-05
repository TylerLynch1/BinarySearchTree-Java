import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;

/**
 * DESCRIPTION: A Binary Search Tree that functions as a Map.
 * YOUR TASK: Implement the following three methods
 *    public abstract void traversePostorder( Visitor visitor );
 *    public abstract void traverseLevelorder( Visitor visitor );
 */
public abstract class AbstractBinarySearchTree<K extends Comparable<K>, V> implements Map<K,V>, Iterable<V> {
   // =======================================================================
   // ABSTRACT METHODS
   // =======================================================================
   // IMPLEMENT THE FOLLOWING THREE ABSTRACT METHODS

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
   @Override
   public abstract V remove ( Object key );

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
   public abstract void traversePostorder( Visitor visitor );

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
   public abstract void traverseLevelorder( Visitor visitor );


   // =======================================================================
   // INNER CLASS DEFINITIONS
   // =======================================================================

   /**
    * A map entry (key-value pair).
    */
   protected class KeyValuePair implements Entry<K,V> {
      private K key;
      private V value;

      public KeyValuePair ( K key, V value ) {
         this.key = key;
         this.value = value;
      }

      /**
       * Returns the key corresponding to this entry.
       *
       * @return the key corresponding to this entry
       * @throws IllegalStateException implementations may, but are not
       *                               required to, throw this exception if the entry has been
       *                               removed from the backing map.
       */
      @Override
      public K getKey ( ) {
         return key;
      }

      /**
       * Returns the value corresponding to this entry.  If the mapping
       * has been removed from the backing map (by the iterator's
       * <tt>remove</tt> operation), the results of this call are undefined.
       *
       * @return the value corresponding to this entry
       * @throws IllegalStateException implementations may, but are not
       *                               required to, throw this exception if the entry has been
       *                               removed from the backing map.
       */
      @Override
      public V getValue ( ) {
         return value;
      }

      /**
       * Replaces the value corresponding to this entry with the specified
       * value (optional operation).  (Writes through to the map.)  The
       * behavior of this call is undefined if the mapping has already been
       * removed from the map (by the iterator's <tt>remove</tt> operation).
       *
       * @param value new value to be stored in this entry
       * @return old value corresponding to the entry
       * @throws UnsupportedOperationException if the <tt>put</tt> operation
       *                                       is not supported by the backing map
       * @throws ClassCastException            if the class of the specified value
       *                                       prevents it from being stored in the backing map
       * @throws NullPointerException          if the backing map does not permit
       *                                       null values, and the specified value is null
       * @throws IllegalArgumentException      if some property of this value
       *                                       prevents it from being stored in the backing map
       * @throws IllegalStateException         implementations may, but are not
       *                                       required to, throw this exception if the entry has been
       *                                       removed from the backing map.
       */
      @Override
      public V setValue ( V value ) {
         V oldValue = this.value;
         this.value = value;
         return oldValue;
      }

      @Override
      public String toString ( ) {
         return String.format("<%s,%s>", key, value);
      }
   }

   /**
    * A Binary Search Tree node. Each node contains an entry, which is a KeyValuePair, 
    * and references to its parent node, its left child and its right child.
    */
   protected class Node implements Comparable<Node> {
      private KeyValuePair entry;
      private Node parent, leftChild, rightChild;

      public Node ( KeyValuePair entry ) {
         this.entry = entry;
      }

      /**
       * @return the KeyValuePair contained in the node
       */
      public KeyValuePair getEntry ( ) {
         return entry;
      }

      /**
       * Set the KeyValuePair
       * @param entry an instance of KeyValuePair
       */
      public void setEntry ( KeyValuePair entry ) {
         this.entry = entry;
      }

      /**
       * @return the key contained in the node's entry
       */
      public K getKey ( ) {
         return entry.getKey( );
      }

      /**
       * @return the value contained in the node's entry
       */
      public V getValue ( ) {
         return entry.getValue( );
      }

      /**
       * Set the value in the node's entry
       * @param value in the KeyValuePair
       */
      public void setValue ( V value ) {
         entry.setValue( value );
      }

      /**
       * @return true if the node has a left child
       */
      public boolean hasLeftChild( ) {
         return leftChild != null;
      }

      /**
       * @return the left child of the node or null if there is none.
       */
      public Node getLeftChild ( ) {
         return leftChild;
      }

      /**
       * Set the left child of the node.
       * If left-child is not null, set its parent to be this node
       * @param leftChild a node
       */
      public void setLeftChild ( Node leftChild ) {
         this.leftChild = leftChild;
         if ( leftChild != null ) {
            leftChild.parent = this;
         }
      }

      /**
       * @return true if the node has a right child.
       */
      public boolean hasRightChild( ) {
         return rightChild != null;
      }

      /**
       * @return The right child of the node or null if there is none.
       */
      public Node getRightChild ( ) {
         return rightChild;
      }

      /**
       * Set the right child of the node.
       * If not null, set the parent of the right child to be this node.
       * @param rightChild
       */
      public void setRightChild ( Node rightChild ) {
         this.rightChild = rightChild;
         if ( rightChild != null ) {
            rightChild.parent = this;
         }
      }

      /**
       * @return true if the node has a parent.
       */
      public boolean hasParent( ) {
         return parent != null;
      }

      /**
       * @return The parent of the node or null if the node is the root.
       */
      public Node getParent ( ) {
         return parent;
      }

      /**
       * Set the parent of the node.
       * @param parent a node.
       */
      public void setParent ( Node parent ) {
         this.parent = parent;
      }

      /**
       * @return true if the node is the root.
       */
      public boolean isRoot( ) {
         return root == this;
      }

      /**
       * @return true if the node is a leaf, i.e. it has no children.
       */
      public boolean isLeaf( ) {
         return !hasLeftChild() && !hasRightChild();
      }

      /**
       * Compares this object with the specified object for order.  Returns a
       * negative integer, zero, or a positive integer as this object is less
       * than, equal to, or greater than the specified object.
       *
       * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
       * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
       * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
       * <tt>y.compareTo(x)</tt> throws an exception.)
       *
       * <p>The implementor must also ensure that the relation is transitive:
       * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
       * <tt>x.compareTo(z)&gt;0</tt>.
       *
       * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
       * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
       * all <tt>z</tt>.
       *
       * <p>It is strongly recommended, but <i>not</i> strictly required that
       * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
       * class that implements the <tt>Comparable</tt> interface and violates
       * this condition should clearly indicate this fact.  The recommended
       * language is "Note: this class has a natural ordering that is
       * inconsistent with equals."
       *
       * <p>In the foregoing description, the notation
       * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
       * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
       * <tt>0</tt>, or <tt>1</tt> according to whether the value of
       * <i>expression</i> is negative, zero or positive.
       *
       * @param o the object to be compared.
       * @return a negative integer, zero, or a positive integer as this object
       *      is less than, equal to, or greater than the specified object.
       * @throws NullPointerException if the specified object is null
       * @throws ClassCastException   if the specified object's type prevents it
       *                              from being compared to this object.
       */
      @Override
      public int compareTo ( Node o ) {
         if ( getEntry( ) == null || o.getEntry( ) == null ) {
            throw new NullPointerException( "Can't compare null values." );
         }
         return getEntry( ).getKey().compareTo( o.getEntry( ).getKey() );
      }

      /**
       * @return stringified representation of the node
       */
      @Override
      public String toString ( ) {
         return entry.toString();
      }
   }

   /**
    * A functional interface used to visit node in a traversal.
    */
   public interface Visitor {
      public void visit( Object key, Object value );
   }

   /**
    * An implementation of the ITerator interface.
    * Used to iterate through the values in the BST in an inorder fashion.
    */
   private class TreeIterator implements Iterator<V> {
      private LinkedList<V> list = new LinkedList<>(  );
      private int setpoint = changeCounter;

      @SuppressWarnings("unchecked")
      public TreeIterator( ) {
         traverseInorder( (key, value) -> list.add( (V) value ) );
      }

      /**
       * Returns {@code true} if the iteration has more elements.
       * (In other words, returns {@code true} if {@link #next} would
       * return an element rather than throwing an exception.)
       *
       * @return {@code true} if the iteration has more elements
       */
      @Override
      public boolean hasNext ( ) {
         return !list.isEmpty();
      }

      /**
       * Returns the next element in the iteration.
       *
       * @return the next element in the iteration
       * @throws NoSuchElementException if the iteration has no more elements
       */
      @Override
      public V next ( ) {
         if ( setpoint != changeCounter ) {
            throw new ConcurrentModificationException(  );
         }
         if ( list.isEmpty() ) {
            throw new NoSuchElementException(  );
         }
         return list.poll();
      }
   }

   // =======================================================================
   // INSTANCE VARIABLES
   // =======================================================================

   private Node root = null; // Root node of the BST
   private int changeCounter = 0; // Incremented every time a change is made to the BST.
   private int size = 0; // The number of nodes in the BST

   // =======================================================================
   // INSTANCE METHODS
   // =======================================================================

   /**
    * @return the root node of the BST, or null if the tree is empty.
    */
   protected Node getRoot( ) {
      return root;
   }

   /**
    * Set the root node of the tree.
    * @param newRoot a node
    */
   protected void setRoot( Node newRoot ) {
      root = newRoot;
   }

   /**
    * Increments the change counter.
    * @return the value of the change counter after incrementing.
    */
   protected int incrementChangeCounter( ) {
      return ++changeCounter;
   }

   /**
    * @return the number of nodes in the BST.
    */
   public int size( ) {
      return size;
   }

   /**
    * Set the size variable of the BST.
    * @param newSize represents the new number of nodes in the BST.
    */
   protected void setSize( int newSize ) {
      size = newSize;
   }

   /**
    * Increments the size variable.
    * @return the size after incrementing
    */
   protected int incrementSize( ) {
      return ++size;
   }

   /**
    * Decrements the size variable of the BST.
    * @return the size after decrementing.
    */
   protected int decrementSize( ) {
      return --size;
   }

   /**
    * @return true if there are no nodes in the BST.
    */
   public boolean isEmpty( ) {
      return size() == 0;
   }

   /**
    * Returns the value to which the specified key is mapped,
    * or {@code null} if this map contains no mapping for the key.
    *
    * <p>More formally, if this map contains a mapping from a key
    * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
    * key.equals(k))}, then this method returns {@code v}; otherwise
    * it returns {@code null}.  (There can be at most one such mapping.)
    *
    * <p>If this map permits null values, then a return value of
    * {@code null} does not <i>necessarily</i> indicate that the map
    * contains no mapping for the key; it's also possible that the map
    * explicitly maps the key to {@code null}.  The {@link #containsKey
    * containsKey} operation may be used to distinguish these two cases.
    *
    * @param key the key whose associated value is to be returned
    * @return the value to which the specified key is mapped, or
    *      {@code null} if this map contains no mapping for the key
    * @throws ClassCastException   if the key is of an inappropriate type for
    *                              this map
    *                              (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
    * @throws NullPointerException if the specified key is null and this map
    *                              does not permit null keys
    *                              (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
    */
   @SuppressWarnings("unchecked")
   @Override
   public V get ( Object key ) {
      if ( key == null ) {
         throw new NullPointerException( "Specified key is null." );
      }
      Node currentNode = getRoot();
      while( currentNode != null ) {
         if ( ((K) key).compareTo( currentNode.getKey() ) == 0 ) {
            return currentNode.getValue();
         } else if ( ((K) key).compareTo( currentNode.getKey() ) < 0 ) {
            currentNode = currentNode.getLeftChild();
         } else {
            currentNode = currentNode.getRightChild();
         }
      }
      return null;
   }

   /**
    * Associates the specified value with the specified key in this map
    * (optional operation).  If the map previously contained a mapping for
    * the key, the old value is replaced by the specified value.  (A map
    * <tt>m</tt> is said to contain a mapping for a key <tt>k</tt> if and only
    * if {@link #containsKey(Object) m.containsKey(k)} would return
    * <tt>true</tt>.)
    *
    * @param key   key with which the specified value is to be associated
    * @param value value to be associated with the specified key
    * @return the previous value associated with <tt>key</tt>, or
    *      <tt>null</tt> if there was no mapping for <tt>key</tt>.
    *      (A <tt>null</tt> return can also indicate that the map
    *      previously associated <tt>null</tt> with <tt>key</tt>,
    *      if the implementation supports <tt>null</tt> values.)
    * @throws UnsupportedOperationException if the <tt>put</tt> operation
    *                                       is not supported by this map
    * @throws ClassCastException            if the class of the specified key or value
    *                                       prevents it from being stored in this map
    * @throws NullPointerException          if the specified key or value is null
    *                                       and this map does not permit null keys or values
    * @throws IllegalArgumentException      if some property of the specified key
    *                                       or value prevents it from being stored in this map
    */
   @Override
   public V put ( K key, V value ) {
      if ( key == null ) {
         throw new NullPointerException( "Specified key is null." );
      }
      if ( value == null ) {
         throw new NullPointerException( "Specified value is null." );
      }
      Node newNode = new Node( new KeyValuePair( key, value ) );
      Node currentNode = getRoot();
      Node prevNode = null;
      while( currentNode != null ) {
         prevNode = currentNode;
         if ( key.compareTo( currentNode.getKey() ) == 0 ) {
            V oldValue = currentNode.getValue();
            currentNode.setValue( value );
            incrementChangeCounter();
            return oldValue;
         } else if ( key.compareTo( currentNode.getKey() ) < 0 ) {
            currentNode = currentNode.getLeftChild();
         } else {
            currentNode = currentNode.getRightChild();
         }
      }
      if ( prevNode == null ) {
         setRoot( newNode );
      } else if ( key.compareTo( prevNode.getKey() ) < 0 ) {
         prevNode.setLeftChild( newNode );
      } else {
         prevNode.setRightChild( newNode );
      }
      incrementSize();
      incrementChangeCounter();
      return null;
   }

   /**
    * Copies all of the mappings from the specified map to this map
    * (optional operation).  The effect of this call is equivalent to that
    * of calling {@link #put(Object, Object) put(k, v)} on this map once
    * for each mapping from key <tt>k</tt> to value <tt>v</tt> in the
    * specified map.  The behavior of this operation is undefined if the
    * specified map is modified while the operation is in progress.
    *
    * @param m mappings to be stored in this map
    * @throws UnsupportedOperationException if the <tt>putAll</tt> operation
    *                                       is not supported by this map
    * @throws ClassCastException            if the class of a key or value in the
    *                                       specified map prevents it from being stored in this map
    * @throws NullPointerException          if the specified map is null, or if
    *                                       this map does not permit null keys or values, and the
    *                                       specified map contains null keys or values
    * @throws IllegalArgumentException      if some property of a key or value in
    *                                       the specified map prevents it from being stored in this map
    */
   @Override
   public void putAll ( Map< ? extends K, ? extends V > m ) {
      for( K key : m.keySet() ) {
         put( key, m.get( key ) );
      }
   }

   /**
    * Removes the root node of the BST.
    * @return the value of the node removed, or null if no node was removed.
    */
   public V removeRoot( ) {
      return remove( getRoot().getKey() );
   }

   /**
    * Removes all of the mappings from this map (optional operation).
    * The map will be empty after this call returns.
    *
    * @throws UnsupportedOperationException if the <tt>clear</tt> operation
    *                                       is not supported by this map
    */
   @Override
   public void clear ( ) {
      setRoot( null );
      setSize( 0 );
      incrementChangeCounter();
   }

   /**
    * Returns a {@link Set} view of the keys contained in this map.
    * The set is backed by the map, so changes to the map are
    * reflected in the set, and vice-versa.  If the map is modified
    * while an iteration over the set is in progress (except through
    * the iterator's own <tt>remove</tt> operation), the results of
    * the iteration are undefined.  The set supports element removal,
    * which removes the corresponding mapping from the map, via the
    * <tt>Iterator.remove</tt>, <tt>Set.remove</tt>,
    * <tt>removeAll</tt>, <tt>retainAll</tt>, and <tt>clear</tt>
    * operations.  It does not support the <tt>add</tt> or <tt>addAll</tt>
    * operations.
    *
    * @return a set view of the keys contained in this map
    */
   @SuppressWarnings("unchecked")
   @Override
   public Set< K > keySet ( ) {
      Set<K> keySet = new HashSet<>( );
      traverseInorder( (key, value) -> keySet.add( (K) key ) );
      return keySet;
   }

   /**
    * Returns a {@link Collection} view of the values contained in this map.
    * The collection is backed by the map, so changes to the map are
    * reflected in the collection, and vice-versa.  If the map is
    * modified while an iteration over the collection is in progress
    * (except through the iterator's own <tt>remove</tt> operation),
    * the results of the iteration are undefined.  The collection
    * supports element removal, which removes the corresponding
    * mapping from the map, via the <tt>Iterator.remove</tt>,
    * <tt>Collection.remove</tt>, <tt>removeAll</tt>,
    * <tt>retainAll</tt> and <tt>clear</tt> operations.  It does not
    * support the <tt>add</tt> or <tt>addAll</tt> operations.
    *
    * @return a collection view of the values contained in this map
    */
   @SuppressWarnings("unchecked") 
   @Override
   public Collection< V > values ( ) {
      ArrayList<V> values = new ArrayList<>( );
      traverseInorder( (key, value) -> values.add( (V) value ) );
      return values;
   }

   /**
    * Returns a {@link Set} view of the mappings contained in this map.
    * The set is backed by the map, so changes to the map are
    * reflected in the set, and vice-versa.  If the map is modified
    * while an iteration over the set is in progress (except through
    * the iterator's own <tt>remove</tt> operation, or through the
    * <tt>setValue</tt> operation on a map entry returned by the
    * iterator) the results of the iteration are undefined.  The set
    * supports element removal, which removes the corresponding
    * mapping from the map, via the <tt>Iterator.remove</tt>,
    * <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt> and
    * <tt>clear</tt> operations.  It does not support the
    * <tt>add</tt> or <tt>addAll</tt> operations.
    *
    * @return a set view of the mappings contained in this map
    */
   @Override
   public Set< Entry< K, V > > entrySet ( ) {
      Set<Entry< K, V >> entrySet = new HashSet<>( );
      buildEntrySet( getRoot(), entrySet );
      return entrySet;
   }

   // Helper method use by the entrySet method.
   private void buildEntrySet( Node node, Set<Entry< K, V >> entrySet ) {
      if ( node != null) {
         buildEntrySet( node.getLeftChild(), entrySet );
         entrySet.add( node.getEntry() );
         buildEntrySet( node.getRightChild(), entrySet );
      }
   }

   /**
    * Returns <tt>true</tt> if this map contains a mapping for the specified
    * key.  More formally, returns <tt>true</tt> if and only if
    * this map contains a mapping for a key <tt>k</tt> such that
    * <tt>(key==null ? k==null : key.equals(k))</tt>.  (There can be
    * at most one such mapping.)
    *
    * @param key key whose presence in this map is to be tested
    * @return <tt>true</tt> if this map contains a mapping for the specified
    *      key
    * @throws ClassCastException   if the key is of an inappropriate type for
    *                              this map
    *                              (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
    * @throws NullPointerException if the specified key is null and this map
    *                              does not permit null keys
    *                              (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
    */
   @Override
   public boolean containsKey ( Object key ) {
      return get( key ) != null;
   }

   /**
    * Returns <tt>true</tt> if this map maps one or more keys to the
    * specified value.  More formally, returns <tt>true</tt> if and only if
    * this map contains at least one mapping to a value <tt>v</tt> such that
    * <tt>(value==null ? v==null : value.equals(v))</tt>.  This operation
    * will probably require time linear in the map size for most
    * implementations of the <tt>Map</tt> interface.
    *
    * @param value value whose presence in this map is to be tested
    * @return <tt>true</tt> if this map maps one or more keys to the
    *      specified value
    * @throws ClassCastException   if the value is of an inappropriate type for
    *                              this map
    *                              (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
    * @throws NullPointerException if the specified value is null and this
    *                              map does not permit null values
    *                              (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
    */
   @Override
   public boolean containsValue ( Object value ) {
      return values().contains( value );
   }

   /**
    * Returns an iterator over elements of type {@code T}.
    *
    * @return an Iterator.
    */
   @Override
   public Iterator<V> iterator ( ) {
      return new TreeIterator();
   }

   /**
    * Recursive Algorithm: Preorder Binary Tree Traversal
    *    1. Visit the root.
    *    2. Preorder traverse the left subtree.
    *    3. Preorder traverse the right subtree.
    *
    * Example:
    *    Tree
    *              4
    *             / \
    *            2   5
    *           / \
    *          1   3
    *
    *    Postorder traversal: 4, 2, 1, 3, 5
    *
    * @param visitor Lambda expression to process the key and value of each node.
    *                For example: (key, value) -> System.out.println( key )
    */
   public void traversePreorder( Visitor visitor ) {
      traversePreorder( getRoot(), visitor );
   }

   // Helper method for traversePreorder method
   // Iterative Solution uses a stack
   private void traversePreorder( Node node, Visitor visitor ) {
      if ( node != null) {
         Stack<Node> stack = new Stack<>(  );
         stack.push( node );
         while( !stack.isEmpty() ) {
            Node currentNode = stack.pop();
            if ( currentNode.hasRightChild() ) {
               stack.push( currentNode.getRightChild() );
            }
            if ( currentNode.hasLeftChild() ) {
               stack.push( currentNode.getLeftChild() );
            }
            visitor.visit( currentNode.getKey(), currentNode.getValue() );
         }
      }
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
    *    Postorder traversal: 1, 2, 3, 4, 5
    *
    * @param visitor Lambda expression to process the key and value of each node.
    *                For example: (key, value) -> System.out.println( key )
    */
   public void traverseInorder( Visitor visitor ) {
      traverseInorder( getRoot(), visitor );
   }

   // Helper method used by the traverseInorder method
   // Recursive Solution
   private void traverseInorder( Node node, Visitor visitor ) {
      if ( node != null) {
         traverseInorder( node.getLeftChild(), visitor );
         visitor.visit( node.getKey( ), node.getValue( ) );
         traverseInorder( node.getRightChild(), visitor );
      }
   }
}
// END OF FILE ==============================================================