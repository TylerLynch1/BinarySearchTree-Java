import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.Map;

public class BinaryTreeView extends Pane {
  private AbstractBinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
  private double radius = 15; // Tree node radius
  private double vGap = 50; // Gap between two levels in a tree

  BinaryTreeView ( AbstractBinarySearchTree<Integer, Integer> tree ) {
    this.tree = tree;
    setStatus("Tree is empty");
  }

  public void setStatus(String msg) {
    getChildren().add(new Text(20, 20, msg));
  }

  public void displayTree() {
    this.getChildren().clear(); // Clear the pane
    if (!tree.isEmpty()) {
      Text text = new Text( );
      for ( Map.Entry<Integer, Integer> entry : tree.entrySet( ) ) {
        text.setText( entry.toString( ) );
        radius = Math.max( radius, text.getBoundsInLocal( ).getWidth( )/2.0 );
        vGap = 3.25 * radius;
      }
      // Display tree recursively
      displayTree(tree.getRoot(), getWidth() / 2, vGap,
        getWidth() / 4);
    }
  }

  /** Display a subtree rooted at position (x, y) */
  private void displayTree(AbstractBinarySearchTree<Integer, Integer>.Node root,
      double x, double y, double hGap) {
    if (root.hasLeftChild()) {
      // Draw a line to the left node
      getChildren().add(new Line(x - hGap, y + vGap, x, y));
      // Draw the left subtree recursively
      displayTree(root.getLeftChild(), x - hGap, y + vGap, hGap / 2);
    }

    if (root.hasRightChild()) {
      // Draw a line to the right node
      getChildren().add(new Line(x + hGap, y + vGap, x, y));
      // Draw the right subtree recursively
      displayTree(root.getRightChild(), x + hGap, y + vGap, hGap / 2);
    }
    
    // Display a node
    Circle circle = new Circle(x, y, radius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    Text text = new Text( root.getEntry().toString() ); //new Text(x - radius, y + 4, root.getEntry().toString())
    text.setX( x - text.getBoundsInLocal().getWidth()/2.0 );
    text.setY( y + 4 );
    getChildren().addAll(circle, text);
  }
}