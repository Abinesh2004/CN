
import java.net.*;
import java.io.*;
import java.util.*;
public class SimpleTCPServer 
{
  public static void main(String args[])throws Exception
  {
    Scanner sc=new Scanner(System.in);
    ServerSocket ss=new ServerSocket(2000);
    DataInputStream dis;
    DataOutputStream dos;
    while(true)
    {
      Socket s=ss.accept();
      dis=new DataInputStream(s.getInputStream());
      dos=new DataOutputStream(s.getOutputStream());
      String line=dis.readUTF();
      int wordCount = 0;
      int charCount = 0;
      boolean insideWord = false;
      for (int i = 0; i < line.length(); i++)
      {
        char ch = line.charAt(i);
        if (ch != ' ' && ch != '\t' && ch != '\n') 
        {
          charCount++;
          if (!insideWord) {
          wordCount++;
          insideWord = true;
        }
      }
      else {
      insideWord = false;
      }
    }
    System.out.println("Client Says:"+line);
    dos.writeUTF("Number of words: " + wordCount+"\n"+"Number of characters: " + 
    charCount);
    }
  }
}
