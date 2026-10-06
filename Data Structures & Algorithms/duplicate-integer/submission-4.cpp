class Solution {
public:
    bool hasDuplicate(std::vector<int> &nums)
    {
        std::unordered_set<int> mySet = {};

        for (int num : nums)
        {
            if (mySet.contains(num))
            {
                return true;
            }

            mySet.insert(num);
        }

        return false;
    }
};