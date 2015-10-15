import java.util.*;
import java.io.*;
import java.net.*;

public class TCPServer {

public static void main(String[] args) {
	String s;
	Scanner inputStream; 
	PrintWriter outputStream; 
	ServerSocket serverSocket;
	try {
	serverSocket = new ServerSocket(8888); 
	while(true) {
	Socket socket = serverSocket.accept();
	//Connected to client
	outputStream = new PrintWriter(new DataOutputStream(socket.getOutputStream())); 
	inputStream = new Scanner(new InputStreamReader(socket.getInputStream()));
	
	
	while(true) {
	s = inputStream.nextLine(); 
	System.out.println(s); 
	if(s.equalsIgnoreCase("bye")) {
		outputStream.println("bye"); 
		outputStream.flush(); 
		break;
		} outputStream.println("M " + s); outputStream.flush();
	}


	inputStream.close();
	outputStream.close();
		}
	}
	catch(Exception e)
		{
	System.out.println("Error: " + e.getMessage()); 
		}


	
	}

}