package javatutorial;

class Solution {
	public static int jump(int[] nums) {
		int arraySize = nums.length;
		int lastIndex = arraySize - 1;
		if (lastIndex <= 0) {
			return 0;
		}
		int jumps = 0;
		for (int cur = 0; cur < arraySize;) {
			int maxJump = nums[cur];
			if (cur + maxJump >= lastIndex) {
				jumps++;
				break;
			}
			int newMax = 0;
			int newIndex = 0;
			for (int pos = cur; pos <= cur + maxJump; pos++) {
				if (pos >= arraySize) {
					break;
				}
				if (nums[pos] >= newMax) {
					newMax = nums[pos];
					newIndex = pos;
				}
			}

			cur = newIndex;
			jumps++;
		}
		return jumps;
	}

	public static void main(String[] args) {
//    	{2,3,1,1,4}, {2,0,2}, {0}, {1},{1,1,2,1,1},
//    	2, 1, 0, 0,3,
		int[][] array = {{2,3,1,1,4}, {2,0,2}, {0}, {1},{1,1,2,1,1}, { 1, 3, 2 }, { 1, 2, 3, 4, 5 }, { 2, 3, 0, 1, 4 } };
		int[] solutions = {2, 1, 0, 0,3, 2, 3, 2 };
		for (int i = 0; i < array.length; ++i) {
			int jumps = Solution.jump(array[i]);
			System.out.println(jumps);
			if (jumps != solutions[i]) {
				System.out.println("failed");
				break;
			}
		}
	}
}