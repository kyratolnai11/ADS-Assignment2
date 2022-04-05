import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E extends Comparable>
{
  private BinaryTreeNode root;
  private int size;
  private ArrayList<E> postOrderElements;
  private ArrayList<E> levelOrderElements;
  private ArrayList<E> preOrderElements;
  private ArrayList<E> inOrderElement;

  public BinaryTree()
  {
    root = null;
    size = 0;
    preOrderElements = new ArrayList<>();
    inOrderElement = new ArrayList<>();
    postOrderElements = new ArrayList<>();
    levelOrderElements = new ArrayList<>();
  }

  public BinaryTreeNode getRoot()
  {
    return root;
  }

  public void setRoot(BinaryTreeNode root)
  {
    this.root = root;
    size++;
  }

  public boolean isEmpty()
  {
    return size == 0;
  }

  public int getSize(BinaryTreeNode node)
  {
    if(node == null)
      return 0;
    else
      return 1+getSize(node.getLeftChild())+getSize(node.getRightChild());
  }

  public boolean contains(BinaryTreeNode currentNode,E element)
  {
    if(currentNode == null)
      return false;

    if (currentNode.getElement() == element)
      return true;

      return contains(currentNode.getLeftChild(),element) || contains(currentNode.getRightChild(),element);
  }

  public ArrayList<E> inOrder(BinaryTreeNode node)
  {

    if (node == null)
      return null;

    inOrder(node.getLeftChild());
    inOrderElement.add((E) node.getElement());
    inOrder(node.getRightChild());

    return inOrderElement;
  }

  public ArrayList<E> preOrder(BinaryTreeNode node)
  {


    if(node == null)
      return null;
    else{
    preOrderElements.add((E) node.getElement());
    preOrder(node.getLeftChild());
    preOrder(node.getRightChild());
    return preOrderElements;}

  }

  public ArrayList<E> postOrder(BinaryTreeNode node)
  {
    if(node == null)
      return null;

    postOrder(node.getLeftChild());
    postOrder(node.getRightChild());
    postOrderElements.add((E) node.getElement());

    return postOrderElements;
  }

  public ArrayList<E> levelOrder(BinaryTreeNode node)
  {
    int h = height(node);
    int i;
    for (i = 1; i <= h; i++)
      printCurrentLevel(node, i);

    return levelOrderElements;

  }

  void printCurrentLevel(BinaryTreeNode node, int level)
  {
    if (node == null)
      return;
    if (level == 1)
      levelOrderElements.add((E) node.getElement());
    else if (level > 1) {
      printCurrentLevel(node.getLeftChild(), level - 1);
      printCurrentLevel(node.getRightChild(), level - 1);
    }
  }


  public int height(BinaryTreeNode node)
  {
    int leftHeight=0;
    int rightHeight=0;

    if(node == null)
      return 0;
    else{
        leftHeight= height(node.getLeftChild());
        rightHeight = height(node.getRightChild());

      int max = (leftHeight > rightHeight) ? leftHeight : rightHeight;

      return max+1;
    }
  }


}
