package sortingFull;

public class InsertionSort
{
	public int[] insSort(int[] arr)
	{
		for(int i = 1 ; i<arr.length; i++)
		{
			for(int j = i-1; j>=0 ;j--)
			{
				if(arr[j+1]<arr[j])
				{
					int temp = arr[j+1];
					arr[j+1] = 	arr[j];
					arr[j]= temp;
							
				}
			}
		}
		
		return arr;
		
	}
}
