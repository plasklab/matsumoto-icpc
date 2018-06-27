import java.util.Scanner;
import java.util.Arrays;

class Node {
  int id;
  int c[];

  Node(int id, int k) {
    this.id = id;
    this.c = new int[k];
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
    return idTable[nodeId];
  }

  void treeToString(int nodeId, int parent, int depth) {
    // System.out.println("root:" + rootId + " node:" + nodeId);
    int id = nodeIdToId(nodeId);
    sb[nodeId] = new StringBuilder("node " + nodeId + ": parent = " + parent + ", depth = " + depth + ", ");
    if (id == rootId) {
      sb[nodeId].append("root");
    } else if (nodes[id].c.length != 0) {
      sb[nodeId].append("internal node");
    } else {
      sb[nodeId].append("leaf");
    }
    sb[nodeId].append(", [");
    for (int j = 0; j < nodes[id].c.length; j++) {
      if (j != 0)
        sb[nodeId].append(", ");
      sb[nodeId].append(nodes[id].c[j]);
    }
    sb[nodeId].append("]");

    for (int j = 0; j < nodes[id].c.length; j++) {
      treeToString(nodes[id].c[j], nodeId, depth + 1);
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
      nodes[i] = new Node(scan.nextInt(), scan.nextInt());
      idTable[nodes[i].id] = i;
      for (int j = 0; j < nodes[i].c.length; j++) {
        nodes[i].c[j] = scan.nextInt();
        isRoot[nodes[i].c[j]] = false;
      }
    }

    rootId = -1;
    for (int i = 0; i < n; i++) {
      if (isRoot[i])
        rootId = i;
    }
    // System.out.println("root" + rootId);
    rootId = nodeIdToId(rootId);

    // System.out.println("root" + rootId);
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