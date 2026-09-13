class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        posAndSpeed = sorted([[position[i], speed[i]] for i in range(len(position))], key=lambda x: x[0])
        lastCar = posAndSpeed[-1]
        numberOfFleets = 1
        for i in range(len(posAndSpeed) - 2 , -1, -1):
            car = posAndSpeed[i]
            lastCarTime = (target - lastCar[0])/lastCar[1]
            carTime = (target - car[0])/car[1]

            if carTime > lastCarTime:
                numberOfFleets += 1
                lastCar = car

        return numberOfFleets

