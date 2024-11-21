package leetcode.lmy.com.数学问题.用Rand7实现Rand10_470;

import java.util.Random;

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution{
    public int rand10() {
        while (true) {
            int res = (rand7() - 1) * 7 + (rand7() - 1) * 1;
            //进制转换均匀映射到0-48
            if (res >= 1 && res <= 40)
                return res % 10 + 1;
        }

    }

    private int rand7() {
        Random random = new Random();
        return random.nextInt(8);
    }
}
