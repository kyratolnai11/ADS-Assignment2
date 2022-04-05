import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable> extends BinaryTree<E>
{

  public BinarySearchTree(BinarySearchTreeNode root)
  {
    super();
    setRoot(root);
  }

  public E findMax()
  {
    ArrayList<E> list = new ArrayList<>();
    list.addAll(preOrder(getRoot()));
    E max = list.get(0);
    for (int i = 1; i < list.size(); i++)
    {
      if (list.get(i).compareTo(max) > 0)
        max = list.get(i);
    }
    return max;
  }

  public E findMin(BinaryTreeNode rightChild)
  {
    ArrayList<E> list = new ArrayList<>();
    list.addAll(preOrder(getRoot()));
    E min = list.get(0);
    for (int i = 1; i < list.size(); i++)
    {
      if (list.get(i).compareTo(min) < 0)
        min = list.get(i);
    }
    return min;
  }

  public boolean contains(E element)
  {
    return contains(getRoot(), element);
  }

  public BinarySearchTreeNode insertRec(BinarySearchTreeNode root, E element)
  {

    /* Otherwise, recur down the tree */
    if (element.compareTo(root.getElement()) < 0)
    {
      if (root.getLeftChild() == null)
        root.addLeftChild(new BinarySearchTreeNode(element));
      else
        root.addLeftChild(
            insertRec((BinarySearchTreeNode) root.getLeftChild(), element));
    }

    else if (element.compareTo(root.getElement()) > 0)
    {
      if (root.getRightChild() == null)
        root.addRightChild(new BinarySearchTreeNode(element));
      else
        root.addRightChild(
            insertRec((BinarySearchTreeNode) root.getRightChild(), element));

    }
    return root;
  }

  public void insert(E element)
  {

    insertRec((BinarySearchTreeNode) getRoot(), element);
  }

  public BinarySearchTreeNode search(BinarySearchTreeNode root, E element)
  {
    // Base Cases: root is null or key is present at root
    if (root.getElement().compareTo(element) == 0)
      return root;

    // Key is greater than root's key
    if (root.getElement().compareTo(element) < 0)
      return search((BinarySearchTreeNode) root.getRightChild(), element);

    // Key is smaller than root's key
    return search((BinarySearchTreeNode) root.getLeftChild(), element);
  }

  public boolean remove(E element)
  {
    if (!contains(element)) {
      return false;
    }
    deleteNode( (BinarySearchTreeNode) getRoot(), element);
    return true;
  }

  private BinarySearchTreeNode deleteRec(BinarySearchTreeNode root, E element)
  {
    if (root.getElement().compareTo(element) > 0)
      root.addLeftChild(
          deleteRec((BinarySearchTreeNode) root.getLeftChild(), element));
    else if (root.getElement().compareTo(element) < 0)
      root.addRightChild(
          deleteRec((BinarySearchTreeNode) root.getRightChild(), element));

    else
    {
      if (root.getLeftChild() == null)
        return (BinarySearchTreeNode) root.getRightChild();
      else if (root.getRightChild() == null)
        return (BinarySearchTreeNode) root.getLeftChild();

      root.setElement(findMin(root.getRightChild()));

      root.addRightChild(deleteRec((BinarySearchTreeNode) root.getRightChild(),
          (E) root.getElement()));
    }

    return root;
  }

  private void deleteNode(BinarySearchTreeNode removableNode, E element)
  {
    if (removableNode.getElement().compareTo(element) > 0)
    {
      deleteNode((BinarySearchTreeNode) removableNode.getLeftChild(),
          element);
      return;
    }
    else if (removableNode.getElement().compareTo(element) < 0)
    {
      deleteNode((BinarySearchTreeNode) removableNode.getRightChild(),
          element);
      return;
    }
    if (removableNode.getRightChild() == null)
    {
      if (removableNode.getLeftChild() == null)
      {
        removableNode = null;
        return;
      }
      removableNode = (BinarySearchTreeNode) removableNode.getLeftChild();
    }

    BinarySearchTree tempTree = new BinarySearchTree<>((BinarySearchTreeNode) removableNode.getRightChild());
    BinarySearchTreeNode successor = search(removableNode,
        (E) tempTree.findMin(getRoot()));
    removableNode.setElement(successor.getElement());
    removableNode.addRightChild(successor.getRightChild());
  }
}
