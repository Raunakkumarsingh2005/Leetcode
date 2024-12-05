class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            boolean alive = true; 
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                if (stack.peek() < -1*a) {
                    stack.pop();
                    continue;
                }

                else if (stack.peek() == -1*a) {
                    stack.pop();
                }
                alive = false;
                break;

            }

            if (alive) {
                stack.push(a);
            }
        }

        int[] arr = new int[stack.size()];
        for (int i = 0 ; i < stack.size() ; i++) {
            arr[i] = stack.get(i);
        }
        
        return arr;
    }
}