import java.util.*;
import java.lang.*;
class Queue
{
	
	Node front,rear;
	int size=0;
	class Node
	{
		int data;
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
		System.out.print("  "+data);
	} 
	
	
}

class D14{
	public static void main(String...args)
	{

	Queue date=new Queue();
	
	
	int temp,plus=0,check=0,z=0;
	int[] arr=new int[1000];
	int[] brr=new int[1000];
	
	
		for(int i=0;i<1000;i++)
		{
			int d=0;
			if(i==0 || i==1)
			{
				d=1;
			}
	
			for(int j=2;j<i;j++)
			{
				if(i%j==0 || i==0 || i==1)
				{
					d=1;
					break;			
				}
			}

			if(d==0)
			{
				plus++;
				arr[plus]=i;
			}

		}

		for(int l=1;l<plus;l++)
		{
			String data=String.valueOf(arr[l]);
			char[] c1=data.toCharArray();
			Arrays.sort(c1);
			String data1=String.valueOf(c1);
			brr[l] = Integer.parseInt(data1);
		}

		for(int p=1;p<plus;p++)
		{
			for(int m=p+1;m<plus;m++)
			{
				if(brr[p]==brr[m])
				{
					int length = (int)(Math.log10(arr[p])+1);
					int length1 = (int)(Math.log10(arr[m])+1);					
					if(length==length1)
					{					
					
					date.enqueue(arr[p]);
					date.enqueue(arr[m]);
					
					
					}

				}

			}	

		}
	
	for(int p=1;p<plus-9;p++)
		{
		date.dequeue();
		}
	
	
	
	
	}

}
