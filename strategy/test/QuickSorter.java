public class QuickSorter implements Sorter {
	public void sort(Comparable[] data) {
		quickSort(data, 0, data.length - 1);
	}
	private void quickSort(Comparable[] data, int startIndex, int endIndex) {
		// �ݹ��������
		if (startIndex >= endIndex) {
			return;
		}
		// �õ���׼Ԫ��λ��
		int pivotIndex = partition(data, startIndex, endIndex);
		// ���ݻ�׼Ԫ�طֳ������ݵݹ�
		quickSort(data, startIndex, pivotIndex - 1);
		quickSort(data, pivotIndex + 1, endIndex);
	}
	private int partition(Comparable[] data, int startIndex, int endIndex) {
		int left = startIndex;
		int right = endIndex;
		// ȡ��һ��λ�õ�Ԫ����Ϊ��׼Ԫ��
		Comparable pivot = data[startIndex];
		while (left < right) {
			// rightָ��ȽϺ������ƶ�
			while (right > left && data[right].compareTo(pivot) > 0) {
				right--;
			}
			// leftָ��ȽϺ������ƶ�
			while (left < right && data[left].compareTo(pivot) <= 0) {
				left++;
			}
			// ��������Ԫ��
			if (left < right) {
				Comparable temp = data[right];
				data[right] = data[left];
				data[left] = temp;
			}
		}
		// pivot��ָ���غϵ㽻��
		data[startIndex] = data[left];
		data[left] = pivot;
		return left;
	}
}