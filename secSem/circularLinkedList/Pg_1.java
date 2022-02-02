package circularLinkedList;

import java.util.InputMismatchException;
class Node
{
	int info;
	Node link;			
}
public class Pg_1
{
	static java.util.Scanner in = new java.util.Scanner (System.in);
	static Node last;
		
	public static Node  create(Node start)
	{
		Node ob = new Node();
		System.out.println("The node has been created.");
		System.out.print("Enter the value of the node ");
		ob.info = getAnInteger();
		ob.link = ob;
		
		start = ob;
		last = ob;
		
		char ch;
		System.out.println();
		System.out.print("Do you want new node(y/n) : ");
		ch = in.next().charAt(0);
		
		while(ch == 'y' || ch =='Y')
		{
			addAtEnd(start);
			System.out.println();
			System.out.print("Do you want new node(y/n) : ");
			ch = in.next().charAt(0);
			
		}
		
		return start;
	}
	public static void addAtEnd(Node start)
	{
		Node obj = new Node();
		System.out.print("Enter the value for the information:");
		obj.info = getAnInteger();
		
		if(start == null)
		{
			start = last = obj;
			last.link = start;
		}
		else
		{									
			last.link=obj;
			last =obj;
			last.link=start;
		}
	}
	public static void traverse(Node start)
	{
		Node t = start;
		if(t == null)
		{
			System.out.println("Empty list.");
			return;
		}
		else
		{
			System.out.println("  ____________________________________________________");
			System.out.println("||-----------------------OUTPUT-----------------------||");
			System.out.println();
			
			while(t.link != start)
			{
				System.out.print("\t"+t.info+" --> ");
				t = t.link;
			}
			System.out.print(t.info);
			System.out.println();
			
		}
		
	}
	public static Node addAtBeg(Node start)
	{
		Node ob = new Node ();
		System.out.print("Enter the value to the info:");
		ob.info= getAnInteger();
		if(start == null)
		{
			start = last = ob;
		}
		else
		{
			ob.link=start;
			start = ob;
			last.link=start;
		}
		
		return start;
	}
	public static Node delAtBeg(Node start)
	{
		if(start == null)
		{
			System.out.println("Empty linked list.");
			return start;
		}
		else
		{
			
			start = start.link;
			last.link = start;
			
			System.out.println("The first element is deleted.");
			return start;
		}
	}
	public static void delAtEnd(Node start)
	{
		if(start == null)
		{
			System.out.println("The list is empty.");
			return;
		}
		else
		{
			Node t = start;
			Node prev = null;
			while(t.link!= start)
			{
				prev = t;
				t = t.link;
			}
			
			prev.link = start;
			System.out.println("The last element deleted.");
		}
	}
	public static void addAtPos(Node start)
	{
		if(start == null)
		{
			System.out.println("Empty list .");
			return;
		}
		else
		{
			System.out.println("Enter the position.");
			int pos = getAnInteger();
			
			int c = 1;			
			Node t = start;
			
			while(t.link != start && c < pos)
			{				
				t = t .link;
				c++;
			}
			
			if(t.link == start)
				System.out.println("The list do not have that position.");
			else
			{
				Node obj = new Node();
				System.out.print("Enter the info : ");
				obj.info = in.nextInt();
				
				obj.link = t.link;
				t.link = obj;				
			}
				
		}
	}
	public static Node delAtPos(Node start)
	{

		if(start == null)
		{
			System.out.println("The list is empty.");
			return start;
		}
		else
		{
			System.out.print("Enter the position : ");
			int pos = getAnInteger();
			int c = 1;
			Node prev = null;
			Node t = start;
			while(t.link != start && c < pos)
			{		
				prev = t;
				t = t .link;
				c++;
			}
			
			if(t == start)
				System.out.println("The list do not have that position.");
			else
			{
				if(pos == 1)
				{
					start = delAtBeg(start);
					return start;
				}
				else if(pos == c-1)
				{
					delAtEnd(start);
				}
				else
				{
					prev.link=t.link;
					t.link = null;										
				}				
			}						
		}
		return start;
				
	}
	public static void search(Node start)
	{
		boolean flag = false;
		
		System.out.print("Enter the data to be searched : ");
		int key = getAnInteger();
		while(start.link != start)
		{
			if(start.info==key)
			{
				flag =true;
				break;
			}
			start=start.link;
		}
		if(flag == true )
			System.out.println("The data is present in the list ");
		else
			System.out.println("The key is not there .");
		
	}
	
	public static void sort(Node start)
	{
		for(Node i= start.link ; i.link != start ; i=i.link)
		{
			for(Node j= i.link ;j != start ; j=j.link)
			{
				if(j.info < i.info)
				{
					int t=i.info;										
					i.info=j.info;										
					j.info=t;
					
				}
			}
		}
		System.out.println("The list has been sorted according to info .");
	}
	
	
	
	public static void main(String args[])
	{
		Node start = null;
		System.out.println("\t\tCircular linked list program for integer information.\n");
				
				
		while(true)
		{
			System.out.println("\t\t\t\t  ||MENU||    ");
			System.out.println();
			System.out.println("1.Creation \t\t 2.Insert at end \t\t 3.Insert at beginning.");
			System.out.println("4.Insert at position\t 5.Delete at beginning \t\t 6.Delete at position");
			System.out.println("7.Delete at end \t 8.Display the list \t\t 9.Sort List.");
			System.out.println("10.Search the list \t 0.Exit Program.");
			System.out.print("Enter your choice :");
			switch(getAnInteger())
			{
			case 0:
				System.out.println("The program has been terminated.");
				System.exit(0);
			case 1:
				start = create(start);
				System.out.println("The node has been created.");
				break;
			case 2:
				addAtEnd(start);
				break;
			case 3:
				start=addAtBeg(start);
				break;
			case 4:
				addAtPos(start);
				break;
			case 5:
				start = delAtBeg(start);
				break;
			case 6:
				start = delAtPos(start);
				break;
			case 7:
				delAtEnd(start);
				break;
			case 8:
				traverse(start);
				break;
			case 9:
				sort(start);
				break;
			case 10:
				search(start);
				break;
			
			default:
				System.out.println("The input doesn't match...");			
			}
			System.out.println("\n");
			
		}
		
	}
	public static int getAnInteger()
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
				System.out.print("Not an integer!! Input again : ");				
			}
		}
	}
	
}
