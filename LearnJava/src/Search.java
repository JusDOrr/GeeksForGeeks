
public class Search {
	
	// O(n)
	public int LinearSearch(int[] arr, int find){
		int n = arr.length;
		
		for(int i = 0; i < n; i++){
			if(arr[i] == find)
				return i;
		}
		
		return -1;
	}
	
	// O(Logn)
	public int BinarySearch(int[] arr, int find){
		int n = arr.length;

		int i = 0, j = n-1, m;
		while(i <= j){
			m = j+i/2;
			
			if(arr[m] == find)
				return m;
			
			if(arr[m] > find)
				j = m-1;
			else
				i = m+1;
		}
		
		return -1;
	}
	
	// O(_/n)
	public int JumpSearch(int[] arr, int find){
		int n = arr.length;
		
		int step = (int)Math.floor(Math.sqrt(n));
		
		int prev = 0;
		while(arr[Math.min(step, n) -1] < find){
			prev = step;
			step += (int)Math.floor(Math.sqrt(n));
			if(prev >= n)
				return -1;
		}
		
		while(arr[prev] < find){
			prev++;
			if(prev == Math.min(step, n))
				return -1;
		}
		
		if(arr[prev] == find)
			return prev;
		
		return -1;
	}
	
	// O(n) but as good as (LogLogn)
	public int InterpolationSearch(int[] arr, int find){
		int n = arr.length;
		
		int low = 0, high = (n-1);
		while(low <= high && find >= arr[low] && find <= arr[high]){
			// UNDERSTAND THIS NONSENSE
			int pos = low + (((high-low) / (arr[high] - arr[low])) * (find-arr[low]));
			
			if(arr[pos] == find)
				return pos;
			
			if(arr[pos] < find)
				low = pos+1;
			else
				high = pos - 1;
		}
		
		return -1;
	}
}
