//server

import java.io.*;
import java.net.*;

public class Main 
{
	public static void main(String[] args) 
	{
		try
		{
			// create a server socket on port number 31124
			ServerSocket serverSocket = new ServerSocket(31124);
			System.out.println("Server is running and waiting for client connection...");

			// Accept incoming client connection
			Socket clientSocket = serverSocket.accept();
			System.out.println("Client connected!");

			// Setup input and output streams for communication with the client
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

			boolean go = true;
			String message;
			
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
