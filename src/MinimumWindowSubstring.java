import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {

  public static void main(String[] args) {
    new MinimumWindowSubstring().minWindowSub("AADOBECODEBANC", "ABC");
    // should have BANC
  }

  public void minWindowSub(String s, String t) {
    String minSub = "";

    HashMap<String, List<String>> map = new HashMap<>();
    char[] sc = s.toCharArray();
    int key=0;
    for(Character c: sc){
      key += c.hashCode();
    }
  }
}
