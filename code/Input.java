import org.jline.terminal.*;
import org.jline.terminal.impl.*;
import org.jline.reader.*;
import org.jline.reader.impl.*;
import java.io.IOException;

public class Input
{
  
  public char getch()
  {
    int input = 0;
    try {
      Terminal terminal = TerminalBuilder.terminal();
      terminal.enterRawMode();
      
      input = terminal.reader().read();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return (Character.toLowerCase((char)input));
    
  }

  public String readLine()
    {
      String fullString = "";

      while(true){
        char character = getch();
        int num = 0;
        
        if(character > 1){
          System.out.print(Character.valueOf(character));
          fullString += character;
        }
        else if(character == 27)
          break;
      }
      
      return fullString;
    }

}