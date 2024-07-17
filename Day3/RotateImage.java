// package CrackYourInternship.Matrix;

class Solution {
    public void rotateRow(int i, int n, int[][] matrix) {
        int j = 0;
        while(j < n / 2) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][n - j - 1];
            matrix[i][n - j - 1] = temp;
            j++;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0;i<n-1;i++) {
            for(int j = i + 1;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0;i<n;i++) {
            rotateRow(i, n, matrix);
        }
    }
}
