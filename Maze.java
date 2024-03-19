// Devaansh Mann
// COMP 282 project - Maze
// March 12, 2023

import tools.*;
import java.util.*;
public class Maze {

    class Point
    {
        int x;
        int y;
    }

    Stack <Point> S = new Stack<>();

    int xMouse, yMouse;

    int Card[][] = 
    {
        {91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91},
        {91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91},
        {0,0,0,0,0,0,0,0,0,0,0,0,25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,91,91},
        {91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,0,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91},
        {91,91,91,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,91,91},
        {91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,0,91,91,91,91,91,91,91,91,91,91,91,91,91,91},
        {91,91,91,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,91,91},
        {91,91,91,0,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,0,91,91},
        {91,91,91,25,0,0,0,0,0,0,0,0,25,0,0,0,0,0,0,0,0,0,0,0,0,25,0,91,0,25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,25,91,91},
        {91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,0,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91},
        {91,91,91,0,0,0,0,0,91,0,0,0,0,0,0,0,0,0,25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,25,0,0,91,91},
        {91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,0,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91},
        {91,91,91,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,25,0,0,0,0,91,0,0,0,0,0,25,0,0,0,0,91,91},
        {91,91,91,91,91,91,91,91,0,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,0,91,91},
        {91,91,91,0,0,0,0,0,0,0,25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,91,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,91,91},    
        {91,91,91,0,91,91,91,91,91,91,91,91,91,91,91,91,0,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,0,91,91},
        {91,91,91,25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,91,0,0,0,0,0,0,0,0,0,0,0,0,25,0,0,0,0,0,0,0,0,0,0,0,91,91},
        {91,91,91,0,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,0,91,91},
        {91,91,91,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,91,91},
        {91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,0,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91},
        {91,91,91,0,0,0,0,0,0,0,0,0,0,0,0,0,0,25,0,0,0,0,0,0,0,0,0,0,0,0,25,0,0,0,0,0,91,0,0,0,0,0,0,0,0,0,0,0,91,91},
        {91,91,91,91,91,0,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91},
        {91,91,91,0,0,0,0,0,0,0,0,91,0,0,0,0,0,25,0,0,0,91,0,0,0,0,0,0,0,0,0,91,0,0,0,0,0,0,0,91,0,0,0,0,0,0,0,0,91,91},
        {91,91,91,0,0,0,91,0,0,0,0,0,0,0,0,0,91,0,0,0,0,0,25,0,0,0,91,0,0,0,0,0,0,0,0,91,0,0,0,0,25,0,0,0,91,0,0,0,0,0},   //EXIT
        {91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91},
        {91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91},

    };


    public void cls()

    {

        // clearing the screen

        System.out.print("\033[H\033[2J");  

        System.out.flush(); 

    }

    public static void printxy(int col, int row, char val)

    {

        char escCode = 0x1B;

        System.out.print(String.format("%s[%d;%df",escCode,row,col));

        System.out.print(val);

    }

    public static void printxy(int col, int row, String val)

    {

        char escCode = 0x1B;

        System.out.print(String.format("%s[%d;%df",escCode,row,col));

        System.out.print(val);

    }

    void DisplayCard(int x, int y)

    {

        for (int i = 0; i < 25; i++)

        {

            for (int j = 0; j < 50; j++)

            {

                if (Card[i][j] == 0)

                    
                    printxy(x + j, y + i, " ");
 
                else

                    printxy(x + j, y + i , Symbols.EXTENDED[Card[i][j]]);


                
            }

            System.out.println(" ");

        }

    }

    void DisplayMouse()
    {

        printxy(xMouse, yMouse, "X");

    }

    void HideMouse()

    {

        printxy(xMouse, yMouse, " ");
    
    }

    boolean ThisPathNotTaken(int FutureX , int FutureY)
    {
        if (S.empty()) 
        {
            return true;    
        }
        

        Point P;
        P = S.peek();

        if (P.x == FutureX && P.y == FutureY) 
        {
            return false;
        }
        return true;
    }

