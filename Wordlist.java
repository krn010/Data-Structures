import java.io.*;
import java.util.*;
import java.lang.*;
class LinkedList
{
	Node head;
	class Node
	{
		String data;
		Node next;
		Node(String d)
		{
			data=d;
			next=null;
		}
	}

	public void push(String new_data)
	{
		Node new_node= new Node(new_data);
		new_node.next=head;
		head=new_node;
	}

	public void insertAfter(Node prev_node,String new_data)
	{
		Node new_node=new Node(new_data);
		new_node.next=prev_node.next;
		prev_node.next=new_node;

	}

	public void append(String new_data)
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

	public void pop(String data)
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
		Node tnode=head;
		FileOutputStream fo=new FileOutputStream("input.txt");
		Scanner sc=new Scanner(System.in);




		while(tnode!=null)
		{
		byte b[]=tnode.data.getBytes();
		System.out.println(tnode.data+" ");

		tnode=tnode.next;
		fo.write(b);
		fo.write(' ');
		}

		fo.close();
	}
	public void search(String str)
	{	int i=0;
		Node tnode=head;
		while(tnode!=null)
		{

		if(tnode.data.equals(str))
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

}





class Wordlist{
	public static void main(String...args) throws IOException
	{
	LinkedList list=new LinkedList();

	FileOutputStream fo=new FileOutputStream("input.txt");
	Scanner sc=new Scanner(System.in);

	System.out.println("enter data into file");
	String str=sc.nextLine();

	byte b[]=str.getBytes();

	fo.write(b);
	fo.close();

	File input=new File("input.txt");
	Scanner scan=new Scanner(input);
	scan.useDelimiter(" ");



	while(scan.hasNext())
	{
		String data=scan.next();
		list.append(data);
	}




	System.out.println("enter data for search");
	String data=sc.nextLine();
	list.search(data);
	list.printList();
	}
}
