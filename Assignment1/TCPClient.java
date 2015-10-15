/*
import java.io.*;
import java.net.*;
import java.util.*;
/**
 * A Simple Client
* Reference- Java: An Introduction to problem solving and programming,
*7th Edition
 *                by Walter Savitch 
                 
public class TCPClient {
        public static void main(String[] args)
        {
                 String s, tmp;
                 Scanner inputStream;
                 PrintWriter outputStream;
                 Scanner userinput;
                 try
                 {
                 // connects to port server app listesing at port 8888 in the same machine
                 Socket socket = new Socket("localhost", 8888);
                 // Create necessary streams
                 outputStream = new PrintWriter(new DataOutputStream(socket.getOutputStream()));
                 inputStream = new Scanner(new InputStreamReader(socket.getInputStream()));


				userinput = new Scanner(System.in);
				// send/receive messages to/from server
				while(true)
				{
				        System.out.println("Enter Text Message for Echo Server: ");
				        tmp = userinput.nextLine();
				        // Send user input message to server
				        outputStream.println(tmp);
				        //Flush to make sure message is send
				        outputStream.flush();
				        s = inputStream.nextLine();
				        System.out.println(s);
				        // Exit if message from server is "bye"
				} 
				}
				        if(s.equalsIgnoreCase("bye"))
				                 break;
				}
				inputStream.close();
				outputStream.close();
				}
				catch (Exception e)
				{
				System.out.println("Error: " + e.getMessage());
				} */

import java.util.*;
import java.io.*;
import java.net.*;
public class TCPClient {



 public static void main(String[] args) {
		String s, tmp;
		InputStream inputStream = null ;
		PrintWriter outputStream =  null ;
		OutputStream outfile = null;
		Socket socket = null ;
		
		try {
			 socket = new Socket("ucalgary.ca", 80); // host name and port
			 System.out.println("Connecting 1...");
			}
		catch(Exception e)
		{
			
			System.out.println("Error message"+ e.getMessage());
		}
	

		try{
			System.out.println("Connecting 2...");
			inputStream = socket.getInputStream(); // raed from text file			
		}
		catch(Exception e)
		{
			
			System.out.println("Can't get socket input stream");
		}
		
		try{
			System.out.println("Connecting 3...");
			
			outputStream = new PrintWriter(new DataOutputStream(socket.getOutputStream()));
			}
		catch(Exception e)
			{
				System.out.println("Can't get to socket outputStream");
			}	
			
		try {
			System.out.println("Connecting 4 ...");
			outputStream.println("GET /~mghaderi/test/test.html HTTP/1.0\n");
			outputStream.flush();
			
			outfile = new FileOutputStream("/Users/moonisahmed/Desktop/441/test.txt");
			System.out.println("Connecting 5...");
			byte[] bytes = new byte[55];

	        int count;
	        while ((count = inputStream.read(bytes)) > 0) {
	            System.out.println(bytes);
	            outfile.write(bytes , 0, count);
	            System.out.println("Connecting 6...");
	        }
	        System.out.println("Connecting 7...");
		inputStream.close();
		outputStream.close();
			//socket.close();
		
		}
		catch(Exception e)
		{
			
			System.out.println("Can't stream");
		}
		
		}	

}