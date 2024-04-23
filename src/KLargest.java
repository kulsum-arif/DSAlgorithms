import java.util.PriorityQueue;

public class KLargest {

  public static void main(String[] args){
    int result = new KLargest().getKLargest(new int[]{1, 0, 9, 2, 3}, 3);
    System.out.println(result); // 1
    // 3, 5, 6, 8, 9, 0, 2, 1   k=3 --> 2
  }

  public int getKLargest(int[] in, int k){

    // Sort and then get but o(logn)

    // If you put in a priority queue with k elements that would work
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i=0; i<in.length; i++){
      if (queue.size() < k) {
        queue.add(in[i]);
      }
      else{
        if (queue.peek() < in[i]){
          queue.poll();
          queue.add(in[i]);
        }
      }
    }

    return queue.poll();

  }
}
