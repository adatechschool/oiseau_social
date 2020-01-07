import java.net.*;
import java.io.*;

public class Server
{
  public static void main(String[] args)
  {
    try
    {
      ServerSocket server = new ServerSocket(9000);
      Socket connection = server.accept();

      DataInputStream server_input = new DataInputStream(connection.getInputStream());

      System.out.println("SERVER: " + server_input.readUTF() + " received from " + connection);

      server.close();
    }
    catch (IOException err)
    {
      System.out.println(err);
    }
  }
}
