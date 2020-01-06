import java.net.*;
import java.io.*;

public class Client
{
  public static void main(String[] args)
  {
    try
    {
      Socket main_client = new Socket("localhost", 9000);
    }
    catch (IOException err)
    {
      System.out.println(err);
    }
  }
}
