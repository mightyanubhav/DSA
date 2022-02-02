package sortingFull;

public class QuickSort
{
	void quickSort(int[] arr, int lo, int hi)
	{
		if(lo>hi)
			return;
		int pivot = arr[hi];
		int pivotIndex = partition(arr, lo, hi, pivot);
		quickSort(arr, lo, pivotIndex-1);
		quickSort(arr,pivotIndex+1,hi);
				
	}
	public int partition(int[] arr,int lo, int hi, int pivot)
	{
		
		int i= lo, j = lo;
		while(i<=hi)
		{
			if(pivot>=arr[i])
			{
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				
				i++;
				j++;
			}
			else
			{
				i++;
			}
		}
		System.out.println("PivotIndex : "+(j-1));		
		return j-1;
	}
	
}
