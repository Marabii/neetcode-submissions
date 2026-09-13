class Solution {
    public static int minEatingSpeed(int[] piles, int h) {
        // find maximum:
        int max = -1;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }

        // binary search on [1, max]
        int left = 1;
        int right = max;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int timeToEatPiles = countNumberOfHours(piles, middle);
            if (timeToEatPiles > h) {
                left = middle + 1;
            }

            else {
                if (countNumberOfHours(piles, middle - 1) > h)
                    return middle;
                else {
                    right = middle - 1;
                }
            }

        }


        return max;
    }

    private static int countNumberOfHours(int[] piles, int k) {
        int result = 0;
        for (int pile : piles) {
            double pileD = (double) pile;
            double kD = (double) k;
            result += Math.ceil(pileD / kD);
        }

        return result;
    }

}
