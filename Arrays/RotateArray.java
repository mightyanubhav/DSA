import oracle.jrockit.jfr.parser.FLRProducer;

class Solution
{
    static void rotateArr(int arr[] , int d , int n)
    {
        int temp[] = new int[d];
        int i = 0 ;
        for(i = 0 ; i<d ; i++)
        {
            temp[i]=arr[i];
        }
        for( ; i<n ; i++)
        {
            arr[i-d]=arr[i];
        }
        int j =0;
        for(i=n-d; i<n ; i++)
        {
            arr[i]=temp[j];
            j++;
        }
    }
}
