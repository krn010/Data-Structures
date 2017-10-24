import java.util.*;
import java.lang.*;
class LinkedQueue
{
	Node front,rear;
	int size=0;
	class Node
	{
		int data;
		Node next;
		
	}
	public LinkedQueue()
	{
		front=null;
		rear=null;
	}
	
	public boolean isEmpty()
	{
		return (size == 0);
 	}
	
	public void enqueue(int data)
	{
		Node new_node= rear;
		rear=new Node();
		rear.data=data;
		rear.next=null;
		if(isEmpty())
		{
			front=rear;
		}
		else
		{
		new_node.next=rear;	
		}
		size++;
		System.out.println(data+"  person added to the queue");	
	}
	
	public void dequeue()
	{
		int data=front.data;
		front=front.next;
		
		
		if(isEmpty())
		{
			rear=null;
		}
		size--;
		System.out.println(data+" person removed from the queue");
	
		
	} 

	
}





class Banking{
	public static void main(String...args)
	{
	Scanner sc=new Scanner(System.in);
	LinkedQueue list=new LinkedQueue();
	
	
	
	System.out.println("how many people you want to add in queue");
	int number=sc.nextInt();
	int paise=10000;
	System.out.println("already bank have "+paise+" Rs.");
	
	for(int i=1;i<=number;i++)
	{
	list.enqueue(i);
	}
	
	for(int i=1;i<=number;i++)
	{
	System.out.println("for "+i+" person");
	System.out.println("enter W for withdraw or D for deposite");
	String match=sc.next();
	
		if(match.equals("W"))
		{
		System.out.println("enter amount for withdraw money");
		int withdraw=sc.nextInt();
		paise=paise-withdraw;
		}
		
		else if(match.equals("D"))
		{
		System.out.println("enter amount for deposite money");
		int deposite=sc.nextInt();
		paise=paise+deposite;
		}
	list.dequeue();
	
	}
	System.out.println("total money in a bank is :"+paise);
	}
}
