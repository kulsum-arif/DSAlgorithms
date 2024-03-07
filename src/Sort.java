import java.util.*;

class Sort {


  public static void main(String[] args) {
    new Sort().start();
    }

    public void start(){

    Integer[] in = new Integer[]{3,4,4,3,2};
    Arrays.sort(in, new CustomSort());
    for(Integer i : in){
      System.out.println(i);
    }

    ArrayList<Sides> arr_1 = new ArrayList<>();
    arr_1.add(new Sides(7, 6, 5));
    arr_1.add(new Sides(7, 7, 6));
    arr_1.add(new Sides(8, 2, 9));
    arr_1.add(new Sides(2, 3, 4));
    arr_1.add(new Sides(1, 4, 3));
      for(Sides s :arr_1){
        System.out.println(s.a);
      }
    arr_1.sort(Sides::compareTo);
    for(Sides s :arr_1){
      System.out.println(s.a);
    }

    Collections.sort(arr_1, new Comparator<Sides>(){
      @Override
      public int compare(Sides o1, Sides o2) {
        if(o1.a == o2.a)
          return 0;

        return (o1.a<o2.a)?-1:1;
      }

    });
      for(Sides s :arr_1){
        System.out.println(s.a);
      }
  }

  class CustomSort implements Comparator<Integer> {

    @Override
    public int compare(Integer i1, Integer i2){
      if (i1 == i2)
        return 0;

      return (i1 < i2)?1:-1;
    }
  }

  class Sides implements Comparable<Sides>{
     int a;
     int b;
     int c;
    Sides(int a,int b,int c){
      this.a = a;
      this.b = b;
      this.c = c;
    }

    @Override
    public int compareTo(Sides o) {
      if (a == o.a)
      return 0;

      return a<=o.a?1:-1;

    }

    @Override
    public int hashCode(){
      return String.valueOf(a).hashCode()
          + String.valueOf(b).hashCode()
          + String.valueOf(c).hashCode();
    }

    @Override
    public boolean equals(Object s){
      if (!(s instanceof Sides)){
        return false;
    }

    Sides inSide = (Sides)s;
      if (inSide.a == this.a && inSide.b == this.b && inSide.c == this.c){
      return true;
    }
      return false;
  }


  }

  // Add any helper functions you may need here

  /**
   Equals means each side a,b,c is exactly same
   */
  int countDistinctTriangles(ArrayList<Sides> arr) {

    int result =0;
    HashMap<Sides, Integer> triangles = new HashMap<>();
    for(Sides s: arr){
      triangles.put(s, triangles.getOrDefault(s,0)+1);
    }

    for(Sides s: triangles.keySet()){
      if(triangles.get(s)==1){
        result++;
      }
    }
    return triangles.size();
  }













  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;

  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected);
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }

  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }

  public void run() {
    ArrayList<Sides> arr_1 = new ArrayList<>();
    arr_1.add(new Sides(7, 6, 5));
    arr_1.add(new Sides(5, 7, 6));
    arr_1.add(new Sides(8, 2, 9));
    arr_1.add(new Sides(2, 3, 4));
    arr_1.add(new Sides(2, 4, 3));
    int expected_1 = 3;
    int output_1 = countDistinctTriangles(arr_1);
    check(expected_1, output_1);

    ArrayList<Sides> arr_2 = new ArrayList<>();
    arr_2.add(new Sides(3, 4, 5));
    arr_2.add(new Sides(8, 8, 9));
    arr_2.add(new Sides(7, 7, 7));
    int expected_2 = 3;
    int output_2 = countDistinctTriangles(arr_2);
    check(expected_2, output_2);

    // Add your own test cases here

  }


}