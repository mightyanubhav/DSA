package sortingFull;

public class HeapSort
{
	public static int[] sort(int[] arr)
	{
		int n = arr.length;
		
		for(int i = n/2-1; i>=0 ; i-- )
		{
			heapify(arr,n ,i);
		}		
		
		for(int i = n-1 ; i>=0 ; i--)
		{
			int temp = arr[0];
			arr[0] =arr[i];
			arr[i] = temp;
			
			heapify(arr,i,0);
		}
		return arr;
		
		
	}
	public  static void heapify(int arr[], int n , int i)
	{
		int large = i;
		int lc = 2*i+1;
		int rc = 2*i+2;
		
		if(lc<n && arr[lc]>arr[large])
			large = lc;
		if(rc<n && arr[rc]>arr[large])
			large = rc;
		
		if(large != i)
		{
			int temp = arr[large];
			arr[large]=arr[i];             
			arr[i]=temp;
			
			heapify(arr, n, large);
		}
		
		
	}
	
}
