class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];

        // updation of matrix
        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < indices[0].length; j++) {
                int index = indices[i][j];
                if (j == 0) {
                    for (int k = 0; k < arr[0].length; k++) {
                        arr[index][k] += 1;
                    }
                } if (j == 1) {
                    for (int k = 0; k < arr.length; k++) {
                        arr[k][index] += 1;
                    }
                }
            }
        }

        //calculating the no. of odd no's in matrix
        int odd = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] % 2 != 0) {
                    odd +=1;
                }
            }
        }

        return odd;
    }
}