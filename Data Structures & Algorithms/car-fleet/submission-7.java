class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>(position.length);
        for (int i = 0; i < position.length; i++) {
            double timeToReachDest = ((double) (target - position[i])) / ((double) speed[i]);
            cars.add(new Car(position[i], speed[i], timeToReachDest));
        }

        // Sort them based on their initial positions
        Collections.sort(cars);

        List<Double> stack = new ArrayList<>();
        stack.add(cars.getFirst().timeToReachDest);

        for (int i = 1; i < cars.size(); i++) {
            if (stack.getLast() < cars.get(i).timeToReachDest) {
                stack.add(cars.get(i).timeToReachDest);
            }
        }

        return stack.size();

    }

    private record Car(int initialPosition, int speed, double timeToReachDest) implements Comparable<Car> {
        @Override
        public int compareTo(Car other) {
            return Integer.compare(other.initialPosition, this.initialPosition);
        }
    }
}
