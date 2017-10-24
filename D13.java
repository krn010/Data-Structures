import java.util.*;
import java.lang.*;
class Stack
{
	
	

	static int d;
	static Node head;
	static class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next=null;
		}
	}
	
	public static void push(int new_data)
	{
		Node new_node= new Node(new_data);
		new_node.next=head;
		head=new_node;	
	}
	
	public static  void  pop()
	{
		Node temp=head,prev=null;
		
		if(temp!=null)
		{
		d=temp.data;
		head=temp.next;
			
		}
	System.out.print("  "+d);
		
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
		
	

	
	
	
	
}

class D13{
	public static void main(String...args)
	{
	
		
	Stack date=new Stack();
	
	
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
					date.push(arr[p]);
					date.push(arr[m]);
					
					
					}

				}

			}	

		}
	
	for(int p=1;p<plus-9;p++)
		{
		date.pop();
		}
	
	
	}

}

