import java.util.*;

class D12{

	public static void main(String...args)
	{
	int temp,plus=0,check=0,z=0;
	int[] arr=new int[1000];
	int[] brr=new int[1000];
	int[] newarray=new int[1000];
	int[] newarray1=new int[1000];
	int[][] array=new int[30][30];
	
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

		System.out.println("All possible combination of Anagram");
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
					
					newarray[z]=arr[p];
					newarray1[z]=arr[m];
					z++;
					
					}

				}

			}	

		}
		int v=0,v1=0;
		for(int p=0;p<2;p++)
		{
			for(int q=0;q<30;q++)
			{
				array[p][q]=newarray[v];
				if(p==1)
				{
				array[p][q]=newarray1[v1];
				v1++;
				}
				v++;
			}
			
			
		}
		for(int q=0;q<30;q++)
		{
			for(int p=0;p<2;p++)
		
			{
				
				System.out.print("["+p+"]["+q+"] "+array[p][q]+" ");
			}
			
			System.out.println();
			
		}
		
		
		
		











		

	}

}