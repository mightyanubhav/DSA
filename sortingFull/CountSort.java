package sortingFull;

public class CountSort
{
	public int[] countSort(int arr[], int min, int max)
	{
		int range = max - min +1;
		int freqArr[] = new int[range];
		
		for(int i = 0 ; i<arr.length; i++)
		{
			int idx = arr[i]-min;
			freqArr[idx]++;
			
		}
		for(int i = 1; i<freqArr.length ; i++)
			freqArr[i]=freqArr[i] + freqArr[i-1];
		
		int ans[] = new int[arr.length];
		for(int i = arr.length-1 ; i>=0 ;i--)
		{
			int val = arr[i];
			int pos = freqArr[val-min];
			int idx = pos -1; 
			ans[idx] = val;
			freqArr[val - min]--;
		}
			
		return ans;
	}
}
