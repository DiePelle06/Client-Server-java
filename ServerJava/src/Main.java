//server

import java.io.*;
import java.net.*;

public class Main 
{
	public static void main(String[] args) 
	{
		try
		{
			boolean go = true;
			String message;
			
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			
			boolean fine = false;
			
			// Accept incoming client connection
			ServerSocket serverSocket = new ServerSocket(31124);
			
			while(!fine)
			{
				System.out.println("Server is running and waiting for client connection...");
				// Accept incoming client connection
				Socket clientSocket = serverSocket.accept();
				System.out.println("Client connected!");
				
				// Setup input and output streams for communication with the client
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			
				// Read message from client
				while(go)
				{
					message = in.readLine();
					System.out.println("Client says: " + message);
	
					// Send response to the client
					if(!message.equalsIgnoreCase("exit"))
					{
						out.println(message.toUpperCase());
						System.out.println("i sent : " + message.toUpperCase());
					}
					else
					{
						go = false;
					}
				}
				
				System.out.println("Vuoi continuare? \nY[1] N[0]");
				int scelta = Integer.valueOf(console.readLine());
				
				if(scelta == 0)
				{
					fine = true;
				}
				
				go = true;
				
				if(fine)
				{
					// Close the client socket
					clientSocket.close();
					// Close the server socket
					serverSocket.close();
					
					System.out.println("connection closed");
				}
			}
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
}
