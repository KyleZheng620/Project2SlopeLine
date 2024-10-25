public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private double distance;
    private String slopeFraction;








    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        distance = 0;
        slopeFraction = "";
    }








    public double Distance() {
        distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return Math.round(distance * 100) / 100.0;
    }








    public double yIntercept() {
        return (y1 - x1 * slope());
    }








    public double slope() {
        return roundedToHundredth((y2 - y1) / (x2 - x1 * 1.0));
    }




    public int GCD(int a, int b){
        if (b==0) {
            return a;
        }
        return GCD(b,a%b);
    }




    public String equation() {
        if ((y2-y1)%(x2-x1)!=0) {
            int gcd = GCD((y2 - y1), (x2 - x1));
            if (slope()<0) {
                slopeFraction = "(-" + Math.abs((y2 - y1)/gcd) + "/" + Math.abs((x2 - x1)/gcd) + ")";
            } else {
                slopeFraction = "(" + Math.abs((y2 - y1)/gcd) + "/" + Math.abs((x2 - x1)/gcd) + ")";
            }
        } else {
            if (slope() == 1.0) {
                slopeFraction = "";
            } else if (slope() == -1.0) {
                slopeFraction = "-";
            } else {
                slopeFraction =(y2-y1)/(x2-x1)+"";
            }
        }
        if (slope() == 0){
            return "y = " + yIntercept();
        } else if (yIntercept()<0){
            return "y = " + slopeFraction + "x " + "- " + Math.abs(yIntercept());
        } else if (yIntercept()==0){
            return "y = " + slopeFraction + "x";
        } else {
            return "y = " + slopeFraction + "x" + " + " + yIntercept();
        }
    }




    public String coordinateForX(double x){
        double y = slope() * x + yIntercept();
        return "(" + roundedToHundredth(x) + ", " + roundedToHundredth(y) + ")";
    }




    public String lineInfo(){
        return ("\nThe points are (" + x1 + ", " + y1 + ") and " + "(" + x2 + ", " + y2 + ")\n"
                + "The equation of the line between these points is: " + equation() +
                "\nThe y-intercept of this line is: " + yIntercept() +
                "\nThe slope of this line is: " + slope() +
                "\nThe distance between these points is " + Distance());
    }




    private double roundedToHundredth(double toRound){
        return Math.round(toRound * 100.0)/100.0;
    }
}


