import java.util.ArrayList;
import java.util.Iterator;

public class Sorts {
	
	// O(n^2); Best case O(n)
	// Called Bubble Sort because each iteration 'bubbles'
	// the max value to the top of the list
	public void BubbleSort(int[] arr){
		int n = arr.length;
		for(int i = 0; i < n - 1; i++){
			for(int j = 0; j<n-i-1; j++){
				if(arr[j] > arr[j+1])
					Swap(arr, j, j+1);
			}
		}
		
		Print("BubbleSort:", arr);
	}
	
	// O(n^2); Best case O(n)
	// Assumes the beginning of the list is sorted and 'inserts'
	// each value where it belongs in the sorted section
	public void InsertionSort(int[] arr){
		int index, n = arr.length;
		
		for(int i = 1; i < n; i++){
			index = i;
			for(int j = i; j >= 0; j--){
				if(arr[j] > arr[index] && index != j){
					Swap(arr, j, index);
					index--;
				}
			}
		}
		
		Print("InsertionSort:", arr);
	}
	
	// 0(n^2); Best case O(n)
	// 'Selects' the minimum value each pass and places it at
	// the beginning of the unsorted list...
	public void SelectionSort(int[] arr){
		int min, n = arr.length;	
		
		for(int i = 0; i < n-1; i++){
			min = i;
			for(int j = 1 + i; j < n; j++){
				if(arr[j] < arr[min])
					min = j;
			}
			Swap(arr, i, min);
		}
		
		Print("SelectionSort:", arr);
	}
	
	// O(nLogn)
	// Splits the list into 2 halves recursively, then re-assembles
	// in sorted order
	public void MergeSort(int[] arr){
		MergeSort(arr, 0, arr.length - 1);
		
		Print("MergeSort:", arr);
	}
	
	private void MergeSort(int[] arr, int l, int r){
		if(l < r){
			int m = (l+r)/2;
			
			MergeSort(arr, l, m);
			MergeSort(arr, m+1, r);
			
			Merge(arr, l, m, r);
		}
	}
	
