class Solution {
    static int count = 0;

    static void merge(int arr[], int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // 🔥 KEY LINE
                count += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= end) temp[k++] = arr[j++];

        for (int t = 0; t < temp.length; t++) {
            arr[start + t] = temp[t];
        }
    }

    static void mergeSort(int arr[], int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    static int inversionCount(int arr[]) {
        count = 0; // reset
        mergeSort(arr, 0, arr.length - 1);
        return count;
    }
}