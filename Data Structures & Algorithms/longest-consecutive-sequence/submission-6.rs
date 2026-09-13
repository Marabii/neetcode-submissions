impl Solution {
pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
    let set: HashSet<i32> = nums.into_iter().collect();

    let mut starts = Vec::new();
    set.iter().for_each(|num| {
        if !set.contains(&((*num) - 1)) {
            starts.push(*num);
        }
    });

    let mut longest = 0;

    for start in starts {
        let mut length = 0;
        let mut curr = start;

        while set.contains(&curr) {
            length += 1;
            curr += 1;
        }

        if length > longest {
            longest = length;
        }
    }

    longest
}
}


