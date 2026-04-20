class Solution {
    public String findOrder(String[] words) {

        int ch[] = new int[26];
        Map<Character, Set<Character>> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        Set<Character> set = new HashSet<>();

        // ✅ FIX 1: add all characters
        for(String word : words) {
            for(char c : word.toCharArray()) {
                set.add(c);
            }
        }

        for(int i = 1; i < words.length; ++i)
        {
            String previous = words[i - 1];
            String current = words[i];

            int j = 0, k = 0;

            while(j < previous.length() && k < current.length() 
                  && previous.charAt(j) == current.charAt(k))
            {
                j++; k++;
            }

            // ✅ FIX 2: mismatch case
            if(j < previous.length() && k < current.length())
            {
                char u = previous.charAt(j);
                char v = current.charAt(k);

                map.putIfAbsent(u, new HashSet<>());

                // ✅ FIX 3: avoid duplicate edges
                if(!map.get(u).contains(v)) {
                    map.get(u).add(v);
                    ch[v - 'a']++;
                }
            }
            else {
                // ✅ FIX 4: prefix invalid case
                if(previous.length() > current.length()) {
                    return "";
                }
            }
        }

        // add nodes with indegree 0
        for(char c : set)
        {
            if(ch[c - 'a'] == 0)
            {
                q.add(c);
            }
        }

        // ✅ FIX 5: use StringBuilder
        StringBuilder str = new StringBuilder();

        while(!q.isEmpty())
        {
            char c = q.poll();
            str.append(c);

            if(map.containsKey(c))
            {
                for(char temp : map.get(c))
                {
                    ch[temp - 'a']--;

                    if(ch[temp - 'a'] == 0)
                    {
                        q.add(temp);
                    }
                }
            }
        }

        // cycle check
        for(char c : set)
        {
            if(ch[c - 'a'] != 0) {
                return "";
            }
        }

        return str.toString();
    }
}