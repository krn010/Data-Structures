import java.util.*;
import java.lang.*;
class DeQueue
{
	static Node front,rear;
	int size=0;
	class Node
	{
		char data;
		Node next;
		Node(char d)
		{
			data=d;
			next=null;
		}
		
	}
	public DeQueue()
	{
		front=null;
		rear=null;
	}
	
	public  boolean isEmpty()
	{
		if(front ==  null)
			return true;
		return false;
 	}
	
	public void insertAtBeg(char data)
	{
		Node new_node= new Node(data);
		
		
		if(isEmpty())
		{
			front = new_node;
			rear = new_node;
		}		
		
		else
		{
		new_node.next=front;
		front = new_node;	
		}
		
		System.out.println(data+" added to the dequeue");	
	}
	
	
	public char delAtEnd() 
	{
		
		char data=front.data;
		front=front.next;
		
		return data;
	}

	public char delAtBeg() 
	{
		if(rear==front){
				front=null;
				return rear.data;
				
				}
		Node temp=front;
		char data=rear.data;
		while(temp.next!=rear)
		{
			temp=temp.next;
		}
		rear = temp;
		return data;
		
	} 
	
	
	

	
}





class Palindrome{
	public static void main(String...args)
	{
	Scanner sc=new Scanner(System.in);
	DeQueue list=new DeQueue();
	System.out.println("enter any name to check its Palindrome or not");
	String check=sc.next();
	char[] chr=check.toCharArray();
	for(int i=0;i<check.length();i++)
	{
		list.insertAtBeg(chr[i]);
	}
	
	int d=0;
	try{
		for(int i = 0;i<(check.length()/2);i++)
		{
			
			
			
			char charBegin = list.delAtBeg();
			
			
			
			
			System.out.println(charBegin);char charEnd = list.delAtEnd();System.out.println(charEnd);
			if(charBegin == charEnd) 
			{
				 d=1;
				
			}
			else{d=0;}
				
		
		}
	}catch(Exception e){System.out.println(e);}
	
	if(d==1)
	{
	System.out.println("Palindrome");
	}
	else
	{
		System.out.println("NOT Palindrome");
}
		
		
		
	
	}
}