	private void Merge(int[] arr, int l, int m, int r){
		int k, i, j;
		int ln = m - l + 1;
		int rn = r - m;
		
		int[] L = new int[ln];
		int[] R = new int[rn];
		
		for(i=0; i<ln; i++)
			L[i] = arr[l+i];
		for(j=0; j<rn; j++)
			R[j] = arr[m+j+1];		
		
		i = 0;
		j = 0;
		k = l;
		// Merge Left and Right until 1 is empty
		while(i < ln && j < rn){
			if(L[i] <= R[j]){
				arr[k] = L[i];
				i++;
			}
			else{
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		// Add remainder from left if there are any
		while(i < ln){		
			arr[k] = L[i];
			k++;
			i++;
		}
		
		// Add remainder from right if there are any
		while(j < rn){	
			arr[k] = R[j];
			k++;
			j++;
		}
	}
	
	// O(n^2); Average case of (nLogn)
	// Selects a partition value and places all values to their correct location
	// in relation to the partition. Does so recursively until the list is sorted.
	public void QuickSort(int[] arr){
		QuickSort(arr, 0, arr.length-1);
		
		Print("QuickSort:", arr);
	}
	
	private void QuickSort(int[] arr, int l, int r){
		if(l < r){
			int p = Partition(arr, l, r);
			
			QuickSort(arr, l, p - 1);
			QuickSort(arr, p + 1, r);
		}
	}
	
	private int Partition(int [] arr, int l, int r){
		int pivot = arr[r];
		int i = l-1;
		
		for(int j = l; j<=r-1; j++){
			if(arr[j] <= pivot)			
				Swap(arr, ++i, j);
		}
		
		Swap(arr, ++i, r);		
		return i;
	}
	
	// O(nLogn)
	// Build a Max Heap Tree and remove largest node, then
	// Re Heapify...
	public void HeapSort(int[] arr){
		int n = arr.length;
		
		// Find the largest
		for(int i = n/2; i >=0; i--)
			Heapify(arr, n, i);
		
		// Remove from the group and find it again
		for(int i = n-1; i>=0; i--){
			Swap(arr, 0, i);
			Heapify(arr, i, 0);
		}
		
		Print("HeapSort:", arr);
	}
	
	private void Heapify(int[] arr, int n, int index){
		int lChild = 2*index + 1;
		int rChild = 2*index + 2;
		int largest = index;
		
		if(lChild < n && arr[lChild] > arr[largest])
			largest = lChild;
		
		if(rChild < n && arr[rChild] > arr[largest])
			largest = rChild;
		
		if(largest != index){
			Swap(arr, index, largest);
			Heapify(arr, n, largest);
		}
	}
	
	// O(n + k)
	public void CountingSort(int[] arr, int exp){
		int[] output = new int[arr.length];
		int[] count = new int[10];
		int i;
		
		// Count the how often a place is found
		for(i = 0; i < arr.length; i++)
			count[(arr[i]%10)]++;
		
		// Add the count to the next element
		for(i = 1; i < 10; i++)
			count[i] += count[i-1];
		
		// From end to beginning, find the location of the output
		for(i = arr.length-1; i >= 0; i--){
			output[count[(arr[i]%10)]-1] = arr[i];
			count[(arr[i]%10)]--;
		}
		
		// Copy to original array
		for(i = 0; i < arr.length; i++)
			arr[i] = output[i];
	}
	
	// O(nk)
	// Sorts values by the integer places
	public void RadixSort(int[] arr){
		int max = Max(arr);
		
		for(int exp = 1; max/exp > 0; exp *= 10)
			CountingSort(arr, exp);
		
		Print("RadixSort:", arr);
	}
	
	private int Max(int[] arr){
		int max = arr[0];
		
		for(int i = 1; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
			}
		}
		
		return max;
	}
	
	// O(n) -- kinda
	public void BucketSort(float[] arr){
		int n = arr.length;
		int i = 0;
		
		ArrayList<ArrayList<Float>> b = new ArrayList<ArrayList<Float>>();
		for(i = 0; i < n; i++)
			b.add(new ArrayList<Float>());
		
		for(i = 0;i < n; i++){
			int bi = (int)(n * arr[i]);
			b.get(bi).add(arr[i]);
		}
		
		Iterator<ArrayList<Float>> itr = b.iterator();
		while(itr.hasNext()){
			ArrayList<Float> temp = (ArrayList<Float>) itr.next();			
			sort(temp);
		}
		
		int index = 0;
		for(i = 0; i < n; i++){
			for(int j = 0; j < b.get(i).size(); j++){
				arr[index++] = b.get(i).get(j);
			}
		}
		
		//Print Array
		System.out.print("BucketSort ");		
		for (float g : arr)
			System.out.print(g + " ");	
		System.out.println();
	}
	
	// Pseudo Insertion Sort
	private void sort(ArrayList<Float> arrList){
		int index, n = arrList.size();
				
		for(int i = 1; i < n; i++){
			index = i;
			for(int j = i; j >= 0; j--){
				if(arrList.get(j) > arrList.get(index) && index != j){
					float temp = arrList.get(j);
					arrList.set(j, arrList.get(i));
					arrList.set(i, temp);
					index--;
				}
			}
		}
	}
	
	// O(n^2)
	public void ShellSort(int[] arr){
		int n = arr.length;
		
		for(int gap = n/2; gap > 0; gap /= 2){
			for(int i = gap; i < n; i+= 1){
				int temp = arr[i], j;
				for(j = i; j>= gap && arr[j-gap] > temp; j-= gap)
					arr[j] = arr[j-gap];
				
				arr[j] = temp;
			}
		}
		
		Print("ShellSort:", arr);
	}
	
	// O(n^2)
	public void CombSort(int[] arr){
		int n = arr.length, gap = n;
		boolean swapped = true;
		
		while(gap > 1 || swapped == true){
			if(gap > 1)
				gap = (int)(gap/1.3);
			
			swapped = false;
			
			for(int i = 0; i+gap < n; i++){
				if(arr[i] > arr[i+gap]){
					Swap(arr, i , i+gap);
					swapped = true;
				}
			}
		}

		Print("CombSort:", arr);
	}
	
	// O(n + RANGE)
	public void PigeonholeSort(int[] arr){
		int n = arr.length;
		int min = arr[0], max = arr[0];
		for(int i = 1; i < n; i++){
			if(arr[i] < min)
				min = arr[i];
			if(arr[i] > max)
				max = arr[i];
		}
		int range = max-min + 1;
		
		ArrayList<ArrayList<Integer>> holes = new ArrayList<ArrayList<Integer>>(range);
		for(int i = 0; i < range; i++)
			holes.add(new ArrayList<Integer>());
		
		for(int i = 0; i < n; i++)
			holes.get(arr[i]-min).add(arr[i]);
		
		int index = 0;
		for(int i = 0; i < range; i++){
			Iterator<Integer> itr = holes.get(i).iterator();
			while(itr.hasNext()){
				int temp = (int)itr.next();
				arr[index++] = temp;
			}
		}

		Print("PigeonholeSort:", arr);
	}
	
	// O(1) - Constant Time
	// Swaps the values in the array
	private void Swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// O(n) - Linear
	// Prints each value of the array
	private void Print(String fName, int arr[]){
		System.out.print(fName + " ");
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println();
	}
}
