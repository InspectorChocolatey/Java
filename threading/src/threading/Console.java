package threading;

public class Console 
{

	public static void main(String[] args)
	{
		String arg1 = args[0];
		
		if(arg1 == "parallel") 
		{
			// do it with extra user thread:
		}
		else 
		{
			try 
			{
				func1("loop A");
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			try 
			{
				func2("loop B");
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}			
		}
	}

	public static void func1(String text) throws InterruptedException
	{
		for(int i = 1; i < 10; i++) 
		{
			System.out.println(text + String.valueOf(i));
			Thread.sleep(2000);
		}
	}
	
	public static void func2(String text) throws InterruptedException
	{
		for(int i = 1; i < 10; i++) 
		{
			System.out.println(text + String.valueOf(i));
			Thread.sleep(2000);
		}
	}
}
