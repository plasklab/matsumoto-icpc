import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.util.Arrays;

class Node {
  int id;
  Node left;
  Node right;

  Node() {
  }
}

public class Main {
  static Scanner scan;
  static int n;
  static int rootId;
  static int[] idTable;
  static int[] preorder;
  static int[] inorder;
  static int[] postorder;
  static int preI;
  static int[] str;

  int preToIn(int preId) {
    return idTable[preId];
  }

  void printPostorder(Node node) {
    if (node.left != null)
      printPostorder(node.left);
    if (node.right != null)
      printPostorder(node.right);
    str[preI++] = node.id;
    if (node.id == preorder[0]) {
      for (int i = 0; i < n; i++) {
        if (i != 0) {
          System.out.print(" ");
        }
        System.out.print(str[i]);
      }
      System.out.println();
    }
  }

  void makePostorder(int from, int to, Node node) {
    int root = preorder[preI];

    node.id = preorder[preI];
    int id = preToIn(node.id);
    // System.out.println(from + " " + to + " " + id + " left:" +
    // (id - from) + " right:" + (to - id));

    if (id - from > 0) {
      preI++;
      if (preI < n) {
        node.left = new Node();
        makePostorder(from, id - 1, node.left);
      }
    }
    if (to - id > 0) {
      preI++;
      if (preI < n) {
        node.right = new Node();
        makePostorder(id + 1, to, node.right);
      }
    }
  }

  void run() {
    scan = new Scanner(System.in);
    n = scan.nextInt();

    preorder = new int[n];
    for (int i = 0; i < n; i++) {
      preorder[i] = scan.nextInt();
    }

    inorder = new int[n];
    for (int i = 0; i < n; i++) {
      inorder[i] = scan.nextInt();
    }

    idTable = new int[n + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (preorder[i] == inorder[j]) {
          idTable[preorder[i]] = j;
        }
      }
    }

    preI = 0;
    str = new int[n];
    Node root = new Node();
    makePostorder(0, n - 1, root);
    preI = 0;
    printPostorder(root);

    return;
  }

  public static void main(String[] args) {
    new Main().run();
    return;
  }
}