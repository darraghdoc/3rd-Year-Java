//Darragh O'Connell 17371056
package Assignment_8;
import java.io.*;
import java.net.*;

public class Client {

	private Socket Client_Socket;
	private DataOutputStream Client_Output;
	private DataInputStream Client_Input;

	public Client(String[] args) throws IOException {

		try {
			Client_Socket = new Socket(args [0], Integer.parseInt(args [1])) ; 						// connecting client to server
		} catch (IOException e) {
			
			e.printStackTrace();
			System.exit(1);
		}

		try {
			Client_Input = new DataInputStream(Client_Socket.getInputStream()); 					// Setting up client input and output stream
			Client_Output = new DataOutputStream(Client_Socket.getOutputStream());					//
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		if(args[2].equals("-u")){																	//Upload
			  File File = new File(args[3]);
		      byte[] bytearray = new byte[(int) File.length()];
		      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(args[3]));
		      bis.read(bytearray, 0, bytearray.length);
		      Client_Output.writeUTF("-u");
		      Client_Output.writeInt(bytearray.length);
		      Client_Output.write(bytearray, 0, bytearray.length);
		      Client_Output.flush();
		      bis.close();
			  Client_Socket.close();
			  System.out.println("A file has been uploaded\n");
			
		} 
		else if(args[2].equals("-d"))																//Download
		{
			  File File = new File(args[3]);
		      byte[] bytearray = new byte[(int) File.length()];
		      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(args[3]));
		      bis.read(bytearray, 0, bytearray.length);
		      Client_Output.writeUTF("-d");
		      Client_Output.writeInt(bytearray.length);
		      Client_Output.write(bytearray, 0, bytearray.length);
		      Client_Output.flush();
		      bis.close();
			  Client_Socket.close();
			  System.out.println("A File has been Downloaded \n");
		}
	}

	public static void main(String[] args) throws IOException {

		Client client = new Client(args);															//Creating new client

	}

}
