import java.util.HashMap;

public class LongestSubstring {
  public static void main(String[] args){
   new LongestSubstring().run();
  }

  public void run(){
    String str = "abcabcd12345";
    int maxLength=0;
    int maxStartPos=0;
    int startPos = 0;
    HashMap<Character, Integer> map = new HashMap<>();

    for(int i=0; i<str.length(); i++){
      char c = str.charAt(i);
      if(map.get(c) !=null){
        if ( i- startPos > maxLength){
          maxLength = i-startPos;
          maxStartPos = startPos;
        }
        startPos = map.get(c)+1;
        map.remove(c);
      }
      map.put(c, i);
    }
    if (maxLength < map.size()){
      maxLength = map.size();
      maxStartPos = startPos;
    }
    System.out.println(str.substring(maxStartPos, maxStartPos+maxLength));
  }
}
