import java.util.*;
import java.io.*;
import java.lang.*;
class Node
{
	Node next;
	int data;
	Node(int x)
	{
		data=x;
		next=null;
	}		
}

class HasFunction{
	
	
	int size;
	Node[] table;
	
	public HasFunction(int tableSize)
	{
		table=new Node[tableSize];
		size=0;
	}
	
	
	public void insert(int data)
	{
		size++;
		int index=data % table.length;
		Node ptr=new Node(data);
	
		if(table[index]==null)
		{
			table[index]=ptr;
		}
		
		else
		{
			ptr.next=table[index];
			table[index]=ptr;	
		
		}
	}
	
	public void remove(int data)
	{
		int index=data%table.length;
		Node start=table[index];
		Node end=start;
		
		if(start.data==data)
		{
			size--;
			table[index]=start.next;
			return;
		}
	
		while(end.next!=null && end.next.data!=data)
		{
			end=end.next;
		}
		
		if(end.next==null)
		{
			System.out.println("element not found");
			return;
			

		}
		
		size--;
		if (end.next.next == null)
        	{
            		end.next = null;
 	           	return;

        	}

        	end.next = end.next.next;

        	table[index] = start;
			
	}
	
	
	
	public void check(int str)
	{
		int d=0;
		for(int i=0;i<table.length;i++)
		{
			
			Node start=table[i];
			while(start!=null)
			{
				if(str==start.data)
				{
					d=1;
					remove(str);
					start=start.next;
				}
				else{
					start=start.next;

					}
								
				
			}
			
		}
	
		if(d==0)
		{
			insert(str);
		}
	}
	
	public void print()throws IOException
	{
	
		FileOutputStream fo=new FileOutputStream("D6.txt");
		
		System.out.println();
		for(int i=0;i<table.length;i++)
		{
			System.out.println("index "+i+" : ");
			Node start=table[i];
			while(start!=null)
			{
				String srr=String.valueOf(start.data);
				byte[] b=srr.getBytes();
				fo.write(b);
				fo.write(' ');
				System.out.println(start.data+" ");
				start=start.next;
			}
			System.out.println();
		}
		fo.close();
	}

}



class D6{
	public static void main(String...args) throws IOException
	{
	
		FileOutputStream fo=new FileOutputStream("D6.txt");
	
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of has table");
		int total=sc.nextInt();
	
		HasFunction Has=new HasFunction(total);
	
		Scanner sc1=new Scanner(System.in);
		System.out.println("enter int data into file");
		String str=sc1.nextLine();

		byte[] b=str.getBytes();
		fo.write(b);
		fo.close();
	
	
		File out=new File("D6.txt");
		Scanner scan=new Scanner(out);
		scan.useDelimiter(" ");

		while(scan.hasNext())
		{
		
		Has.insert( scan.nextInt() );
		
		}
	
		Has.print();
		
		System.out.println("enter data for search");
		int search=sc.nextInt();
	
		System.out.println("  ");

		Has.check(search);
		Has.print();
	}
}