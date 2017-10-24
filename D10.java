import java.util.*;
import java.lang.*;
class Stack
{
	
	Stack st1,st2;
	static int StartDay;
	String leap,NumberOfDays;
	static String d;
	static Node head;
	static class Node
	{
		String data;
		Node next;
		Node(String d)
		{
			data=d;
			next=null;
		}
	}
	
	public static void push(String new_data)
	{
		Node new_node= new Node(new_data);
		new_node.next=head;
		head=new_node;	
	}
	
	public static  String pop()
	{
		Node temp=head,prev=null;
		
		if(temp!=null)
		{
		d=temp.data;
		head=temp.next;
			
		}
	return d;
		
	} 

	public void printList()
	{
		Node t1node=head;
		if(t1node==null)
		{
			System.out.println("stack is empty ");
			
		}
		while(t1node!=null)
		{
		System.out.print("stack is not empty and data in stack is : "+t1node.data+"  ");
		
		t1node=t1node.next;
		
		}
		
		
	}
		
	public void enqueue(String data)
	{
		
		st1.push(data);
	}
	
	public void dequeue()
	{
		
	
		st2.push(st1.pop());
		NumberOfDays=st2.pop();
	}
	
	
	public void isLeapYear(int year) 
	{
		if((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0))
		{
			 leap="true";
		}
       	else 
			leap="false";

	}
	
		
	public static void dayStart(int month, int day, int year) 
	{
		int y = year - (14 - month) / 12;
  		int x = y + y/4 - y/100 + y/400;
       	int m = month + 12 * ((14 - month) / 12) - 2;
       	int d = (day + x + (31*m)/12) % 7;
       	StartDay=d;
   	}
	
	
	void print()
	{
		int totaldays=Integer.parseInt(NumberOfDays);
		if(leap.equals("true"))
		{
			totaldays=totaldays+1;
		}
	
		for(int i=0;i<StartDay;i++)
		{
			System.out.print("   ");
		}
		
		for(int i=1;i<=totaldays;i++)
		{
			System.out.printf("%3d",i);
			if(((i+StartDay)%7==0) || (i==totaldays))
			{
				System.out.println();
			}
		}
	}

	
	
	
	
}

class D10{
	public static void main(String...args)
	{
	
		
	Stack date=new Stack();
	
	date.enqueue("31");
	date.enqueue("28");
	date.enqueue("31");
	date.enqueue("30");
	date.enqueue("31");
	date.enqueue("30");
	date.enqueue("31");
	date.enqueue("31");
	date.enqueue("30");
	date.enqueue("31");
	date.enqueue("30");
	date.enqueue("31");
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter month ");
	int month=sc.nextInt();
	
	System.out.println("Enter year ");
	int year=sc.nextInt();
	
	date.dayStart(month,1,year);
	date.isLeapYear(year);
	
	System.out.println();
	System.out.println("  S  M  Tu W Th  F  S ");	

	for(int j=0;j<month;j++)
	{
		if(j==0)
		{
		date.dequeue();
		}
		else
			date.dequeue();
	}
	
	date.print();
	
	}

}

