import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

import java.util.Arrays;

class Node {
  int id;
  int left;
  int right;

  Node(int id, int left, int right) {
    this.id = id;
    this.left = left;
    this.right = right;
  }
}

public class Main {
  static Scanner scan;
  static int n;
  static Node[] nodes;
  static int rootId;
  static int[] idTable;

  int idToNodeId(int id) {
    return nodes[id].id;
  }

  int nodeIdToId(int nodeId) {
    if (nodeId < 0)
      return -1;
    return idTable[nodeId];
  }

  void printPreorder(int nodeId) {
    System.out.print(" " + nodeId);
    if (nodes[nodeIdToId(nodeId)].left >= 0)
      printPreorder(nodes[nodeIdToId(nodeId)].left);
    if (nodes[nodeIdToId(nodeId)].right >= 0)
      printPreorder(nodes[nodeIdToId(nodeId)].right);
  }

  void printInorder(int nodeId) {
    if (nodes[nodeIdToId(nodeId)].left >= 0)
      printInorder(nodes[nodeIdToId(nodeId)].left);
    System.out.print(" " + nodeId);
    if (nodes[nodeIdToId(nodeId)].right >= 0)
      printInorder(nodes[nodeIdToId(nodeId)].right);
  }

  void printPostorder(int nodeId) {
    if (nodes[nodeIdToId(nodeId)].left >= 0)
      printPostorder(nodes[nodeIdToId(nodeId)].left);
    if (nodes[nodeIdToId(nodeId)].right >= 0)
      printPostorder(nodes[nodeIdToId(nodeId)].right);
    System.out.print(" " + nodeId);
  }

  void run() {
    scan = new Scanner(System.in);
    n = scan.nextInt();
    nodes = new Node[n];
    idTable = new int[n];
    boolean[] isRoot = new boolean[n];
    for (int i = 0; i < n; i++) {
      isRoot[i] = true;
    }
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node(scan.nextInt(), scan.nextInt(), scan.nextInt());
      idTable[nodes[i].id] = i;
      if (nodes[i].left >= 0)
        isRoot[nodes[i].left] = false;
      if (nodes[i].right >= 0)
        isRoot[nodes[i].right] = false;
    }

    // System.out.println(Arrays.toString(isRoot));

    rootId = -1;
    for (int i = 0; i < n; i++) {
      if (isRoot[i])
        rootId = i;
    }
    // System.out.println(rootId);

    System.out.println("Preorder");
    printPreorder(rootId);
    System.out.println();
    System.out.println("Inorder");
    printInorder(rootId);
    System.out.println();
    System.out.println("Postorder");
    printPostorder(rootId);
    System.out.println();

    return;
  }

  public static void main(String[] args) {
    new Main().run();
    return;
  }
}