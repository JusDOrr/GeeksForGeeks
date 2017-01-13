
public class GeeksForGeeksQuestions {
	// First thought - Could use Binary Search to find first and last
	// Occurrence of 'out-of-order' element. Return difference in locations.. (WRONG?)
	
	// Second thought - "Linear Search" for first out of place from left, then right, and
	// see if sorting that sub-array creates a sorted array...
	public int MinimumLengthUnsortedSubArray(int[] arr){
		//{ 10 20 50 40 30 60 70 80 } - @2-4
		int n = arr.length, i;
		
		//Find first
		for(i = 1; i < n; i++){
			if(arr[i] < arr[i-1])
		}
		
		return 0;
	}
	
}
