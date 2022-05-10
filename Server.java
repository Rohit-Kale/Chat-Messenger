import java.io.*;
import java.net.*;

class Server
{
	public static void main(String args[]) throws Exception
	{
		String str1,str2;

		System.out.println("Server is running...\n\n");

		ServerSocket ss = new ServerSocket(2101);

		Socket s = ss.accept();

		System.out.println("Connection is succesfully established...");	
		
		PrintStream ps = new PrintStream(s.getOutputStream());
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));

		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		
		while((str1 = br1.readLine()) != null)
		{
			System.out.println("Client Says : "+str1);
			System.out.println("Enter message for client");
			str2 = br2.readLine();
			ps.println(str2);
		}

		ps.close();
		br1.close();
		br2.close();
	}
}