class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        frequencies_all = dict()
        result = []

        def getHash(string):
            hash_result = ""
            frequencies = dict()
            for char in string:
                frequencies[char] = frequencies.get(char, 0) + 1
            for key in sorted(list(frequencies.keys())):
                hash_result += key + str(frequencies[key])
            
            return hash_result

        for el in strs:
            hash_result = getHash(el)
            if hash_result in frequencies_all:
                result[frequencies_all.get(hash_result)] += [el]
            else:
                frequencies_all[hash_result] = len(result)
                result += [[el]]

        return result

