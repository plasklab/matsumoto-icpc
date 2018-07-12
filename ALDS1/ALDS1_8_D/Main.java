import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.util.Arrays;
import java.io.*;

class Node {
  Node left;
  Node right;
  int key;
  Node p;
  int priority;
}

class Tree {
  static Node root;
}

public class Main {
  Node rightRotate(Node t) {
    Node s = t.left;
    t.left = s.right;
    s.right = t;
    return s;
  }

  Node leftRotate(Node t) {
    Node s = t.right;
    t.right = s.left;
    s.left = t;
    return s;
  }

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

  Node _delete(Node t, int key) {
    if(t.left == null && t.right == null)
      return null;
    else if(t.left == null)
      t = leftRotate(t);
    else if(t.right == null)
      t = rightRotate(t);
    else {
      if(t.left.priority > t.right.priority)
        t = rightRotate(t);
      else
        t = leftRotate(t);
    }
    return delete(t, key);
  }

  Node delete(Node t, int key) {
    if(t == null)
      return null;
    if(key < t.key)
      t.left = delete(t.left, key);
    else if(key > t.key)
      t.right = delete(t.right, key);
    else
      return _delete(t, key);
    return t;
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

  Node insert(Node t, int key, int priority) {
    if(t == null) {
      Node newNode = new Node();
      newNode.key = key;
      newNode.priority = priority;
      return newNode;
    }
    if(key == t.key)
      return t;

    if(key < t.key) {
      t.left = insert(t.left, key, priority);
      if(t.priority < t.left.priority)
        t = rightRotate(t);
    } else {
      t.right = insert(t.right, key, priority);
      if(t.priority < t.right.priority)
        t = leftRotate(t);
    }
    return t;
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
          String[] splited = input.split(" ");
          tree.root = insert(tree.root, Integer.parseInt(splited[1]), Integer.parseInt(splited[2]));
        } else if(input.charAt(0) == 'f') {
          System.out.println((find(tree, Integer.parseInt(input.substring(5))) ? "yes" : "no"));
        } else if(input.charAt(0) == 'd') {
          tree.root = delete(tree.root, Integer.parseInt(input.substring(7)));
        } else {
          print(tree);
          //System.out.println(tree.root.key);
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
