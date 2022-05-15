package newPackRevision;
import java.util.*;

class solve
{
    //Function to find all possible unique subsets.
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        Arrays.sort(arr);
     ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
     subSets(arr, n, 0, new ArrayList<>(), ls);
     return ls;
   }

   static void subSets(int a[], int n, int start, ArrayList<Integer> as,  ArrayList<ArrayList<Integer>> ls) {


       if(!as.isEmpty() && !ls.contains(as))
         ls.add(as);


       for(int i=start; i<n; i++) {
           ArrayList<Integer> als = new ArrayList<>(as);
           als.add(a[i]);
           subSets(a, n, i+1, als, ls);
       }
    }
}

