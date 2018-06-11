import java.io.*;
import java.util.Scanner;

class Item {
  Item a, c, g, t;
  boolean fin = false;;
}

public class Main {
  Item index;

  void insert(String str) {
    Item item = index;

    for(int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if(c == 'A') {
        if(item.a == null) {
          item.a = new Item();
        }
        item = item.a;
      } else if(c == 'C') {
        if(item.c == null) {
          item.c = new Item();
        }
        item = item.c;
      } else if(c == 'G') {
        if(item.g == null) {
          item.g = new Item();
        }
        item = item.g;
      } else {
        if(item.t == null) {
          item.t = new Item();
        }
        item = item.t;
      }
    }
    item.fin = true;
    return;
  }

  boolean find(String str) {
    Item item = index;

    for(int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if(c == 'A') {
        if(item.a == null) {
          return false;
        }
        item = item.a;
      } else if(c == 'C') {
        if(item.c == null) {
          return false;
        }
        item = item.c;
      } else if(c == 'G') {
        if(item.g == null) {
          return false;
        }
        item = item.g;
      } else {
        if(item.t == null) {
          return false;
        }
        item = item.t;
      }
    }
    if(item.fin)
      return true;
    else
      return false;
  }

  void run(){
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      index = new Item();
      String input = "";
      String[] splited;

      for(; n > 0; n--) {
        input = br.readLine();
        splited = input.split(" ");
        if("insert".equals(splited[0])) {
          insert(splited[1]);
        } else {
          if(find(splited[1]))
            System.out.println("yes");
          else
            System.out.println("no");
        }
      }

    } catch(Exception e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    new Main().run();
  }
}
