class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int biggestPile = max(piles);

        int left = 0;
        int right = biggestPile;
        int bestSoFar = biggestPile;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (middle > 0 && canEatAllWithin(piles, middle, h)) {
                bestSoFar = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return bestSoFar;
    }

    private boolean canEatAllWithin(int[] piles, int k, int h) {
        int totalHours = 0;
        for (int pile : piles) {
            int result = pile / k;
            int remainder = pile % k;
                if (totalHours > h)
                return false;
            totalHours += result;
            if (remainder != 0) {
                totalHours += 1;
            }
        }

        return totalHours <= h;
    }

    private int max(int[] ints) {
        int maximum = Integer.MIN_VALUE;
        for (int i : ints) {
            if (i >= maximum) {
                maximum = i;
            }
        }

        return maximum;
    }
}
