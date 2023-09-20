import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainSolution {
    public static void main(String[] args) {
        int result = new Solution001().sumIndicesWithKSetBits(Arrays.asList(4,3,2,1), 2);
        System.out.println(result);
    }
}

class Solution001 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (getSetBits(i) == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }

    public int getSetBits(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num-1);
            count++;
        }
        return count;
    }
}
