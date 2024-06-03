package questions.n1103_distributeCandies;

public class Solution2 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        // 有多少人完整获得了一份礼物
        // 详见题解
        int p = (int) (Math.sqrt(2 * candies + 0.25) - 0.5);
        // 剩余糖果数
        int remain =(int) (candies - (1 + p) * p * 0.5);
        // 完整分发轮次
        int r = p / num_people;
        // 未完整分发轮次的剩余人数
        int col = p % num_people;
        for(int i = 0; i <ans.length;i++) {
            // 计算完整分发轮次中，每个人获得的礼物总数
            ans[i] = (i + 1) * r + (int) ((r - 1) * r * 0.5 * num_people);
            if (i < col) {
                ans[i] += i + 1 + r * num_people;
            }
        }
        ans[col] += remain;
        return ans;
    }
}
