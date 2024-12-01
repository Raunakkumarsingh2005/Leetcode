class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) { 
            return image;
        }

        int row = image.length;
        int col = image[0].length;

        // copying the original value of first cell
        int original = image[sr][sc];

        //creating a stack of integer type
        Stack<int[]> stack = new Stack<>();

        // push the give cell to stack
        stack.push(new int[]{sr,sc});

        // direction array to visit neighbouring cells
        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!stack.isEmpty()){
            int[] coordinates = stack.pop();
            int r = coordinates[0];
            int c = coordinates[1];
            image[r][c] = color;
            
            //updates the row and column to reach the neighbouring cells
            for (int[] d : direction) {
                int r1 = r + d[0];
                int c1 = c + d[1];

                if (r1 >= 0 && r1 < row && c1 >= 0 && c1 < col && image[r1][c1] == original) {
                    stack.push(new int[] {r1,c1});
                }
            }
        }

        return image;
    }
}