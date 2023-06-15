import java.io.*;
import java.net.*;
import java.util.*;
class TCPFileClient
{
  public static void main(String str[]) throws Exception
  {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the file name to upload");
      File f=new File(sc.next());
      Scanner sc2=new Scanner(f);
      Socket s=new Socket("localhost",10000);
      DataOutputStream dos=new DataOutputStream(s.getOutputStream());
      while(sc2.hasNext())
      {
      dos.writeUTF(sc2.nextLine());
      }
      s.close();
      dos.close();
  }
}
