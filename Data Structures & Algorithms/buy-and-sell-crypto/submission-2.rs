impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
    let mut p1 = 0;
    let mut p2 = 0;
    let mut curr_max = 0;

    while p2 < prices.len() {
        let diff = prices[p2] - prices[p1];

        if diff > curr_max {
            curr_max = diff;
        }
        
        if diff >= 0 {
            p2 += 1;
        } else {
            p1 += 1;
        }
    }

    curr_max
}
}
