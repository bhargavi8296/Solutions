class Pair {
    String word;
    int dist;

    Pair(String w, int d){
        word = w;
        dist = d;
    }
}

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){

            Pair p = q.poll();
            String word = p.word;
            int dist = p.dist;

            for(int i=0;i<word.length();i++){

                for(char ch='a'; ch<='z'; ch++){

                    String newWord =
                        word.substring(0,i) + ch + word.substring(i+1);

                    if(set.contains(newWord)){

                        if(newWord.equals(endWord))
                            return dist + 1;

                        set.remove(newWord);

                        q.add(new Pair(newWord, dist+1));
                    }
                }
            }
        }

        return 0;
    }
}