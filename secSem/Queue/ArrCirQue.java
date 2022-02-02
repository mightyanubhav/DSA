
public class ArrCirQue
{
	static int MAX = 5;
	static int front =-1, rear = -1;
	static int CQ[] = new int [MAX];
	
	
	public static void insertCQ(int item)
	{
		if(front == (rear+1) % MAX)
		{
			System.out.println("Over flow");
			return;
		}
		if(rear < 0)
		{
			rear = front = 0;
		}
		else
		{
			rear = (rear + 1 ) % MAX;
		}
		CQ[rear] = item;
	}
	public static void deleteCQ()
	{
		if(front <0)
		{
			System.out.println("The que is empty");
			return;
		}
		int  temp = CQ[front];
		
		if(rear == front)
		{
			rear = front = -1;
		}
		else
		{
			front = (front +1) % MAX;
		}
		System.out.println(temp+" is popped.");
	}
	
	public static void traverseCQ()
	{
		if(front <0)
		{
			System.out.println("The que is empty");
			return;
		}
		else
		{
			System.out.println("The CQ element fron front to rear are : ");
			
			if(front <= rear)
			{
				int i = front;
				while(i<=rear)
				{
					System.out.println(CQ[i]+" --> ");
					i++;
				}				

			}
			else// special (if the element is empty in middlle.
			{
				int i = front;
				while(i <= MAX-1)
				{
					System.out.println(CQ[i]+" --> ");
					i++;
				}
				i++;
			}
//			i=0;
//			while()
		}
	}
	
	public static void main(String[] args) 
	{
		

	}

}
