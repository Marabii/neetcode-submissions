class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frequencies = dict()
        for el in nums:
            frequencies[el] = frequencies.get(el, 0) + 1

        def k_largest(frequencies, k):
            heap=[]
            for num in frequencies:
                if len(heap) < k:
                    heapq.heappush(heap, (frequencies[num], num))
                else:
                    if frequencies[num] > heap[0][0]:
                        heapq.heapreplace(heap, (frequencies[num], num))

            return heap

        heap = k_largest(frequencies, k)
        output = []
        while len(heap) != 0:
            frequency, num = heapq.heappop(heap)
            output += [num]

        return output
