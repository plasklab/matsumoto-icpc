import java.io.*;

public class Main {

  void run(){
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String input = br.readLine();
      String[] splited = input.split(" ");
      int n = Integer.parseInt(splited[0]);
      int k = Integer.parseInt(splited[1]);
      int[] w = new int[n];
      int sum = 0;
      for(int i = 0; i < n; i++) {
        w[i] = Integer.parseInt(br.readLine());
        sum += w[i];
      }

      int max = 1;
      while(max * k < sum) {
        max++;
      }
      while(true) {
        int ki = 1;
        int cap = 0;
        int i = 0;
        for(i = 0; i < n; i++) {
          //System.out.println("max:" + max + " cap:" + cap);
          if(max < cap + w[i]) {
            ki++;
            cap = w[i];
            if(ki > k || cap > max) {
              max++;
              break;
            }
          } else {
            cap += w[i];
          }
        }
        if(i == n)
          break;
      }

      System.out.println(max);


    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
