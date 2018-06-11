import java.io.*;

class DubblyLinkedNode {
  private DubblyLinkedNode next;
  private DubblyLinkedNode prev;
  private int key;

  DubblyLinkedNode(int key) {
    setKey(key);
  }

  DubblyLinkedNode getNextNode() {
    return next;
  }

  DubblyLinkedNode getPrevNode() {
    return prev;
  }

  public int getKey() {
    return key;
  }

  public void setNextNode(DubblyLinkedNode node) {
    next = node;
  }

  public void setPrevNode(DubblyLinkedNode node) {
    prev = node;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public String toString() {
    return key + "";
  }
}

class DubblyLinkedList {
  private DubblyLinkedNode dummy;

  DubblyLinkedList() {
    dummy = new DubblyLinkedNode(-1);
    dummy.setNextNode(dummy);
    dummy.setPrevNode(dummy);
  }

  public void insert(int key) {
    DubblyLinkedNode node = new DubblyLinkedNode(key);
    node.setNextNode(dummy.getNextNode());
    node.setPrevNode(dummy);
    dummy.getNextNode().setPrevNode(node);
    dummy.setNextNode(node);
  }

  public boolean delete(int key) {
    DubblyLinkedNode node = dummy.getNextNode();
    while(node != dummy) {
      if(node.getKey() == key) {
        node.getNextNode().setPrevNode(node.getPrevNode());
        node.getPrevNode().setNextNode(node.getNextNode());
        return true;
      }
      node = node.getNextNode();
    }
    return false;
  }

  public void deleteFirst() {
    dummy.getNextNode().getNextNode().setPrevNode(dummy);
    dummy.setNextNode(dummy.getNextNode().getNextNode());
  }

  public void deleteLast() {
    dummy.getPrevNode().getPrevNode().setNextNode(dummy);
    dummy.setPrevNode(dummy.getPrevNode().getPrevNode());
  }

  public DubblyLinkedNode getDummy() {
    return dummy;
  }

  public String toString() {
    String str = "";
    DubblyLinkedNode node = dummy.getNextNode();
    if(node == dummy)
      return "";

    while(true) {
      str += node.toString();
      node = node.getNextNode();
      if(node == dummy)
        break;
      else
        str += " ";
    }
    return str;
  }
}
/*
public class Main {
  public static void main(String[] args) {
    DubblyLinkedList list = new DubblyLinkedList();
    list.insert(1);
    list.insert(2);
    list.insert(1);
    System.out.println(list.toString());
    list.delete(1);
    System.out.println(list.toString());
  }
}*/


public class Main {
  void run(){
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      DubblyLinkedList list = new DubblyLinkedList();
      String input = "";
      String[] splited;

      for(; n > 0; n--) {
        input = br.readLine();
        //System.out.println(input);
        splited = input.split(" ");

        if("insert".equals(splited[0])) {
          list.insert(Integer.parseInt(splited[1]));
        } else if("delete".equals(splited[0])) {
          list.delete(Integer.parseInt(splited[1]));
        } else if("deleteFirst".equals(splited[0])) {
          list.deleteFirst();
        } else {// if("deleteLast".equals(inst)) {
          list.deleteLast();
        }
      }

      DubblyLinkedNode node = list.getDummy().getNextNode();
      if(node == list.getDummy()) {
        System.out.println();
        return;
      }

      while(true) {
        System.out.print(node.toString());
        node = node.getNextNode();
        if(node == list.getDummy())
          break;
        else
          System.out.print(" ");
      }
      System.out.println();

    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
