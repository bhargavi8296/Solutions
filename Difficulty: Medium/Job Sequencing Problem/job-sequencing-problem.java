import java.util.*;

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;

        int arr[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = deadline[i];
            arr[i][1] = profit[i];
        }

        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> b - a);

        int i = 0;
        int totalProfit = 0;
        int jobs = 0;

        int currDeadline = arr[0][0];

        while (i < n) {

            while (i < n && arr[i][0] == currDeadline) {
                pq.add(arr[i][1]);
                i++;
            }

            int nextDeadline = 0;

            if (i < n)
                nextDeadline = arr[i][0];

            int slots = currDeadline - nextDeadline;

            while (slots > 0 && !pq.isEmpty()) {
                totalProfit += pq.poll();
                jobs++;
                slots--;
            }

            currDeadline = nextDeadline;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(jobs);
        ans.add(totalProfit);

        return ans;
    }
}