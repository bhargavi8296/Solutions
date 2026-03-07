import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>(wordList);
        
        
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        int level = 1;  
        
        while (!queue.isEmpty()) {
            int size=queue.size();
            for(int j=0;j<size;++j)
            {
                String current = queue.poll();
                if (current.equals(endWord)) {
                    return level;
                }
                for(int i=0;i<current.length();++i){
                    for (char c = 'a'; c <= 'z'; c++) {
                        String newWord = current.substring(0,i)+c+current.substring(i+1);
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); 
                        }
                    }
                }
            }
            level++;
        }
        
        return 0;
    }
}