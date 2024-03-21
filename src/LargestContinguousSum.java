public class LargestContinguousSum {

  public static void main(String[] args) {
    new LargestContinguousSum().run();
  }

  // 5 4 3 -1 3 3
  public void run() {
    int[] arr = new int[] {5, 4, 3, 0, 2, -1, 3, 3, 5, 5};

    int currSum = 0;
    int largestSum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (currSum <= currSum + arr[i]) {
        currSum += arr[i];
      } else {
        if (largestSum < currSum) largestSum = currSum;
        // reset
        currSum = 0;
      }
    }
    if (largestSum < currSum) largestSum = currSum;
    System.out.println(largestSum);
  }
}
