import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
   public BinarySearchTree<String, String> buildStooges( ) {
      BinarySearchTree<String, String> tree = new BinarySearchTree<>();
      tree.put( "Larry", "larry@gmail.com" );
      tree.put( "Curly", "curly@gmail.com" );
      tree.put( "Moe", "moe@gmail.com" );
      tree.put( "Shemp", "shemp@gmail.com" );
      tree.put( "Joe", "joe@gmail.com" );
      tree.put( "Curly Joe", "curlyjoe@gmail.com" );
      return tree;
   }

   @Test
   public void testGet1( ) {
      BinarySearchTree<String, String> tree = new BinarySearchTree<>();
      tree.put( "Larry", "larry@gmail.com" );
      if ( !tree.get( "Larry").equals( "larry@gmail.com" ) ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\"), tree.get( \"Larry\" ) = %s.", tree.get( "Larry" ) ) );
      }
      if ( tree.get( "Ted Healy") != null ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\"), tree.get( \"Ted Healy\" ) = %s.", tree.get( "Ted Healy" ) ) );
      }
   }

   @Test
   public void testGet2( ) {
      BinarySearchTree<String, String> tree = buildStooges();
      if ( !tree.get( "Larry").equals( "larry@gmail.com" ) ) {
         fail( String.format( "After adding 6 entries, tree.get( \"Larry\" ) = %s.", tree.get( "Larry" ) ) );
      }
      if ( !tree.get( "Curly Joe").equals( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After adding 6 entries, tree.get( \"Curly Joe\" ) = %s.", tree.get( "Curly Joe" ) ) );
      }
      if ( !tree.get( "Curly").equals( "curly@gmail.com" ) ) {
         fail( String.format( "After adding 6 entries, tree.get( \"Curly\" ) = %s.", tree.get( "Curly" ) ) );
      }
      if ( !tree.get( "Moe").equals( "moe@gmail.com" ) ) {
         fail( String.format( "After adding 6 entries, tree.get( \"Moe\" ) = %s.", tree.get( "Moe" ) ) );
      }
      if ( !tree.get( "Shemp").equals( "shemp@gmail.com" ) ) {
         fail( String.format( "After adding 6 entries, tree.get( \"Shemp\" ) = %s.", tree.get( "Shemp" ) ) );
      }
      if ( !tree.get( "Joe").equals( "joe@gmail.com" ) ) {
         fail( String.format( "After adding 6 entries, tree.get( \"Joe\" ) = %s.", tree.get( "Joe" ) ) );
      }
      if ( tree.get( "Ted Healy") != null ) {
         fail( String.format( "After adding 6 entries, tree.get( \"Ted Healy\" ) = %s.", tree.get( "Ted Healy" ) ) );
      }
   }

   @Test
   public void testPut1 ( ) {
      BinarySearchTree<String, String> tree = new BinarySearchTree<>();
      tree.put( "Larry", "larry@gmail.com" );
      if ( tree.isEmpty() ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\"), tree.isEmpty() = true." ) );
      }
      if ( tree.size() != 1 ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\"), tree.size() = %d.", tree.size() ) );
      }
      if( !tree.containsKey( "Larry" ) ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\"), tree.containsKey( \"Larry\" ) = false." ) );
      }
      if( !tree.containsValue( "larry@gmail.com" ) ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\"), tree.containsValue( \"larry@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Larry" ) ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\"), tree.keySet().contains( \"Larry\" ) = false." ) );
      }
      if( !tree.values().contains( "larry@gmail.com" ) ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\"), tree.values().contains( \"larry@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Larry") == null ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\"), tree.get( \"Larry\" ) = null." ) );
      }
      if ( !tree.get( "Larry").equals( "larry@gmail.com" ) ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\"), tree.get( \"Larry\" ) = %s.", tree.get( "Larry" ) ) );
      }
   }

   @Test
   public void testPut2 ( ) {
      BinarySearchTree<String, String> tree = buildStooges( );
      if ( tree.isEmpty() ) {
         fail( String.format( "After adding 6 entries, tree.isEmpty() = true." ) );
      }
      if ( tree.size() != 6 ) {
         fail( String.format( "After adding 6 entries, tree.size() = %d.", tree.size() ) );
      }
      // Larry
      if( !tree.containsKey( "Larry" ) ) {
         fail( String.format( "After building the stooges tree, tree.containsKey( \"Larry\" ) = false." ) );
      }
      if( !tree.containsValue( "larry@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.containsValue( \"larry@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Larry" ) ) {
         fail( String.format( "After building the stooges tree, tree.keySet().contains( \"Larry\" ) = false." ) );
      }
      if( !tree.values().contains( "larry@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.values().contains( \"larry@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Larry") == null ) {
         fail( String.format( "After building the stooges tree, tree.get( \"Larry\" ) = null." ) );
      }
      if ( !tree.get( "Larry").equals( "larry@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.get( \"Larry\" ) = %s.", tree.get( "Larry" ) ) );
      }
      // Curly
      if( !tree.containsKey( "Curly" ) ) {
         fail( String.format( "After building the stooges tree, tree.containsKey( \"Curly\" ) = false." ) );
      }
      if( !tree.containsValue( "curly@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.containsValue( \"curly@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Curly" ) ) {
         fail( String.format( "After building the stooges tree, tree.keySet().contains( \"Curly\" ) = false." ) );
      }
      if( !tree.values().contains( "curly@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.values().contains( \"curly@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Curly") == null ) {
         fail( String.format( "After building the stooges tree, tree.get( \"Curly\" ) = null." ) );
      }
      if ( !tree.get( "Curly").equals( "curly@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.get( \"Curly\" ) = %s.", tree.get( "Curly" ) ) );
      }
      // Moe
      if( !tree.containsKey( "Moe" ) ) {
         fail( String.format( "After building the stooges tree, tree.containsKey( \"Moe\" ) = false." ) );
      }
      if( !tree.containsValue( "moe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.containsValue( \"moe@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Moe" ) ) {
         fail( String.format( "After building the stooges tree, tree.keySet().contains( \"Moe\" ) = false." ) );
      }
      if( !tree.values().contains( "moe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.values().contains( \"moe@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Moe") == null ) {
         fail( String.format( "After building the stooges tree, tree.get( \"Moe\" ) = null." ) );
      }
      if ( !tree.get( "Moe").equals( "moe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.get( \"Moe\" ) = %s.", tree.get( "Moe" ) ) );
      }
      // Shemp
      if( !tree.containsKey( "Shemp" ) ) {
         fail( String.format( "After building the stooges tree, tree.containsKey( \"Shemp\" ) = false." ) );
      }
      if( !tree.containsValue( "shemp@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.containsValue( \"shemp@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Shemp" ) ) {
         fail( String.format( "After building the stooges tree, tree.keySet().contains( \"Shemp\" ) = false." ) );
      }
      if( !tree.values().contains( "shemp@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.values().contains( \"shemp@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Shemp") == null ) {
         fail( String.format( "After building the stooges tree, tree.get( \"Shemp\" ) = null." ) );
      }
      if ( !tree.get( "Shemp").equals( "shemp@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.get( \"Shemp\" ) = %s.", tree.get( "Shemp" ) ) );
      }
      // Joe
      if( !tree.containsKey( "Joe" ) ) {
         fail( String.format( "After building the stooges tree, tree.containsKey( \"Joe\" ) = false." ) );
      }
      if( !tree.containsValue( "joe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.containsValue( \"joe@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Joe" ) ) {
         fail( String.format( "After building the stooges tree, tree.keySet().contains( \"Joe\" ) = false." ) );
      }
      if( !tree.values().contains( "joe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.values().contains( \"joe@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Joe") == null ) {
         fail( String.format( "After building the stooges tree, tree.get( \"Joe\" ) = null." ) );
      }
      if ( !tree.get( "Joe").equals( "joe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.get( \"Joe\" ) = %s.", tree.get( "Joe" ) ) );
      }
      // Curly Joe
      if( !tree.containsKey( "Curly Joe" ) ) {
         fail( String.format( "After building the stooges tree, tree.containsKey( \"Curly Joe\" ) = false." ) );
      }
      if( !tree.containsValue( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.containsValue( \"curlyjoe@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Curly Joe" ) ) {
         fail( String.format( "After building the stooges tree, tree.keySet().contains( \"Curly Joe\" ) = false." ) );
      }
      if( !tree.values().contains( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.values().contains( \"curlyjoe@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Curly Joe") == null ) {
         fail( String.format( "After building the stooges tree, tree.get( \"Curly Joe\" ) = null." ) );
      }
      if ( !tree.get( "Curly Joe").equals( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree, tree.get( \"Curly Joe\" ) = %s.", tree.get( "Curly Joe" ) ) );
      }
   }

   @Test
   public void preorderTraversalTest( ) {
      BinarySearchTree<String, String> tree = buildStooges();
      ArrayList<String> list = new ArrayList<>(  );
      tree.traversePreorder( (key, value) -> list.add( key.toString() ) );
      // Larry
      if ( !list.get( 0 ).equals( "Larry" ) ) {
         fail( String.format( "After building the stooges tree, the first entry of the preorder traversal is not \"Larry\", instead it is %s.", list.get( 0) ) );
      }
      // Curly
      if ( !list.get( 1 ).equals( "Curly" ) ) {
         fail( String.format( "After building the stooges tree, the second entry of the preorder traversal is not \"Curly\", instead it is %s.", list.get( 1) ) );
      }
      // Joe
      if ( !list.get( 2 ).equals( "Joe" ) ) {
         fail( String.format( "After building the stooges tree, the third entry of the preorder traversal is not \"Joe\", instead it is %s.", list.get( 2) ) );
      }
      // Curly Joe
      if ( !list.get( 3 ).equals( "Curly Joe" ) ) {
         fail( String.format( "After building the stooges tree, the fourth entry of the preorder traversal is not \"Curly Joe\", instead it is %s.", list.get( 3) ) );
      }
      // Moe
      if ( !list.get( 4 ).equals( "Moe" ) ) {
         fail( String.format( "After building the stooges tree, the fifth entry of the preorder traversal is not \"Moe\", instead it is %s.", list.get( 4) ) );
      }
      // Shemp
      if ( !list.get( 5 ).equals( "Shemp" ) ) {
         fail( String.format( "After building the stooges tree, the sixth entry of the preorder traversal is not \"Shemp\", instead it is %s.", list.get( 5) ) );
      }
   }

   @Test
   public void inorderTraversalTest( ) {
      BinarySearchTree<String, String> tree = buildStooges();
      ArrayList<String> list = new ArrayList<>(  );
      tree.traverseInorder( (key, value) -> list.add( key.toString() ) );
      // Curly
      if ( !list.get( 0 ).equals( "Curly" ) ) {
         fail( String.format( "After building the stooges tree, the first entry of the inorder traversal is not \"Curly\", instead it is %s.", list.get( 0 ) ) );
      }
      // Curly Joe
      if ( !list.get( 1 ).equals( "Curly Joe" ) ) {
         fail( String.format( "After building the stooges tree, the second entry of the inorder traversal is not \"Curly Joe\", instead it is %s.", list.get( 1 ) ) );
      }
      // Joe
      if ( !list.get( 2 ).equals( "Joe" ) ) {
         fail( String.format( "After building the stooges tree, the third entry of the inorder traversal is not \"Joe\", instead it is %s.", list.get( 2 ) ) );
      }
      // Larry
      if ( !list.get( 3 ).equals( "Larry" ) ) {
         fail( String.format( "After building the stooges tree, the fourth entry of the inorder traversal is not \"Larry\", instead it is %s.", list.get( 3 ) ) );
      }
      // Moe
      if ( !list.get( 4 ).equals( "Moe" ) ) {
         fail( String.format( "After building the stooges tree, the fifth entry of the inorder traversal is not \"Moe\", instead it is %s.", list.get( 4 ) ) );
      }
      // Shemp
      if ( !list.get( 5 ).equals( "Shemp" ) ) {
         fail( String.format( "After building the stooges tree, the sixth entry of the inorder traversal is not \"Shemp\", instead it is %s.", list.get( 5 ) ) );
      }
   }

   @Test
   public void postorderTraversalTest( ) {
      BinarySearchTree<String, String> tree = buildStooges();
      ArrayList<String> list = new ArrayList<>(  );
      tree.traversePostorder( (key, value) -> list.add( key.toString() ) );
      // Curly Joe
      if ( !list.get( 0 ).equals( "Curly Joe" ) ) {
         fail( String.format( "After building the stooges tree, the first entry of the postorder traversal is not \"Curly Joe\", instead it is %s.", list.get( 0 ) ) );
      }
      // Joe
      if ( !list.get( 1 ).equals( "Joe" ) ) {
         fail( String.format( "After building the stooges tree, the second entry of the postorder traversal is not \"Joe\", instead it is %s.", list.get( 1 ) ) );
      }
      // Curly
      if ( !list.get( 2 ).equals( "Curly" ) ) {
         fail( String.format( "After building the stooges tree, the third entry of the postorder traversal is not \"Curly\", instead it is %s.", list.get( 2 ) ) );
      }
      // Shemp
      if ( !list.get( 3 ).equals( "Shemp" ) ) {
         fail( String.format( "After building the stooges tree, the fourth entry of the postorder traversal is not \"Shemp\", instead it is %s.", list.get( 3 ) ) );
      }
      // Moe
      if ( !list.get( 4 ).equals( "Moe" ) ) {
         fail( String.format( "After building the stooges tree, the fifth entry of the postorder traversal is not \"Moe\", instead it is %s.", list.get( 4 ) ) );
      }
      // Larry
      if ( !list.get( 5 ).equals( "Larry" ) ) {
         fail( String.format( "After building the stooges tree, the sixth entry of the postorder traversal is not \"Larry\", instead it is %s.", list.get( 5 ) ) );
      }
   }

   @Test
   public void levelorderTraversalTest( ) {
      BinarySearchTree<String, String> tree = buildStooges();
      ArrayList<String> list = new ArrayList<>(  );
      tree.traverseLevelorder( (key, value) -> list.add( key.toString() ) );
      // Larry
      if ( !list.get( 0 ).equals( "Larry" ) ) {
         fail( String.format( "After building the stooges tree, the first entry of the levelorder traversal is not \"Larry\", instead it is %s.", list.get( 0 ) ) );
      }
      // Curly
      if ( !list.get( 1 ).equals( "Curly" ) ) {
         fail( String.format( "After building the stooges tree, the second entry of the levelorder traversal is not \"Curly\", instead it is %s.", list.get( 1 ) ) );
      }
      // Moe
      if ( !list.get( 2 ).equals( "Moe" ) ) {
         fail( String.format( "After building the stooges tree, the third entry of the levelorder traversal is not \"Moe\", instead it is %s.", list.get( 2 ) ) );
      }
      // Joe
      if ( !list.get( 3 ).equals( "Joe" ) ) {
         fail( String.format( "After building the stooges tree, the fourth entry of the levelorder traversal is not \"Joe\", instead it is %s.", list.get( 3 ) ) );
      }
      // Shemp
      if ( !list.get( 4 ).equals( "Shemp" ) ) {
         fail( String.format( "After building the stooges tree, the fifth entry of the levelorder traversal is not \"Shemp\", instead it is %s.", list.get( 4 ) ) );
      }
      // Curly Joe
      if ( !list.get( 5 ).equals( "Curly Joe" ) ) {
         fail( String.format( "After building the stooges tree, the sixth entry of the levelorder traversal is not \"Curly Joe\", instead it is %s.", list.get( 5 ) ) );
      }
   }

   @Test
   public void testRemove1 ( ) {
      BinarySearchTree<String, String> tree = new BinarySearchTree<>();
      tree.put( "Larry", "larry@gmail.com" );
      String value = tree.remove( "Larry" );
      if ( !value.equals( "larry@gmail.com" ) ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\"), tree.remove(\"Larry\") = %s.", value ) );
      }
      if ( !tree.isEmpty() ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\") and tree.remove(\"Larry\"), tree.isEmpty() = false." ) );
      }
      if ( tree.size() != 0 ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\") and tree.remove(\"Larry\"), tree.size() = %d.", tree.size() ) );
      }
      if( tree.containsKey( "Larry" ) ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\") and tree.remove(\"Larry\"), tree.containsKey( \"Larry\" ) = true." ) );
      }
      if( tree.containsValue( "larry@gmail.com" ) ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\") and tree.remove(\"Larry\"), tree.containsValue( \"larry@gmail.com\" ) = true." ) );
      }
      if( tree.keySet().contains( "Larry" ) ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\") and tree.remove(\"Larry\"), tree.keySet().contains( \"Larry\" ) = true." ) );
      }
      if( tree.values().contains( "larry@gmail.com" ) ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\") and tree.remove(\"Larry\"), tree.values().contains( \"larry@gmail.com\" ) = true." ) );
      }
      if ( tree.get( "Larry") != null ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\") and tree.remove(\"Larry\"), tree.get( \"Larry\" ) = %s.", tree.get("Larry") ) );
      }
      if ( tree.get( "Larry") != null && tree.get( "Larry").equals( "larry@gmail.com" ) ) {
         fail( String.format( "After tree.put(\"Larry\",\"larry@gmail.com\") and tree.remove(\"Larry\"), tree.get( \"Larry\" ) = %s.", tree.get( "Larry" ) ) );
      }
   }

   @Test
   public void testRemove2 ( ) {
      BinarySearchTree<String, String> tree = buildStooges( );
      String value = tree.remove("Larry");
      if ( !value.equals( "larry@gmail.com" ) ) {
         fail( String.format( "After adding 6 entries, tree.remove(\"Larry\") = %s.", value ) );
      }
      if ( tree.isEmpty() ) {
         fail( String.format( "After adding 6 entries and tree.remove(\"Larry\"), tree.isEmpty() = true." ) );
      }
      if ( tree.size() != 5 ) {
         fail( String.format( "After adding 6 entries and tree.remove(\"Larry\"), tree.size() = %d.", tree.size() ) );
      }
      // Larry
      if( tree.containsKey( "Larry" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.containsKey( \"Larry\" ) = true." ) );
      }
      if( tree.containsValue( "larry@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.containsValue( \"larry@gmail.com\" ) = true." ) );
      }
      if( tree.keySet().contains( "Larry" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.keySet().contains( \"Larry\" ) = true." ) );
      }
      if( tree.values().contains( "larry@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.values().contains( \"larry@gmail.com\" ) = true." ) );
      }
      if ( tree.get( "Larry") != null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.get( \"Larry\" ) != null." ) );
      }
      if ( tree.get( "Larry") != null && tree.get( "Larry").equals( "larry@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.get( \"Larry\" ) = %s.", tree.get( "Larry" ) ) );
      }
      // Curly
      if( !tree.containsKey( "Curly" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.containsKey( \"Curly\" ) = false." ) );
      }
      if( !tree.containsValue( "curly@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.containsValue( \"curly@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Curly" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.keySet().contains( \"Curly\" ) = false." ) );
      }
      if( !tree.values().contains( "curly@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.values().contains( \"curly@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Curly") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.get( \"Curly\" ) = null." ) );
      }
      if ( !tree.get( "Curly").equals( "curly@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.get( \"Curly\" ) = %s.", tree.get( "Curly" ) ) );
      }
      // Moe
      if( !tree.containsKey( "Moe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.containsKey( \"Moe\" ) = false." ) );
      }
      if( !tree.containsValue( "moe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.containsValue( \"moe@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Moe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.keySet().contains( \"Moe\" ) = false." ) );
      }
      if( !tree.values().contains( "moe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.values().contains( \"moe@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Moe") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.get( \"Moe\" ) = null." ) );
      }
      if ( !tree.get( "Moe").equals( "moe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.get( \"Moe\" ) = %s.", tree.get( "Moe" ) ) );
      }
      // Shemp
      if( !tree.containsKey( "Shemp" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.containsKey( \"Shemp\" ) = false." ) );
      }
      if( !tree.containsValue( "shemp@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.containsValue( \"shemp@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Shemp" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.keySet().contains( \"Shemp\" ) = false." ) );
      }
      if( !tree.values().contains( "shemp@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.values().contains( \"shemp@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Shemp") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.get( \"Shemp\" ) = null." ) );
      }
      if ( !tree.get( "Shemp").equals( "shemp@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.get( \"Shemp\" ) = %s.", tree.get( "Shemp" ) ) );
      }
      // Joe
      if( !tree.containsKey( "Joe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.containsKey( \"Joe\" ) = false." ) );
      }
      if( !tree.containsValue( "joe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.containsValue( \"joe@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Joe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.keySet().contains( \"Joe\" ) = false." ) );
      }
      if( !tree.values().contains( "joe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.values().contains( \"joe@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Joe") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.get( \"Joe\" ) = null." ) );
      }
      if ( !tree.get( "Joe").equals( "joe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.get( \"Joe\" ) = %s.", tree.get( "Joe" ) ) );
      }
      // Curly Joe
      if( !tree.containsKey( "Curly Joe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.containsKey( \"Curly Joe\" ) = false." ) );
      }
      if( !tree.containsValue( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.containsValue( \"curlyjoe@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Curly Joe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.keySet().contains( \"Curly Joe\" ) = false." ) );
      }
      if( !tree.values().contains( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.values().contains( \"curlyjoe@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Curly Joe") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.get( \"Curly Joe\" ) = null." ) );
      }
      if ( !tree.get( "Curly Joe").equals( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Larry\"), tree.get( \"Curly Joe\" ) = %s.", tree.get( "Curly Joe" ) ) );
      }
   }

   @Test
   public void testRemove3 ( ) {
      BinarySearchTree<String, String> tree = buildStooges( );
      String value = tree.remove("Curly");
      if ( !value.equals( "curly@gmail.com" ) ) {
         fail( String.format( "After adding 6 entries, tree.remove(\"Curly\") = %s.", value ) );
      }
      if ( tree.isEmpty() ) {
         fail( String.format( "After adding 6 entries and tree.remove(\"Curly\"), tree.isEmpty() = true." ) );
      }
      if ( tree.size() != 5 ) {
         fail( String.format( "After adding 6 entries and tree.remove(\"Curly\"), tree.size() = %d.", tree.size() ) );
      }
      // Larry
      if( !tree.containsKey( "Larry" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.containsKey( \"Larry\" ) = false." ) );
      }
      if( !tree.containsValue( "larry@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.containsValue( \"larry@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Larry" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.keySet().contains( \"Larry\" ) = false." ) );
      }
      if( !tree.values().contains( "larry@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.values().contains( \"larry@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Larry") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.get( \"Larry\" ) = null." ) );
      }
      if ( !tree.get( "Larry").equals( "larry@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.get( \"Larry\" ) = %s.", tree.get( "Larry" ) ) );
      }
      // Curly
      if( tree.containsKey( "Curly" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.containsKey( \"Curly\" ) = true." ) );
      }
      if( tree.containsValue( "curly@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.containsValue( \"curly@gmail.com\" ) = true." ) );
      }
      if( tree.keySet().contains( "Curly" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.keySet().contains( \"Curly\" ) = true." ) );
      }
      if( tree.values().contains( "curly@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.values().contains( \"curly@gmail.com\" ) = true." ) );
      }
      if ( tree.get( "Curly") != null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.get( \"Curly\" ) != null." ) );
      }
      if ( tree.get( "Curly") != null && tree.get( "Curly").equals( "curly@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.get( \"Curly\" ) = %s.", tree.get( "Curly" ) ) );
      }
      // Moe
      if( !tree.containsKey( "Moe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.containsKey( \"Moe\" ) = false." ) );
      }
      if( !tree.containsValue( "moe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.containsValue( \"moe@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Moe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.keySet().contains( \"Moe\" ) = false." ) );
      }
      if( !tree.values().contains( "moe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.values().contains( \"moe@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Moe") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.get( \"Moe\" ) = null." ) );
      }
      if ( !tree.get( "Moe").equals( "moe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.get( \"Moe\" ) = %s.", tree.get( "Moe" ) ) );
      }
      // Shemp
      if( !tree.containsKey( "Shemp" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.containsKey( \"Shemp\" ) = false." ) );
      }
      if( !tree.containsValue( "shemp@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.containsValue( \"shemp@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Shemp" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.keySet().contains( \"Shemp\" ) = false." ) );
      }
      if( !tree.values().contains( "shemp@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.values().contains( \"shemp@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Shemp") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.get( \"Shemp\" ) = null." ) );
      }
      if ( !tree.get( "Shemp").equals( "shemp@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.get( \"Shemp\" ) = %s.", tree.get( "Shemp" ) ) );
      }
      // Joe
      if( !tree.containsKey( "Joe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.containsKey( \"Joe\" ) = false." ) );
      }
      if( !tree.containsValue( "joe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.containsValue( \"joe@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Joe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.keySet().contains( \"Joe\" ) = false." ) );
      }
      if( !tree.values().contains( "joe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.values().contains( \"joe@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Joe") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.get( \"Joe\" ) = null." ) );
      }
      if ( !tree.get( "Joe").equals( "joe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.get( \"Joe\" ) = %s.", tree.get( "Joe" ) ) );
      }
      // Curly Joe
      if( !tree.containsKey( "Curly Joe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.containsKey( \"Curly Joe\" ) = false." ) );
      }
      if( !tree.containsValue( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.containsValue( \"curlyjoe@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Curly Joe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.keySet().contains( \"Curly Joe\" ) = false." ) );
      }
      if( !tree.values().contains( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.values().contains( \"curlyjoe@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Curly Joe") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.get( \"Curly Joe\" ) = null." ) );
      }
      if ( !tree.get( "Curly Joe").equals( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Curly\"), tree.get( \"Curly Joe\" ) = %s.", tree.get( "Curly Joe" ) ) );
      }
   }

   @Test
   public void testRemove4 ( ) {
      BinarySearchTree<String, String> tree = buildStooges( );
      String value = tree.remove("Shemp");
      if ( !value.equals( "shemp@gmail.com" ) ) {
         fail( String.format( "After adding 6 entries, tree.remove(\"Shemp\") = %s.", value ) );
      }
      if ( tree.isEmpty() ) {
         fail( String.format( "After adding 6 entries and tree.remove(\"Shemp\"), tree.isEmpty() = true." ) );
      }
      if ( tree.size() != 5 ) {
         fail( String.format( "After adding 6 entries and tree.remove(\"Shemp\"), tree.size() = %d.", tree.size() ) );
      }
      // Larry
      if( !tree.containsKey( "Larry" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.containsKey( \"Larry\" ) = false." ) );
      }
      if( !tree.containsValue( "larry@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.containsValue( \"larry@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Larry" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.keySet().contains( \"Larry\" ) = false." ) );
      }
      if( !tree.values().contains( "larry@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.values().contains( \"larry@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Larry") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.get( \"Larry\" ) = null." ) );
      }
      if ( !tree.get( "Larry").equals( "larry@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.get( \"Larry\" ) = %s.", tree.get( "Larry" ) ) );
      }
      // Curly
      if( !tree.containsKey( "Curly" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.containsKey( \"Curly\" ) = false." ) );
      }
      if( !tree.containsValue( "curly@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.containsValue( \"curly@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Curly" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.keySet().contains( \"Curly\" ) = false." ) );
      }
      if( !tree.values().contains( "curly@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.values().contains( \"curly@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Curly") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.get( \"Curly\" ) = null." ) );
      }
      if ( !tree.get( "Curly").equals( "curly@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.get( \"Curly\" ) = %s.", tree.get( "Curly" ) ) );
      }
      // Moe
      if( !tree.containsKey( "Moe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.containsKey( \"Moe\" ) = false." ) );
      }
      if( !tree.containsValue( "moe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.containsValue( \"moe@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Moe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.keySet().contains( \"Moe\" ) = false." ) );
      }
      if( !tree.values().contains( "moe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.values().contains( \"moe@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Moe") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.get( \"Moe\" ) = null." ) );
      }
      if ( !tree.get( "Moe").equals( "moe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.get( \"Moe\" ) = %s.", tree.get( "Moe" ) ) );
      }
      // Shemp
      if( tree.containsKey( "Shemp" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.containsKey( \"Shemp\" ) = true." ) );
      }
      if( tree.containsValue( "shemp@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.containsValue( \"shemp@gmail.com\" ) = true." ) );
      }
      if( tree.keySet().contains( "Shemp" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.keySet().contains( \"Shemp\" ) = true." ) );
      }
      if( tree.values().contains( "shemp@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.values().contains( \"shemp@gmail.com\" ) = true." ) );
      }
      if ( tree.get( "Shemp") != null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.get( \"Shemp\" ) != null." ) );
      }
      if ( tree.get( "Shemp") != null && tree.get( "Shemp").equals( "shemp@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.get( \"Shemp\" ) = %s.", tree.get( "Shemp" ) ) );
      }
      // Joe
      if( !tree.containsKey( "Joe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.containsKey( \"Joe\" ) = false." ) );
      }
      if( !tree.containsValue( "joe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.containsValue( \"joe@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Joe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.keySet().contains( \"Joe\" ) = false." ) );
      }
      if( !tree.values().contains( "joe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.values().contains( \"joe@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Joe") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.get( \"Joe\" ) = null." ) );
      }
      if ( !tree.get( "Joe").equals( "joe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.get( \"Joe\" ) = %s.", tree.get( "Joe" ) ) );
      }
      // Curly Joe
      if( !tree.containsKey( "Curly Joe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.containsKey( \"Curly Joe\" ) = false." ) );
      }
      if( !tree.containsValue( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.containsValue( \"curlyjoe@gmail.com\" ) = false." ) );
      }
      if( !tree.keySet().contains( "Curly Joe" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.keySet().contains( \"Curly Joe\" ) = false." ) );
      }
      if( !tree.values().contains( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.values().contains( \"curlyjoe@gmail.com\" ) = false." ) );
      }
      if ( tree.get( "Curly Joe") == null ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.get( \"Curly Joe\" ) = null." ) );
      }
      if ( !tree.get( "Curly Joe").equals( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After building the stooges tree and tree.remove(\"Shemp\"), tree.get( \"Curly Joe\" ) = %s.", tree.get( "Curly Joe" ) ) );
      }
   }


   @Test
   public void testRemove5 ( ) {
      BinarySearchTree<String, String> tree = buildStooges( );
      int size = tree.size();
      for( int i = 0; i < size; i++ ) {
         tree.removeRoot();
      }
      if ( !tree.isEmpty() ) {
         fail( String.format( "After adding and removing 6 entries, tree.isEmpty() = false." ) );
      }
      if ( tree.size() != 0 ) {
         fail( String.format( "After adding and removing 6 entries, tree.size() = %d.", tree.size() ) );
      }
      // Larry
      if( tree.containsKey( "Larry" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.containsKey( \"Larry\" ) = true." ) );
      }
      if( tree.containsValue( "larry@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.containsValue( \"larry@gmail.com\" ) = true." ) );
      }
      if( tree.keySet().contains( "Larry" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.keySet().contains( \"Larry\" ) = true." ) );
      }
      if( tree.values().contains( "larry@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.values().contains( \"larry@gmail.com\" ) = true." ) );
      }
      if ( tree.get( "Larry") != null ) {
         fail( String.format( "After adding and removing 6 entries, tree.get( \"Larry\" ) != null." ) );
      }
      if ( tree.get( "Larry") != null && tree.get( "Larry").equals( "larry@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.get( \"Larry\" ) = %s.", tree.get( "Larry" ) ) );
      }
      // Curly
      if( tree.containsKey( "Curly" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.containsKey( \"Curly\" ) = true." ) );
      }
      if( tree.containsValue( "curly@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.containsValue( \"curly@gmail.com\" ) = true." ) );
      }
      if( tree.keySet().contains( "Curly" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.keySet().contains( \"Curly\" ) = true." ) );
      }
      if( tree.values().contains( "curly@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.values().contains( \"curly@gmail.com\" ) = true." ) );
      }
      if ( tree.get( "Curly") != null ) {
         fail( String.format( "After adding and removing 6 entries, tree.get( \"Curly\" ) != null." ) );
      }
      if ( tree.get( "Curly" ) != null && tree.get( "Curly").equals( "curly@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.get( \"Curly\" ) = %s.", tree.get( "Curly" ) ) );
      }
      // Moe
      if( tree.containsKey( "Moe" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.containsKey( \"Moe\" ) = true." ) );
      }
      if( tree.containsValue( "moe@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.containsValue( \"moe@gmail.com\" ) = true." ) );
      }
      if( tree.keySet().contains( "Moe" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.keySet().contains( \"Moe\" ) = true." ) );
      }
      if( tree.values().contains( "moe@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.values().contains( \"moe@gmail.com\" ) = true." ) );
      }
      if ( tree.get( "Moe") != null ) {
         fail( String.format( "After adding and removing 6 entries, tree.get( \"Moe\" ) != null." ) );
      }
      if ( tree.get( "Moe") != null && tree.get( "Moe").equals( "moe@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.get( \"Moe\" ) = %s.", tree.get( "Moe" ) ) );
      }
      // Shemp
      if( tree.containsKey( "Shemp" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.containsKey( \"Shemp\" ) = true." ) );
      }
      if( tree.containsValue( "shemp@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.containsValue( \"shemp@gmail.com\" ) = true." ) );
      }
      if( tree.keySet().contains( "Shemp" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.keySet().contains( \"Shemp\" ) = true." ) );
      }
      if( tree.values().contains( "shemp@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.values().contains( \"shemp@gmail.com\" ) = true." ) );
      }
      if ( tree.get( "Shemp") != null ) {
         fail( String.format( "After adding and removing 6 entries, tree.get( \"Shemp\" ) != null." ) );
      }
      if ( tree.get( "Shemp") != null && tree.get( "Shemp").equals( "shemp@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.get( \"Shemp\" ) = %s.", tree.get( "Shemp" ) ) );
      }
      // Joe
      if( tree.containsKey( "Joe" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.containsKey( \"Joe\" ) = true." ) );
      }
      if( tree.containsValue( "joe@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.containsValue( \"joe@gmail.com\" ) = true." ) );
      }
      if( tree.keySet().contains( "Joe" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.keySet().contains( \"Joe\" ) = true." ) );
      }
      if( tree.values().contains( "joe@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.values().contains( \"joe@gmail.com\" ) = true." ) );
      }
      if ( tree.get( "Joe") != null ) {
         fail( String.format( "After adding and removing 6 entries, tree.get( \"Joe\" ) != null." ) );
      }
      if ( tree.get("Joe") != null && tree.get( "Joe").equals( "joe@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.get( \"Joe\" ) = %s.", tree.get( "Joe" ) ) );
      }
      // Curly Joe
      if( tree.containsKey( "Curly Joe" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.containsKey( \"Curly Joe\" ) = true." ) );
      }
      if( tree.containsValue( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.containsValue( \"curlyjoe@gmail.com\" ) = true." ) );
      }
      if( tree.keySet().contains( "Curly Joe" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.keySet().contains( \"Curly Joe\" ) = true." ) );
      }
      if( tree.values().contains( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.values().contains( \"curlyjoe@gmail.com\" ) = true." ) );
      }
      if ( tree.get( "Curly Joe") != null ) {
         fail( String.format( "After adding and removing 6 entries, tree.get( \"Curly Joe\" ) != null." ) );
      }
      if ( tree.get( "Curly Joe" ) != null && tree.get( "Curly Joe").equals( "curlyjoe@gmail.com" ) ) {
         fail( String.format( "After adding and removing 6 entries, tree.get( \"Curly Joe\" ) = %s.", tree.get( "Curly Joe" ) ) );
      }
   }
}