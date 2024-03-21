import java.util.HashMap;

public class Fibonacci {

  public static void main(String[] args) {

    new Fibonacci().start();
  }

  public void start() {

    System.out.println(fibo(1, 1, 10));
    HashMap<String, Integer> dict = new HashMap<>();
  }

  public int fibo(int x, int y, int n) {
    if (n == 1) return x;

    return fibo(y, x + y, n - 1);
  }

  public int[] fib(int first, int second, int n) {

    if (n == 0) return null;
    if (n == 1) return new int[] {1};
    if (n == 2) return new int[] {1, 1};

    int[] result = new int[n];
    result[0] = 1;
    result[1] = 1;
    int currPos = 2;
    while (currPos < n) {
      result[currPos] = result[currPos - 1] + result[currPos - 2];
      currPos++;
    }
    return result;
  }
}
