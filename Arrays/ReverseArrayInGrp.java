import java.util.ArrayList;
class Solution
 {
    //Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k)
    {
       
       for(int i = 0 ; i<n ; i+=k)
       {
          int left = i;
           int right = Math.min(i+k-1, n-1);
           int temp ;
           
           
           int lc, rc;
           
           while(left<right)
           {
              temp = arr.get(left);
              lc=arr.get(right);
              rc = temp;
               
              arr.set(left,lc);
              arr.set(right,rc);
               left++;
               right--;
           }
       }
       
      
    }
}

