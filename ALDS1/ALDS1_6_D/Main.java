import java.util.Scanner;
import java.util.Arrays;

public class Main {
  void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  int partition(int[] a, int p, int r) {
    int x = a[r];
    int i = p - 1;
    for(int j = p; j < r; j++) {
      if(a[j] <= x) {
        i++;
        swap(a, i, j);
      }
    }
    swap(a, i + 1, r);
    return i + 1;
  }

  void quickSort(int[] a, int p, int r) {
    if(p < r) {
      int q = partition(a, p, r);
      quickSort(a, p, q - 1);
      quickSort(a, q + 1, r);
    }
  }

  void run() {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int[] w = new int[n];
      int min = Integer.MAX_VALUE;
      for(int i = 0; i < n; i++) {
        w[i] = scan.nextInt();
        if(min > w[i])
          min = w[i];
      }

      int[] sorted = new int[n];
      System.arraycopy(w, 0, sorted, 0, w.length);
      quickSort(sorted, 0, n - 1);
      //System.out.println(Arrays.toString(sorted));

      int[] address = new int[n];
      for(int i = 0; i < n; i++)
        for(int j = 0; j < n; j++)
          if(w[i] == sorted[j])
            address[i] = j;
      //System.out.println(Arrays.toString(address));

      int[] cycle = new int[n];

      for(int i = 0; i < n; i++) {
        if(cycle[i] != 0)
          continue;
        cycle[i] = i + 1;
        int tmp = w[i];
        int j = i;
        while(i != address[j]) {
          cycle[address[j]] = i + 1;
          j = address[j];
        }
      }
      //System.out.println(Arrays.toString(cycle));

      int cost = 0;
      for(int i = 0; i < n; i++) {
        if(cycle[i] == 0)
          continue;
        int tmp = w[i];
        int c = cycle[i];
        int counter = 1;
        int minCycle = w[i];
        for(int j = i + 1; j < n; j++) {
          if(cycle[j] != c)
            continue;
          tmp += w[j];
          counter++;
          if(minCycle > w[j])
            minCycle = w[j];
          cycle[j] = 0;
        }
        cost += Math.min(tmp + (counter - 2) * minCycle, tmp + minCycle + (counter + 1) * min);
      }
      System.out.println(cost);
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
