import java.io.IOException;

public class Program {	
	
	public static void main(String[] args) throws IOException {
//		FibonacciIterative(6);
//		int fib = FibonacciRecursive(6);
//		System.out.println(fib);
		
		Sorts sorts = new Sorts();
		sorts.BubbleSort(new int[]{ 9, 7, 4, 1, 2, 6, 5, 3, 8 });
		sorts.SelectionSort(new int[]{ 9, 7, 4, 1, 2, 6, 5, 3, 8 });
		sorts.InsertionSort(new int[]{ 9, 7, 4, 1, 2, 6, 5, 3, 8 });
		sorts.MergeSort(new int[]{ 9, 7, 4, 1, 2, 6, 5, 3, 8 });
		sorts.QuickSort(new int[]{ 9, 7, 4, 1, 2, 6, 5, 3, 8 });
		sorts.HeapSort(new int[]{ 9, 7, 4, 1, 2, 6, 5, 3, 8 });
		sorts.RadixSort(new int[]{ 9, 7, 4, 1, 2, 6, 5, 3, 8 });
		sorts.BucketSort(new float[]{ .9f, .7f, .4f, .1f, .2f, .6f, .5f, .3f, .8f, .82f });
		sorts.ShellSort(new int[]{ 9, 7, 4, 1, 2, 6, 5, 3, 8 });
		sorts.CombSort(new int[]{ 9, 7, 4, 1, 2, 6, 5, 3, 8 });
		sorts.PigeonholeSort(new int[]{ 9, 7, 4, 1, 2, 6, 5, 3, 8 });
		
//		Search search = new Search();
//		int[] sorted = {1,2,3,4,5,6,7,8,9};
//		int foundAt = search.BinarySearch(sorted, 10);		
//		System.out.println(foundAt);
		
		// Pseudo Pause...
		int in = System.in.read();
	}
	
	//START FIBONACCI METHODS
	
	public static void FibonacciIterative(int value){
		int low = 0;
		int hi = 1;
		
		System.out.print(low + " ");
		
		while(value > 0){
			System.out.print(hi + " ");
			hi = low + hi;
			low = hi - low;
			value--;
		}
		
		System.out.println();
	}
	
	public static int FibonacciRecursive(int value){
		if(value == 0) return 0;
		if(value == 1) return 1;
		
		return FibonacciRecursive(value-1) + FibonacciRecursive(value-2);
	}
	
	//END FIBONACCI METHODS

}
