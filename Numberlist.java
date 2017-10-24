import java.io.*;
import java.util.*;
import java.lang.*;
class LinkedList
{
	Node head;
	class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next=null;
		}
	}
	
	public void push(int new_data)
	{
		Node new_node= new Node(new_data);
		new_node.next=head;
		head=new_node;	
	}
	
	public void insertAfter(Node prev_node,int new_data)
	{
		Node new_node=new Node(new_data);
		new_node.next=prev_node.next;
		prev_node.next=new_node;
			
	}
	
	public void append(int new_data)
	{
		Node new_node=new Node(new_data);
		
		if(head==null)
		{
			head=new Node(new_data);
			return;
		}
		new_node.next=null;
	
		Node last=head;
		
		while(last.next!=null)
		{
		last=last.next;
		}
		
		last.next=new_node;
		return;
	}
	
	public void pop(int data)
	{
		Node temp=head,prev=null;
		
		if(temp!=null && temp.data==data)
		{
			head=temp.next;
			return;
		}
	
		while(temp!=null && temp.data!=data)
		{
			prev=temp;
			temp=temp.next;
		}
		if(temp==null) return;
		prev.next=temp.next;
	} 

	public void printList() throws IOException
	{
		Node t1node=head;
		sort();
		FileOutputStream fo=new FileOutputStream("Numberlist.txt");
		Scanner sc=new Scanner(System.in);

	

	
		while(t1node!=null)
		{
		String convert=String.valueOf(t1node.data);
		byte b[]=convert.getBytes();
		System.out.print(t1node.data+" ");
		
		t1node=t1node.next;
		fo.write(b);
		fo.write(' ');
		}
		
		fo.close();
	}
	public void search(int str)
	{	int i=0;
		Node tnode=head;
		while(tnode!=null)
		{
		
		if(tnode.data==str)
		{
		i=1;
		
		pop(tnode.data);
		
		}
		
		tnode=tnode.next;
		
		}
		
		if(i==0)
		{
		append(str);
		}
	}
	
	public void sort()
	{
		
		Node t1node;
		
		t1node=null;
		int temp;
		boolean swap=false;
		
	
		while(!swap)
		{
			swap=true;
			Node tnode=head;	
			while(tnode.next!=null)
			{
				
			
				if(tnode.data>tnode.next.data)
				{	
					swap=false;
					temp=tnode.data;
					tnode.data=tnode.next.data;
					tnode.next.data=temp;
			
				}
				tnode=tnode.next;
				
				
			}	
			
		}	
		
		
	}
	
}





class Numberlist{
	public static void main(String...args) throws IOException
	{
	LinkedList list=new LinkedList();
	
	FileOutputStream fo=new FileOutputStream("Numberlist.txt");
	Scanner sc=new Scanner(System.in);

	System.out.println("enter data into file");
	String str=sc.nextLine();

	byte b[]=str.getBytes();

	fo.write(b);
	fo.close();

	File input=new File("Numberlist.txt");
	Scanner scan=new Scanner(input);
	scan.useDelimiter(" ");

	
	
	while(scan.hasNext())
	{
		int data=scan.nextInt();
		list.append(data);	
	}
	
	
	
	
	
	list.sort();
	System.out.println("enter data for search");	
	int data=sc.nextInt();
	list.search(data);
	list.printList();
	}
}
