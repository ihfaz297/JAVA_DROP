

public class Calc {
    Calc(){}
    int add(int... v){int sum=0;for(int i: v) sum+= i; return sum;}
    double add(double a, double b){return a+b;}
    String add(String p, String q){return p+q;}
    String kind(){return "";}
}
