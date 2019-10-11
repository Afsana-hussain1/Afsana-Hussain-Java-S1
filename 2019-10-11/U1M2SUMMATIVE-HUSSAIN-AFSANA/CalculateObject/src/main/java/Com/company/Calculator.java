package Com.company;

public class Calculator {
    public String adding (int x, int y){
        return (x + "+" + y + "="+ (x + y));
    }
    public String subtract (int x, int y){
        return (x + "+" + y + "="+ (x+y));
    }
    public String multiply(int x, int y){
        return (x + "*" + y + "="+ (x * y));
    }
    public String divide (int x, int y) {
        return (x + "/" + y + "="+ (x/ y));
    }
    public String add (double x, double y){
        return (x + "+" + y + "="+ (x+ y));
    }
    public String subtract (double x, double y){
        return (x + "-" + y + "="+ (x - y));
    }
    public String multiply(double x, double y){
        return (x+ "*" + y + "="+ (x * y));
    }
    public String divide(double a, double b) {
        return (a + "/" + b + "="+ (a / b));
    }
}

