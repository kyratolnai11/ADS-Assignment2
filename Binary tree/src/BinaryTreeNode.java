public class BinaryTreeNode<E extends Comparable>
{
  private E element;
  private BinaryTreeNode left;
  private BinaryTreeNode right;

  public BinaryTreeNode(E element)
  {
    this.element = element;
    left = null;
    right = null;
  }

  public void setElement(E element)
  {
    this.element=element;
  }

  public E getElement()
  {
    return element;
  }

  public void addLeftChild(BinaryTreeNode leftNode)
  {
    if(left == null)
    {
      left= leftNode;
    }
    else
      System.out.println("Cannot add left child");
  }

  public void addRightChild(BinaryTreeNode rightNode)
  {
    if(right == null)
    {
      right = rightNode;
    }
    else
      System.out.println("Cannot add right child");
  }

  public BinaryTreeNode getLeftChild()
  {
    return left;
  }

  public BinaryTreeNode getRightChild()
  {
    return right;
  }
}
