package newPackRevision;

import java.util.Arrays;
import java.util.InputMismatchException;

public class RevisionOnePointO {

	public static int noOfDigitsInANumber(long num)
	{
		return (int)Math.floor(Math.log10(num)+1);
	}
	public static int fact(int n)
	{
		if(n<=0)
			return 1;
		else 
			return n*fact(n-1);
	}
	public static int trailingZero( int n)
	{
		int sum = 0;
		for(int i= 5 ;i<=n ;i=i*5)
		{
			sum = (sum+(n/i));			
		}
		return sum;
	}
	public static int findGCD(int a, int b)
	{
		if(b==0)
			return a;
		return findGCD(b,a%b);
	}
	public static void PrimeFactors(int n)
	{
		if(n<=1)
			return ;
		while(n%2==0)
		{
			System.out.println(2);
			n=n/2;
		}
		while(n%3==0) {
			System.out.println(3);
			n=n/3;
		}
			
		
		for(int i = 5 ; i*i<=n ; i+=6)
		{
			while(n%i==0) {
				System.out.println(i);
				n=n/i;
			}
				
			while(n%(i+2)==0) {
				
				System.out.println(i+2);
				n=n/(i+2);
			}
				
		}
		if(n>3)
			System.out.println(n);
	}
	public static boolean[] sieveOfEratoSthenes(int n)
	{
		boolean arr[] = new boolean[n+1];
		Arrays.fill(arr, true);
		for(int i = 2 ;i<arr.length ;i++) {
			
			for(int j = i*i; j<arr.length; j+=i)
				if(arr[j])
					arr[j]= false;
			
			
		}
		return arr;
			
		
	}
	public static int power(int n , int x)
	{
		if(x == 0)
			return 1;
		
		
		int value = power(n,x/2);
		value = value*value;
		
		if(x%2 == 0)
			return value;
		else
			return value*n;
	}
	int getInt()
	{
		java.util.Scanner in = new java.util.Scanner(System.in);
		while(true) {
			try {
				return in.nextInt();
			}
			catch(InputMismatchException e)
			{
				in.next();
				System.out.println("That is not a number !! plese tyr again: ");
				
			}
		}
	}
//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
	
	public static boolean checkKthBitIsSet(int n, int x)
	{
		if(((n>>x-1)&1)== 1)
			return true;
		else
			return false;
		
			
	}
	public static int numberOfSetBits(int n)
	{
		int count=0;
		while(n!=0)
		{
			n=n&(n-1);
			count ++;
		}
		return count;
	}
	public static void findTwoOddNumberPresentInArray(int[] arr)
	{
		int xor = 0;
		int a = 0 ;
		int b = 0;
		for(int i = 0 ;i<arr.length; i++)
		{
			xor= xor^arr[i];
		}
		int S = xor& ~(xor-1);
		for(int i = 0 ;i<arr.length ;i++)
		{
			if((arr[i] & S) != 0)
				a = a^arr[i];
			else
				b=b^arr[i];
				
		}
		System.out.println(a);
		System.out.println(b);
	}
//----------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------- 
	public static boolean checkPalindrome(String st,int lo, int hi)
	{
		if(lo>=hi)
			return true;
		
		
		return checkPalindrome(st,lo+1,hi-1) && (st.charAt(lo)==st.charAt(hi));
		
		
	}
	public static boolean isPalindrome(String st , int start , int end)
	{
		if(start>=end)
			return true;
		return (st.charAt(start)==st.charAt(end) && isPalindrome(st, start+1,end-1));
	}
	public static void generatingSubset(String st, String curr, int i)
	{
		if(i==st.length())
		{
			System.out.println(curr);
			return ;
			
		}
		generatingSubset(st, curr, i+1);
		generatingSubset(st, curr+st.charAt(i),i+1);
		
		
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		int n= 12345678;
//		System.out.println(noOfDigitsInANumber(n));
//		System.out.println(fact(5));
//		System.out.println(trailingZero(5));
//		PrimeFactors(35);
//		System.out.println(findGCD(25 , 10));
		
//		boolean arr[] = sieveOfEratoSthenes(50);
//		for(int i = 0 ;i<arr.length; i++)
//			System.out.println(i + " " +arr[i]);
//		System.out.println(power(2,4));
//		System.out.println(checkKthBitIsSet(8,3));
//		findTwoOddNumberPresentInArray(new int[] {2,2,5,6,7,5,3,7});
		
//		System.out.println(checkPalindrome("MADAM", 0, 5-1));
		
//		generatingSubset("ABC","", 0);
		
		
		
		
	}

}
