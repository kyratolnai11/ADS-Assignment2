import javax.naming.BinaryRefAddr;
import java.util.ArrayList;
import java.util.Queue;

public class Main
{
  public static void main(String[] args)
  {



    BinarySearchTreeNode rootNode = new BinarySearchTreeNode(40);
    BinarySearchTree tree = new BinarySearchTree(rootNode);
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


    System.out.println("--------------------------");
    tree.insert(15);
    tree.insert(9);
    tree.insert(90);


    System.out.println("--------------------------");
    tree.remove(20);
    System.out.println("--------------------------");

    ArrayList<Integer> list3 =  tree.preOrder(rootNode);

    for (int i=0;i<list3.size();i++)
    {
      System.out.println(list3.get(i));
    }

  }


}