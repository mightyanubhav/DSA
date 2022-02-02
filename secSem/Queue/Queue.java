// Array implimentation of queue.

import java.util.Scanner;
public class Queue
{
	static int MAX = 5;
	static int front = -1;
	static int rear = -1 ;
	static char[] Q= new char [MAX];
	
	
	public static void main (String... args)
	{
		Scanner in = new Scanner (System.in);
		
		
		in.close();
	}
	
	public static void insertQ(char new_item)
	{
		if(rear >= MAX)
		{
			System.out.println("The queue is full.");
			return;
		}
		else if(rear < 0)
		{
			rear = 0;
			front = 0;
		}
		else
			rear = rear +1;	
		
		Q[rear]= new_item;
	}
	public static void deleteQ()
	{
		if(front < 0)
		{
			System.out.println("Empty queue.");
			return;
		}
		
		char temp = Q[front];
		
		if(rear == front)
		{
			rear = -1;
			front = -1;
		}
		else
			front = front +1;
		
		System.out.println("The deleted item is  : "+temp);
	}
	public static void traverse()
	{
		if(front<0)
		{
			System.out.println("Empty queue");
			return;
		}
		else
		{
			System.out.println("The elements are : ");
			int i = front;
			while(i <= rear)
			{
				System.out.println(Q[i]);
				i++;
			}
		}
	}
}
