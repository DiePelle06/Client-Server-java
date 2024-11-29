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

			// Read message from client
			String message = in.readLine();
			System.out.println("Client says: " + message);
			
			message.toUpperCase();

			// Send response to the client
			out.println(message);

			// Close the client socket
			clientSocket.close();
			// Close the server socket
			serverSocket.close();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
}
