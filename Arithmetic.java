import java.util.*;
import java.lang.*;
class Stack
{
	Node head;
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
	
	public void push(char new_data)
	{
		Node new_node= new Node(new_data);
		new_node.next=head;
		head=new_node;	
	}
	
	public void pop()
	{
		Node temp=head,prev=null;
		
		if(temp!=null)
		{
			head=temp.next;
			return;
		}
	
		
	} 

	public void printList()
	{
		Node t1node=head;
		if(t1node==null)
		{
			System.out.println("stack is empty and Arithmetic Expression is Balanced");
			
		}
		while(t1node!=null)
		{
		System.out.println("Arithmetic Expression is not Balanced");
		System.out.print("stack is not empty and data in stack is : "+t1node.data+"  ");
		
		t1node=t1node.next;
		
		}
		
		
	}
	
	
	
}





class Arithmetic{
	public static void main(String...args)
	{
	Stack list=new Stack();
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Arithmetic Expression");
	String str=sc.next();
	
	char[] chr=str.toCharArray();	
	for(int i=0;i<str.length();i++)
	{

		if(chr[i] =='(' )
		{
		list.push('(');
		}
		else if(chr[i] == ')')
		{
		list.pop();
		}
	}	
	
	list.printList();
	}
}
