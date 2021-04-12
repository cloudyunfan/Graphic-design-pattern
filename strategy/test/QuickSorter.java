public class QuickSorter implements Sorter {
	public void sort(Comparable[] data) {
		quickSort(data, 0, data.length - 1);
	}
	private void quickSort(Comparable[] data, int startIndex, int endIndex) {
		// 递归结束条件
		if (startIndex >= endIndex) {
			return;
		}
		// 得到基准元素位置
		int pivotIndex = partition(data, startIndex, endIndex);
		// 根据基准元素分成两部份递归
		quickSort(data, startIndex, pivotIndex - 1);
		quickSort(data, pivotIndex + 1, endIndex);
	}
	private int partition(Comparable[] data, int startIndex, int endIndex) {
		int left = startIndex;
		int right = endIndex;
		// 取第一个位置的元素作为基准元素
		Comparable pivot = data[startIndex];
		while (left < right) {
			// right指针比较后往左移动
			while (right > left && data[right].compareTo(pivot) > 0) {
				right--;
			}
			// left指针比较后往右移动
			while (left < right && data[left].compareTo(pivot) <= 0) {
				left++;
			}
			// 交换两个元素
			if (left < right) {
				Comparable temp = data[right];
				data[right] = data[left];
				data[left] = temp;
			}
		}
		// pivot和指针重合点交换
		data[startIndex] = data[left];
		data[left] = pivot;
		return left;
	}
}