    void CalculateNextMove()
    {

        
        if ((Card[yMouse][xMouse+1] == 0) && ThisPathNotTaken(xMouse + 1, yMouse))
        {
            Point P = new Point();
            P.x = xMouse;
            P.y = yMouse;
            S.push(P);

            xMouse++;    
        }
        
        else if((Card[yMouse+1][xMouse] == 0) && ThisPathNotTaken(xMouse, yMouse + 1))
        {
            Point P = new Point();
            P.x = xMouse;
            P.y = yMouse;
            S.push(P);

            yMouse++;
        }

        else if((Card[yMouse-1][xMouse] == 0) && ThisPathNotTaken(xMouse, yMouse - 1))
        {
            Point P = new Point();
            P.x = xMouse;
            P.y = yMouse;
            S.push(P);

            yMouse--;
        }

        else if((Card[yMouse][xMouse-1] == 0) && ThisPathNotTaken(xMouse - 1, yMouse))
        {
            Point P = new Point();
            P.x = xMouse;
            P.y = yMouse;
            S.push(P);

            xMouse--;
        }

        else if (Card[yMouse][xMouse+1] == 25 && ThisPathNotTaken(xMouse + 1, yMouse)) 
        {
            Point P = new Point();
            P.x = xMouse;
            P.y = yMouse;
            S.push(P);
            
            xMouse++;    
        } 

        else if (Card[yMouse+1][xMouse] == 25 && ThisPathNotTaken(xMouse , yMouse + 1)) 
        {
            Point P = new Point();
            P.x = xMouse;
            P.y = yMouse;
            S.push(P);
            
            yMouse++;    
        } 

        else if (Card[yMouse][xMouse-1] == 25 && ThisPathNotTaken(xMouse - 1, yMouse)) 
        {
            Point P = new Point();
            P.x = xMouse;
            P.y = yMouse;
            S.push(P);
            
            xMouse--;    
        } 

        else if (Card[yMouse-1][xMouse] == 25 && ThisPathNotTaken(xMouse , yMouse - 1)) 
        {
            Point P = new Point();
            P.x = xMouse;
            P.y = yMouse;
            S.push(P);
            
            yMouse--;    
        } 

        else
        {
            Card[yMouse][xMouse] = 91;
            Point P = S.pop();
            yMouse = P.y;
            xMouse = P.x;
        }

    }

    

    public void Play()
    {

        cls();

        System.out.println("INITIATING THE MAZE CLEARING PROCESS IN...");

        try 
            {

                Thread.sleep(1000);
                
            } 
            catch (Exception e) 
            {
                
                System.out.println(e);
 
            }

        System.out.println("5");

        try 
            {

                Thread.sleep(1000);
                
            } 
            catch (Exception e) 
            {
                
                System.out.println(e);
 
            }

        System.out.println("4");

        try 
            {

                Thread.sleep(1000);
                
            } 
            catch (Exception e) 
            {
                
                System.out.println(e);
 
            }

        System.out.println("3");

        try 
            {

                Thread.sleep(1000);
                
            } 
            catch (Exception e) 
            {
                
                System.out.println(e);
 
            }

        System.out.println("2");

        try 
            {

                Thread.sleep(1000);
                
            } 
            catch (Exception e) 
            {
                
                System.out.println(e);
 
            }

        System.out.println("1");

        try 
            {

                Thread.sleep(1500);
                
            } 
            catch (Exception e) 
            {
                
                System.out.println(e);
 
            }

        DisplayCard(0,0);

        xMouse = 0;

        yMouse = 2;

        while(xMouse != 49 && yMouse != 24)
        {

            DisplayMouse();

            try 
            {

                Thread.sleep(20);
                
            } 
            catch (Exception e) 
            {
                
                System.out.println(e);
 
            }
            
            HideMouse();
            CalculateNextMove();

        }

        System.out.println("   THE MAZE IS NOW CLEAR AND READY TO USE!    ");     
        
        System.out.println();    
                    

    }

}