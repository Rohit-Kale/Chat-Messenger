import java.io.*;
import java.net.*;

class Client
{
	public static void main(String args[]) throws Exception
	{
		String str1,str2;

		System.out.println("Client is running...\n\n");

		Socket s = new Socket("localhost",2101);

		PrintStream ps = new PrintStream(s.getOutputStream());

		BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

		while(!(str1 = br2.readLine()).equals("exit"))
		{
			ps.println(str1);
			str2 = br1.readLine();
			System.out.println("Servers Says : "+str2);
			System.out.println("Enter message for server");
		}

		ps.close();
		br1.close();	
		br2.close();
	}
}