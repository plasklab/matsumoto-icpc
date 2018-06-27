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
  static StringBuilder[] sb;

  int idToNodeId(int id) {
    return nodes[id].id;
  }

  int nodeIdToId(int nodeId) {
    if (nodeId < 0)
      return -1;
    return idTable[nodeId];
  }

  int treeToString(int nodeId, int parent, int depth) {
    int id = nodeIdToId(nodeId);
    if (id < 0)
      return 0;

    sb[nodeId] = new StringBuilder("node " + nodeId + ": parent = " + parent + ", ");

    if (id == rootId)
      sb[nodeId].append("sibling = -1, ");
    else if (nodes[nodeIdToId(parent)].left == nodeId)
      sb[nodeId].append("sibling = " + nodes[nodeIdToId(parent)].right + ", ");
    else
      sb[nodeId].append("sibling = " + nodes[nodeIdToId(parent)].left + ", ");

    int degree = 0;
    int height = 0;
    if (nodes[id].left >= 0) {
      degree++;
      height = treeToString(nodes[id].left, nodeId, depth + 1);
    }
    if (nodes[id].right >= 0) {
      degree++;
      int tmp = treeToString(nodes[id].right, nodeId, depth + 1);
      height = (height > tmp ? height : tmp);
    }
    sb[nodeId].append("degree = " + degree + ", depth = " + depth + ", height = " + height + ", ");

    if (id == rootId) {
      sb[nodeId].append("root");
      return height + 1;
    } else if (degree != 0) {
      sb[nodeId].append("internal node");
      return height + 1;
    } else {
      sb[nodeId].append("leaf");
      return 1;
    }
  }

  void run() {
    scan = new Scanner(System.in);
    n = scan.nextInt();
    nodes = new Node[n];
    idTable = new int[n];
    sb = new StringBuilder[n];
    boolean[] isRoot = new boolean[n];
    for (int i = 0; i < n; i++) {
      isRoot[i] = true;
    }
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node(scan.nextInt(), scan.nextInt(), scan.nextInt());
      idTable[nodes[i].id] = i;
      if (nodes[i].left > 0)
        isRoot[nodes[i].left] = false;
      if (nodes[i].right > 0)
        isRoot[nodes[i].right] = false;
    }

    rootId = -1;
    for (int i = 0; i < n; i++) {
      if (isRoot[i])
        rootId = i;
    }
    rootId = nodeIdToId(rootId);

    // System.out.println("root " + rootId);
    // System.out.println("idTable" + Arrays.toString(idTable));
    // for(int i = 0; i < n; i++)
    // System.out.println(Arrays.toString(c[i]));
    treeToString(idToNodeId(rootId), -1, 0);
    // System.out.println(Arrays.toString(k));
    // System.out.println(Arrays.toString(sb));

    for (int i = 0; i < n; i++) {
      // System.out.println(i);
      System.out.println(new String(sb[i]));
    }

    return;
  }

  public static void main(String[] args) {
    new Main().run();
    return;
  }
}