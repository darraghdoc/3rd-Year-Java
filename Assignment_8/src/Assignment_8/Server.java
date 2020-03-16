//Darragh O'Connell 17371056
package Assignment_8;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
	
	private DataOutputStream DOS;												//Creating DataIS and DataOS stream
	private DataInputStream DIS;												//
	private ArrayList<ClientThread> Client;										//creating arrayList of client objects
	private ClientThread Temp_Thread;											//Creating client Thread
	private ServerSocket Server_Socket;											//Creating server socket

	public Server() {

		try {
			Server_Socket = new ServerSocket(4400, 10); 						//Creating server socket on port 8000
			Client = new ArrayList<ClientThread>();								//Creating arrayList of client thread
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public void execute() {

		try {
			while (true) { 													
				Temp_Thread = new ClientThread(Server_Socket.accept());		// accept server socket 
				Client.add(Temp_Thread);									// add thread to ArrayList 
				Temp_Thread.start();										//start thread 
				System.out.println("The Client has connected");						
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public static void main(String[] args) {										//Main
		Server Server = new Server();												//Creating new Server
		Server.execute();
	}

	private class ClientThread extends Thread {								

		private Socket Socket_Connection;											//creating Socket, DataInutStream and DataOutput stream
		private DataInputStream DataIS;										
		private DataOutputStream DataOS;

		public ClientThread(Socket socket1) {

			Socket_Connection = socket1; 											// creating connection

			try {
				DataIS = new DataInputStream(Socket_Connection.getInputStream()); 	// Setting up data streams
				DataOS = new DataOutputStream(Socket_Connection.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}

		}

		public void run() {
			String Command_Selection;
			try {
				Command_Selection = DataIS.readUTF();
			
			if(Command_Selection.equals("-u")) {													//Upload
				int size = DataIS.readInt();														//
				byte[] bytearray = new byte[size];													//creating byte array
				DataIS.read(bytearray, 0, size);													
				FileOutputStream FOS = new FileOutputStream("data1.txt");							//creating file output stream
				BufferedOutputStream BOS =  new BufferedOutputStream(FOS);							//creating buffered output stream
				BOS.write(bytearray,0,size);														//write byte array to buffered output stream
				BOS.close();
				Socket_Connection.close();
					   
					 

			}else if(Command_Selection.equals("-d")) {												//Download
				int size = DataIS.readInt();
				byte[] bytearray = new byte[size];
				DataIS.read(bytearray, 0, size);
				FileOutputStream FOS = new FileOutputStream("data2.txt");
				BufferedOutputStream BOS =  new BufferedOutputStream(FOS);
				BOS.write(bytearray,0,size);
				BOS.close();
				Socket_Connection.close();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
}
