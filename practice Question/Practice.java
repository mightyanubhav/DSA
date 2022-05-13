package genericTrees;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

/*N = 5
Arr1 = {7, 4, 8, 0, 1}
Arr2 = {9, 7, 2, 3, 6}
Output: 9 7 6 4 8
Explanation: 9, 7, 6 are from 2nd array
and 4, 8 from 1st array.*/

/*Input: N = 4
Arr1 = {6, 7, 5, 3}
Arr2 = {5, 6, 2, 9} 
Output: 5 6 9 7 
Explanation: 5, 6, 9 are from 2nd array
and 7 from 1st array.*/


class Practice {
   
	
	// solution for java question on gfg
    ArrayList<Integer> maximizeArray(int[] arr1, int[] arr2, int n) {
        // code here
        Set<Integer> result = new LinkedHashSet<>();
        Integer[] allElem = new Integer[n*2];
        int c = 0 ;
        for(int i = 0 ;i<n ;i++)
        {
            allElem[c] = arr2[i];
            allElem[c+1]= arr1[i];
            c+=2;
        }
        Arrays.sort(allElem,Collections.reverseOrder());
        Set<Integer> set = new LinkedHashSet<>();
        for(Integer num : allElem )
         {
             set.add(num);
             if(set.size()==n)
             break;
         }
         
         for(int x : arr2)
         {
             if(set.contains(x))
             {
                 result.add(x);
                 set.remove(x);
             }
         }
         for(int x : arr1)
         {
             if(set.contains(x))
             result.add(x);
         }
         
         return new ArrayList<Integer>(result);
        
    }
}