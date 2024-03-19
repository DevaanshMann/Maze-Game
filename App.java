import tools.*;

public class App
{    
    public static final char getAscii(int code) 
    {
            return Symbols.EXTENDED[code];
    }

    public static final void printChar(int ascii) 
    {
        System.out.printf("%c%n", getAscii(ascii) );
    }
    
    public static void printxy(int col, int row, String val)
    {
        char escCode = 0x1B;
        System.out.print(String.format("%s[%d;%df",escCode,row,col));
        System.out.print(val);
    }
    
    public static void Box(int x, int y, int w, int h, int ascii, String fontcolor,String bgcolor)
    {
        char val = getAscii(ascii);
        for (int i=0; i < w; i++)
        {
            for (int j=0; j< h; j++)
            {
                
                printxy(x+i,y+j,fontcolor + bgcolor + val);
            }
        }
    }

    public static void main(String[] args) 
    {

        Maze M = new Maze();
        M.Play();

        while (true);
    }
}




