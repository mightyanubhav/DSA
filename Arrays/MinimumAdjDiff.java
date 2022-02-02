class Solution{
    
    //Function to find minimum adjacent difference in a circular array.
    // arr[]: input array
    // n: size of array
    public static int minAdjDiff(int arr[], int n) 
    {
        
        // Your code here
        int sub =0;
        int min =1000000000;
        for(int i = 0 ; i<n-1 ; i++)
        {
          
            sub= Math.abs(arr[i]-arr[i+1]);

            if(sub<min)
            min = sub;         
        }
        sub= Math.abs(arr[n-1]-arr[0]);
        if(sub<min)
        min=sub;

        return min;    
    }
}
