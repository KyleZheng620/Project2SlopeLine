import java.util.Scanner;




public class LinearEquationLogic {
    private Scanner myScanner;
    private LinearEquation coordinatePair;
    private String coordinate1;
    private String coordinate2;
    private String yesOrNo;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int xVerticalLine;








    public LinearEquationLogic(){
        coordinatePair = null;
        myScanner = new Scanner(System.in);
        coordinate1 = "";
        coordinate2 = "";
        yesOrNo = "y";
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        xVerticalLine = 0;
    }




    public void start(){
        System.out.println("Welcome to the linear equation calculator!");
        printData();
    }




    private void getCoordinates(){
        System.out.print("Enter the first coordinate point: ");
        coordinate1 = myScanner.nextLine();
        System.out.print("Enter the second coordinate point: ");
        coordinate2 = myScanner.nextLine();
        x1 = Integer.parseInt(coordinate1.substring(1,coordinate1.indexOf(",")));
        y1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf(",")+2, coordinate1.length()-1));
        x2 = Integer.parseInt(coordinate2.substring(1,coordinate2.indexOf(",")));
        y2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf(",")+2, coordinate2.length()-1));


        if (x1 != x2){
            coordinatePair = new LinearEquation(x1, y1, x2, y2);
        } else {
            xVerticalLine = x1;
            coordinatePair = null;
        }
    }


    private void printData(){
        while (yesOrNo.equals("y")){
            getCoordinates();
            if (coordinatePair != null) {
                System.out.println(coordinatePair.lineInfo());
                System.out.print("\nEnter a value for x: ");
                System.out.println("\nThe point on the line is " + coordinatePair.coordinateForX(myScanner.nextDouble()));
                myScanner.nextLine();
            } else {
                System.out.println("\nThe coordinates you have inputted form a vertical line. The line is x = " + x1 + ". \nThis line cannot be represented with y=mx+b!");
            }
            System.out.print("\nWould you like to enter another pair of coordinates? y/n: ");
            yesOrNo = myScanner.nextLine();
        }
        System.out.println("Thank you for using the slope calculator, goodbye nerd!");
    }
}


