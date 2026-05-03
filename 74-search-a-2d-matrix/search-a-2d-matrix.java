class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int column = matrix[0].length-1;
        int i = 0;
        while (i < matrix.length) {
            if (matrix[i][column] < target) {
                i++;
            } else {
                if (matrix[i][column] == target) {
                    return true;
                } else {
                    return binarySearch(matrix, target, i);
                }
            }
        }

        return false;
    }

    public boolean binarySearch(int[][] matrix, int target, int row) {
        int colStart = 0;
        int colEnd = matrix[row].length;

        while (colStart <= colEnd) {
            int mid = (colStart + colEnd) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                colEnd = mid-1;
            } else {
                colStart = mid+1;
            }
        }

        return false;
    }
}