
import java.util.*;
// Add any extra import statements you may need here


class BalanceBrackets {
  // Add any helper functions you may need here

  //{(a(a))} => true
  //[](){()}(()) => true
  //{(}) => false
  boolean isBalanced(String s) {
    // if empty return true
    if(s.length()<=0)
      return true;


    //Push to stack and then when closing char found find the previous opening char abd see if it matches
    // {(( -> pushing, when first close pop and check
    Stack<Character> stack = new Stack<>();
    for(int i=0; i<s.length()-1; i++){
      char currChar = s.charAt(i);
      if (currChar =='(' || currChar =='{'|| currChar =='['){
        stack.push(currChar);
      }
      else if (currChar ==')' || currChar =='}'|| currChar ==']')
      {
        char prevChar = stack.pop();
        if (currChar==')' && prevChar !='(')
          return false;
        if (currChar=='}' && prevChar !='{')
          return false;
        if (currChar==']' && prevChar !='[')
          return false;
      }

    }
    return true;
  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  void check(boolean expected, boolean output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      System.out.print(expected);
      System.out.print(" Your output: ");
      System.out.print(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printString(String str) {
    System.out.print("[" + str + "]");
  }

  public void run() {
    String s_1 = "{[(])}";
    boolean expected_1 = false;
    boolean output_1 = isBalanced(s_1);
    check(expected_1, output_1);

    String s_2 = "{{[[(())]]}}";
    boolean expected_2 = true;
    boolean output_2 = isBalanced(s_2);
    check(expected_2, output_2);

    // Add your own test cases here

  }

  public static void main(String[] args) {
    new Sort().run();
  }
}
