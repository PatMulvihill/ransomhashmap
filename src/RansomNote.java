/**
 *
 * @author Patrick Mulvihill
 * CMPT 438: Algorithms
 * Dr. Tian
 * Project 5
 * pmulvihill01@manhattan.edu
 * github.com/PatMulvihill/HeapSort
 */

import java.util.*;

public class RansomNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    int solved = 0;
    
    public static int Solution(String magazine, String note) {
        Hashtable<String, Integer> magazineHash = new Hashtable();
        String[] magazineSplit = magazine.split(" ");
        String[] noteSplit = note.split(" ");
        for (String item : magazineSplit) {
            if (magazineHash.containsKey(item)) {
                int num = magazineHash.get(item);
                magazineHash.put(item, ++num);
            } else {
                magazineHash.put(item, 1);
            }
        }
        for (String item : noteSplit) {
            if (magazineHash.containsKey(item)) {
                if (magazineHash.get(item) != 0) {
                    int num = magazineHash.get(item);
                    magazineHash.put(item, --num);
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
        return 1;
    }
    
    public static String solve (int i) {
        if (i == 1) {
            return "Yes.";
        } else {
            return "No.";
        }
    }

    public static void main(String[] args) {
        String magazine = "that other magazine will kill your brain cells.  i think you should be reading this one";
        String ransom1 = "i will kill you";
        String ransom2 = "reading this magazine will kill";
        String ransom3 = "you shouldn't be reading this magazine";
        
        int s = Solution(magazine, ransom1);
        System.out.println("Magazine Text: " + magazine);
        System.out.println("Ransom Text: " + ransom1);
        System.out.println("Can you make the ransom note out of the words in the magazine? " + solve(s) + "\n\n");
        
        s = Solution(magazine, ransom2);
        System.out.println("Magazine Text: " + magazine);
        System.out.println("Ransom Text: " + ransom2);
        System.out.println("Can you make the ransom note out of the words in the magazine? " + solve(s) + "\n\n");
        
        s = Solution(magazine, ransom3);
        System.out.println("Magazine Text: " + magazine);
        System.out.println("Ransom Text: " + ransom3);
        System.out.println("Can you make the ransom note out of the words in the magazine? " + solve(s));
      
    }
}
