import java.util.Scanner;

public class Main{
  static Scanner scan;

  static int solveMaxProfit(int[] values) {
    int maxProfit = -1000000000;
    int minValue = values[0];
    for(int i = 1; i < values.length; i++) {
      maxProfit = Math.max(maxProfit, values[i] - minValue);
      minValue = Math.min(minValue, values[i]);
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] values = new int[n];

    for(int i = 0; i < n; i++) {
      values[i] = scan.nextInt();
    }

    System.out.printf("%d\n", solveMaxProfit(values));
  }
}
