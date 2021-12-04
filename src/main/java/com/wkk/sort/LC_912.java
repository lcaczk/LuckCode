package com.wkk.sort;

/**
 * @author weikunkun
 * @since 2021/7/6
 */
public class LC_912 {
    int n;
    public int[] sortArray(int[] nums) {
        this.n = nums.length;
        // insertSort(nums);
        // selectSort(nums);
        // quickSort(nums);
        // mergerSort(nums);
        counterSort(nums);
        // TODO heapSort
        return nums;
    }

    // 计数排序
    private void counterSort(int[] nums) {
        int[] arr = new int[100001];
        for (int num : nums) {
            arr[num + 50000] += 1;
        }
        int idx = 0;
        for (int i = 0; i < 100001; i++) {
            if (arr[i] == 0) { // 无元素
                continue;
            }
            int innerNum = arr[i];
            while(innerNum > 0) {
                nums[idx++] = i - 50000;
                innerNum--;
            }
        }
    }

    // 归并排序
    private void mergerSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] tmp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        for (i = 0, j = left; j <= right; j++, i++) {
            nums[j] = tmp[i];
        }
    }

    // 快速排序
    private void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int pos = patition(nums, left, right);
        quickSort(nums, left , pos - 1);
        quickSort(nums, pos + 1, right);
    }

    private int patition(int[] nums, int left, int right) {
        int cur = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= cur) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= cur) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = cur;
        return left;
    }

    private void insertSort(int[] nums) {
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int cur = nums[i];
            while (j >= 0 && nums[j] >= cur) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = cur;
        }
    }

    private void selectSort(int[] nums) {
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            int j = i + 1;
            while (j < n) {
                minIdx = nums[j] < nums[minIdx] ? j : minIdx;
                j++;
            }
            int tmp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = tmp;
        }
    }
}
