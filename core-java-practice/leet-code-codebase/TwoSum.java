import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = {-1,-1};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n; i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
                ans[0] = map.get(rem);
                ans[1] = i;
                return ans;
            }
                map.put(nums[i], i);
        }
        return ans;
    }
	public static void main(String[] args) {
		int [] nums = {2, 7, 11, 15};
		TwoSum t = new TwoSum();
		System.out.println(Arrays.toString(t.twoSum(nums, 9)));
	}
}
