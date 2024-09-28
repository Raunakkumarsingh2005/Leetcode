class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do{
            slow = squareDigits(slow);
            fast = squareDigits(squareDigits(fast));

            if (slow == 1 || fast == 1){
                return true;
            }
        } while (slow != fast);
        return false;
    }

    static int squareDigits(int n){
        int rem,sum = 0;
        while (n > 0){
            rem = n % 10;
            sum = sum + rem*rem;
            n = n / 10;
        }
        return sum;
    }
}