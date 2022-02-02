class QNode
{
	char info;
	QNode link;
}
public class CircularQueue 
{
	
	static java.util.Scanner in = new java.util.Scanner(System.in);

	static QNode front ;
	static QNode rear;
	
	public static void traverse()
	{
		if(front == null)
		{
			System.out.println("The list is empty.");
			return;
		}
		else
		{
			System.out.println("The queue is : ");
			QNode t = front;
			
			while(t != null)
			{
				System.out.println(t.info+" --> ");
				t=t.link;
			}
		}
			
	}
	
	public static void main(String[] args) 
	{
		

	}
	public static void insertQ(char item)
	{
		QNode newnode = new QNode();		
		newnode .info = item;
		
		if(rear == null)
		{
			front = rear = newnode;
			newnode.link = null;
		}
		else
		{
			rear.link = newnode;
			rear = newnode;
			newnode.link = null;
		}
	}
	
	public static void deleteQ()
	{
		if(front == null)
		{
			System.out.println("The list is empty :");
			return;
		}
		
		QNode temp = front;
		if(front == rear)
		{
			front = rear = null;
		}
		else
		{
			front = front.link;
			temp.link = null;
		}
		System.out.println("The deleted node is :"+temp );
	}
	
	

}
