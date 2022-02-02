class Solution{

    
    // arr: input array
    // n: size of the array
    //Function to sort the array into a wave-like array.
    public static void convertToWave(int arr[], int n)
    {
        for(int i = 0 ; i<n ; i++)
        {
            if(i%2!=0)
            {
                int temp = arr[i];
                arr[i]=arr[i-1];
                arr[i-1]=temp ; 
            }
        }
        
    }
    
}
