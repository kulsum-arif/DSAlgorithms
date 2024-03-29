import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class LargestTriplet {


   /*
   Returns the product of the 3 largest numbers in a[0..i]
     int[] arr_1 = {1, 2, 3, 2, 2, 5};
    int[] expected_1 = {-1, -1, 6, 24, 60};
   */
  int[] findMaxProduct(int[] arr) {
    int[] result = new int[arr.length];

    int i=0;
    int[] max = new int[3];
    while(i<2 && i<arr.length){
      result[i] = -1;
      max[i] = arr[i];
      i++;
    }

    if (i == arr.length)
      return result;

    max[2] = arr[2];
    Arrays.sort(max);
    result[2] = max[0]*max[1]*max[2];
    for(i=3; i<arr.length; i++){
      if (arr[i] > max[0]){
        //push out max[0]
        max[0] = arr[i];
        Arrays.sort(max);
      }
      result[i] = max[0]*max[1]*max[2];
    }

    return result;
  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;

  void check(int[] expected, int[] output) {
    int expected_size = expected.length;
    int output_size = output.length;
    boolean result = true;
    if (expected_size != output_size) {
      result = false;
    }
    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
      result &= (output[i] == expected[i]);
    }
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printIntegerArray(expected);
      System.out.print(" Your output: ");
      printIntegerArray(output);
      System.out.println();
    }
    test_case_number++;
  }

  void printIntegerArray(int[] arr) {
    int len = arr.length;
    System.out.print("[");
    for(int i = 0; i < len; i++) {
      if (i != 0) {
        System.out.print(", ");
      }
      System.out.print(arr[i]);
    }
    System.out.print("]");
  }

  public void run() {
    int[] arr_1 = {1, 2, 3, 4, 5};
    int[] expected_1 = {-1, -1, 6, 24, 60};
    int[] output_1 = findMaxProduct(arr_1);
    check(expected_1, output_1);

    int[] arr_2 = {2, 4, 7, 1, 5, 3};
    int[] expected_2 = {-1, -1, 56, 56, 140, 140};
    int[] output_2 = findMaxProduct(arr_2);
    check(expected_2, output_2);

    // Add your own test cases here

  }

  public static void main(String[] args) {
    new LargestTriplet().run();
  }
}