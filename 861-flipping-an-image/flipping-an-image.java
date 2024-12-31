class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        // fliping the image 
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length / 2; j++) {
                int end = image[0].length-1-j;
                int temp = image[i][j];
                image[i][j] = image[i][end];
                image[i][end] = temp;
            }
        }

        // inverting the image
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] == 0) {
                    image[i][j] = 1;
                } else{
                    image[i][j] = 0;
                }
            }
        }

        return image;
    }

    public void swap(int a, int b) {
        int temp; 
        temp = a;
        a = b;
        b = temp;
        return;
    }
}