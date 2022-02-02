package stackArrayImplimentation;
import java.util.InputMismatchException;

public class StackArr
{
	java.util.Scanner in = new java.util.Scanner(System.in);
	
	int size ,top = -1;
	int[] arr;
	public  void createStk()
	{
		System.out.print("Enter the size of the Stack : ");
		size = getAnInteger();		
	    arr= new int[size];	
	    System.out.println("Stack Created.");
	   
	}
	public boolean isEmpty()
	{
		if(top<0)
		    return true;
		else
			return false;
	}
	public boolean isFull()
	{
		if(top>=size-1)
			return true;
		else
			return false;
	}
	public void pushAnItem()
	{
		if(isFull())
		{
			System.out.println("The stack is full .");
			return;
		}
		else
		{
			top = top +1;
			System.out.print("Enter the value you want to enter .");
			arr[top]= getAnInteger();			
		}
	}
	public void pop()
	{
		if(isEmpty())
		{
			System.out.println("The stack is empty .");
			return;
		}
		else
		{
			System.out.println("The popped item is "+arr[top]);
			top=top-1;
		}
	}
	public void traverse()
	{
		if(top<0)
		{
			System.out.println("empty stack .");
			return;
		}
		else
		{
			System.out.println("\nThe elements in the stack are : \n");
			
			for(int i=top ; i >= 0;i--)
				System.out.print(" | "+arr[i]+" | ");
			
			System.out.println("\n");
		}
	}
	public static void main(String[] args)
	{
		StackArr obj = new StackArr();
		System.out.println("Array implimentation of Stack .");
		int choice=0; 
		
		do
		{
			System.out.println("\n\t||MENU||\n\n");
			System.out.println("1.Creation .");
			System.out.println("2.Traverse current info.");
			System.out.println("3.Pop an elment.");
			System.out.println("4.Push an element .");			
			System.out.println("5.Exit .");
			System.out.print("Enter your choice : ");
			choice = obj.getAnInteger();
			
			switch(choice)
			{
			case 1:
				obj.createStk();
				break;
			case 2:
				obj.traverse();
				break;
			case 3:
				obj.pop();
				break;
			case 4:
				obj.pushAnItem();
				break;
			case 5:
				System.out.println("You have sucessfully exit the program.");
				System.exit(0);
				
			default:
				System.out.println("The information is not relevent .Enter again.");
			}
		}
		while(true);		
		
	}
	
	public int getAnInteger()
	{
		while(true)
		{
			try
			{
				return in.nextInt();
			}
			catch(InputMismatchException e)
			{
				in.next();
				System.out.println();
				System.out.println("Input type is not integer !!! give an integer .");				
			}
		}
		
	}
	
}
