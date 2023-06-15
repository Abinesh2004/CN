import java.net.*;
import java.io.*;
import java.util.*;
public class SimpleTCPClient
{
  public static void main(String args[])throws Exception
  {
    Socket s=new Socket("localhost",2000);
    DataInputStream dis=new DataInputStream(s.getInputStream());
    DataOutputStream dos=new DataOutputStream(s.getOutputStream());
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter a paragraph of 3 lines:");
    StringBuilder paragraph = new StringBuilder();
    for (int i = 0; i < 3; i++) 
    {
      String line = sc.nextLine();
      paragraph.append(line).append("\n");
    }
    String paragraphString = paragraph.toString();
    //System.out.println("The paragraph you entered is:");
    //System.out.println(paragraph.toString());
    dos.writeUTF(paragraphString);
    String line=dis.readUTF();
    System.out.println("Server Says "+line);
    }
  }
