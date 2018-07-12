import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.util.Arrays;
import java.io.*;

class Node {
  Node left;
  Node right;
  int key;
  Node p;
}

class Tree {
  static Node root;
}

public class Main {
  void printInorder(Node node) {
    if(node.left != null)
      printInorder(node.left);
    System.out.print(" " + node.key);
    if(node.right != null)
      printInorder(node.right);
  }

  void printPreorder(Node node) {
    System.out.print(" " + node.key);
    if(node.left != null)
      printPreorder(node.left);
    if(node.right != null)
      printPreorder(node.right);
  }

  void print(Tree tree) {
    //Inorder
    printInorder(tree.root);
    System.out.println();
    //Preorder
    printPreorder(tree.root);
    System.out.println();
  }

  boolean find(Tree tree, int key) {
    Node currentNode = tree.root;
    while(currentNode.key != key) {
      if(currentNode.key > key) {
        if(currentNode.left == null) {
          return false;
        }
        currentNode = currentNode.left;
      } else {
        if(currentNode.right == null) {
          return false;
        }
        currentNode = currentNode.right;
      }
    }
    return true;
  }

  boolean insert(Tree tree, Node z) {
    Node y = null;
    Node x = Tree.root;
    while(x != null) {
      y = x;
      if(z.key < x.key) {
        x = x.left;
      } else {
        x = x.right;
      }
    }
    z.p = y;

    if(y == null) {
      tree.root = z;
    } else if(z.key < y.key) {
      y.left = z;
    } else {
      y.right = z;
    }
    return true;
  }

  void run() {
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int m = Integer.parseInt(br.readLine());
      Tree tree = new Tree();
      tree.root = null;

      for(int i = 0; i < m; i++) {
        String input = br.readLine();
        if(input.charAt(0) == 'i') {
          Node node = new Node();
          node.key = Integer.parseInt(input.substring(7));
          insert(tree, node);
        } else if(input.charAt(0) == 'f') {
          System.out.println((find(tree, Integer.parseInt(input.substring(5))) ? "yes" : "no"));
        } else {
          print(tree);
        }
      }

    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new Main().run();
    return;
  }
}
