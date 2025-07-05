package practise;

import java.util.ArrayList;
import java.util.List;

public class PrefixComparison {

   private static String prefix1= "float,flower,flight";
   private static  String prefix2= "dog,racecar,car";

   public static String[] p1= prefix1.split(",");
 public static   String[] p2= prefix2.split(",");
    public static String longestCommonPrefix(String[] strs) {
        // If the input array is null or empty, return an empty string.
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Iterate through the characters of the first string.
        for (int i = 0; i < strs[0].length(); i++) {
            // Take the current character of the first string.
            char c = strs[0].charAt(i);

            // Compare this character with the character at the same position in other strings.
            for (int j = 1; j < strs.length; j++) {
                // If there is a mismatch or current string is shorter, return the prefix found till now.
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        // If all characters matched in all strings, return the first string as the common prefix.
        return strs[0];
    }
            
           public static void main(String[] args) {

          String s=  PrefixComparison.longestCommonPrefix(p1);
          System.out.println("Longest common prefix: " + s);
           String s1= PrefixComparison.longestCommonPrefix(p2);
         System.out.println("Longest common prefix: " + s1);

    }


    
}
