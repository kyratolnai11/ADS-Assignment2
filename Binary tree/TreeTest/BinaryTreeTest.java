import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest
{
  private BinarySearchTreeNode rootNode;
  private BinarySearchTree tree;

  @BeforeEach void setUP()
  {
     rootNode = new BinarySearchTreeNode(40);
     tree = new BinarySearchTree(rootNode);
    BinarySearchTreeNode node20 = new BinarySearchTreeNode(20);
    BinarySearchTreeNode node10 = new BinarySearchTreeNode(10);
    BinarySearchTreeNode node30 = new BinarySearchTreeNode(30);
    BinarySearchTreeNode node60 = new BinarySearchTreeNode(60);
    BinarySearchTreeNode node50 = new BinarySearchTreeNode(50);
    BinarySearchTreeNode node70 = new BinarySearchTreeNode(70);

    rootNode.addLeftChild(node20);
    rootNode.addRightChild(node60);

    node20.addLeftChild(node10);
    node20.addRightChild(node30);

    node60.addLeftChild(node50);
    node60.addRightChild(node70);


    tree.setRoot(rootNode);
  }


  @Test void containsRandom()
  {
    Boolean contain = tree.contains(20);
    assertEquals(contain, true);
  }

  @Test void containsRoot()
  {
    Boolean contain = tree.contains(40);
    assertEquals(contain, true);
  }

  @Test void containsLeaf()
  {
    Boolean contain = tree.contains(50);
    assertEquals(contain, true);
  }

  @Test void doestContain()
  {
    Boolean contain = tree.contains(100);
    assertEquals(contain, false);
  }

  @Test void inOrder()
  {
    ArrayList<Integer> list = tree.inOrder(rootNode);
    Integer[] expected = new Integer[]{10,20,30,40,50,60,70};
    Integer[] array = list.toArray(new Integer[0]);
    assertArrayEquals(expected,array);
  }

  @Test void preOrder()
  {
    ArrayList<Integer> list = tree.preOrder(rootNode);
    Integer[] expected = new Integer[]{40,20,10,30,60,50,70};
    Integer[] array = list.toArray(new Integer[0]);
    assertArrayEquals(expected,array);
  }

  @Test void postOrder()
  {
    ArrayList<Integer> list = tree.postOrder(rootNode);
    Integer[] expected = new Integer[]{10,30,20,50,70,60,40};
    Integer[] array = list.toArray(new Integer[0]);
    assertArrayEquals(expected,array);
  }

  @Test void levelOrder()
  {
    ArrayList<Integer> list = tree.levelOrder(rootNode);
    Integer[] expected = new Integer[]{40,20,60,10,30,50,70};
    Integer[] array = list.toArray(new Integer[0]);
    assertArrayEquals(expected,array);
  }




}