package hashmap_exercises;

import java.util.*;

/**
 * LeetCode 49 - Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * Example:
 * Input:  ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]] (order may vary)
 */
public class GroupAnagrams {

    /**
     * Groups the given words into lists of anagrams.
     *
     * @param strs array of input strings
     * @return a list of groups, where each group is a list of anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(anagrams.containsKey(key)){
                List<String> list = anagrams.get(key);
                list.add(strs[i]);
            }
            else {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                anagrams.put(key, newList);
            }
        }
        return new ArrayList<>(anagrams.values());
    }
}

