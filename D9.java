import java.util.*;
import java.lang.*;
class Queue
{
	
	Node front,rear;
	int size=0;
	static int StartDay;
	String leap,NumberOfDays;
	class Node
	{
		String data;
		Node next;
		
	}
	public Queue()
	{
		front=null;
		rear=null;
	}
	
	public boolean isEmpty()
	{
		return (size == 0);
 	}
	
	public void enqueue(String data)
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
		
	}
	
	public void dequeue()
	{
		String data=front.data;
		front=front.next;
				
		if(isEmpty())
		{
			rear=null;
		}
		
		size--;
		NumberOfDays=data;
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

class D9{
	public static void main(String...args)
	{

	Queue date=new Queue();
	
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
