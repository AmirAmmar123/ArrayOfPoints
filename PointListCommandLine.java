import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

/** Editor Amir Ammar
 * Computer Science
 * Intro to Algorithms
**/
public class PointListCommandLine  {
    private final ArrayPointList arrayPoint;
    private static Scanner scanner;

    public PointListCommandLine() {
        this.arrayPoint = new ArrayPointList();
    }

    public void addXY(Point p) throws IOException {
        Point vertex;
        if(p != null){
            arrayPoint.append(p);
        }else{
            InputStreamReader reader = new InputStreamReader(System.in);
            StreamTokenizer tokens = new StreamTokenizer(reader);
            while ((tokens.nextToken()) != StreamTokenizer.TT_WORD){
                vertex = new Point();
                vertex.x = (int)tokens.nval;
                tokens.nextToken();
                vertex.y = (int)tokens.nval;
                arrayPoint.append(vertex);
            }
        }
    }

    public void curr(){
        if (!arrayPoint.isEmpty()) {
            Point vertex = arrayPoint.getCursor();
            System.out.println("(" + vertex.x + ", " + vertex.y + ")");
        }
    }

    public void next(){System.out.println(arrayPoint.goToNext());}

    public void prev(){System.out.println(arrayPoint.goToPrior());}

    public void start(){
        System.out.println(arrayPoint.goToBeginning());
    }

    public void end(){System.out.println(arrayPoint.goToEnd());}

    public void empty(){
        System.out.println(arrayPoint.isEmpty());
    }

    public void full(){
       System.out.println(arrayPoint.isFull());
    }

    public void clear(){arrayPoint.clear();}

    public void quit(){
        scanner.close();
        System.exit(0);
    }


    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        PointListCommandLine arrayPoint = new PointListCommandLine();


        while(true){
            String choice = scanner.next();

           switch(choice){
               case "quit":
                   arrayPoint.quit();
                   break;
               case "add":
                   Point p = null;
                   if(scanner.hasNext()){
                       int x = scanner.nextInt();
                       int y = scanner.nextInt();
                       p = new Point(x, y);
                   }
                   arrayPoint.addXY(p);
                   break;
               case "curr":
                   arrayPoint.curr();
                   break;
               case "next":
                   arrayPoint.next();
                   break;
               case "prev":
                   arrayPoint.prev();
                   break;
               case "start":
                   arrayPoint.start();
                   break;
               case "end":
                   arrayPoint.end();
                   break;
               case "empty":
                   arrayPoint.empty();
                   break;
               case "full":
                   arrayPoint.full();
                   break;
               case "clear":
                   arrayPoint.clear();
                   break;
           }
        }

    }

}
