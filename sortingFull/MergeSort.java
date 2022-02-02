package sortingFull;

public class MergeSort 
{

	public int[] mergeSort(int []arr, int lo, int hi)
	{
		if(lo==hi)
		{
			int ba[] = new int[1];
			ba[0]=arr[lo];
			return ba;
		}
		int mid = (lo+hi)/2;
		
		int fh[] = mergeSort(arr,lo,mid);
		int sh[] = mergeSort(arr,mid+1,hi);		
		int merged[]= merger(fh,sh);
		
		return merged;
		
	}
	public int[] merger(int[] a, int[] b)
	{
		int arr[] = new int[a.length+b.length];
		int i=0 , j=0 , k=0;
		
		while(i<a.length && j<b.length)
		{
			if(a[i]<=b[j])
			{
				arr[k]=a[i];
				i++;
				k++;
			}
			else
			{
				arr[k]=b[j];
				j++;
				k++;
			}
		}
		while(i<a.length)
		{
			arr[k]=a[i];
			k++;
			i++;
		}
		while(j<b.length)
		{
			arr[k]=b[j];
			k++;
			j++;
		}
				
		return arr;
	}

}
