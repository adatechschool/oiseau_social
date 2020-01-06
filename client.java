import java.net.*;
import java.io.*;

public class Client
{
  public static void main(String[] args)
  {
    try
    {
      Socket client = new Socket("localhost", 9000);

      DataOutputStream client_output = new DataOutputStream(client.getOutputStream());

      client_output.writeUTF("coucou");

      client.close();
    }
    catch (IOException err)
    {
      System.out.println(err);
    }
  }
}
