import java.net.*;
import java.io.*;

public class server
{
  public static void main(String[] args)
  {
    try
    {
      ServerSocket main_server = new ServerSocket(9000);

      main_server.accept();
    }
    catch (IOException err)
    {
      System.out.println(err);
    }
  }
}
