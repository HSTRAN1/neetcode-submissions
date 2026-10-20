class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int maxPile = piles[0];
    
       for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
       }

       int left = 1;
       int right = maxPile;

        while (left <= right) {
            int speed = left + (right - left)/2;
            long hours = 0;

            for (int pile : piles)
            {
                hours += (pile - 1)/speed + 1;
            }
            if (hours <= h) {
                right = speed - 1;
            }
            else {
                left = speed + 1;
            }
        }
        return left;


    }
}
