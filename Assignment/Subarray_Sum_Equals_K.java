import java.util.*;

public class Subarray_Sum_Equals_K {
    static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixFrequency = new HashMap<>();
        prefixFrequency.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            count += prefixFrequency.getOrDefault(prefixSum - k, 0);
            prefixFrequency.put(prefixSum,
                    prefixFrequency.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println(subarraySum(nums, k));
        sc.close();
    }
}