class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        return merge_sort(nums, 0, nums.length-1);
    }

    public int[] merge_sort(int[] nums, int L, int R){
        if(L == R){
            return new int[]{nums[L]};
        }
        int mid = (L + R) / 2;
        int[] left = merge_sort(nums, L, mid);
        int[] right = merge_sort(nums, mid+1, R);
        return merge(left, right);

    }

    public int[] merge(int[] num_A, int[] num_B){
        int n1 = num_A.length, n2 = num_B.length;
        int[] num_M = new int[n1+n2];
        int i=0, j=0, idx=0;
        while(i < n1 && j < n2){
            if(num_A[i] < num_B[j]){
                num_M[idx] = num_A[i];
                idx++;
                i++;
            }else{
                num_M[idx] = num_B[j];
                idx++;
                j++;
            }
        }
        while(i < n1){
            num_M[idx++] = num_A[i++];
        }
        while(j < n2){
            num_M[idx++] = num_B[j++];
        }
        return num_M;
    }
}