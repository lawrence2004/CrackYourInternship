package CrackYourInternship.Day8;

class Solution {
    public static int ceilSearch(int arr[], int x) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (x == arr[mid]) {
                return mid;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
