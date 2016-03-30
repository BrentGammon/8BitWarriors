/**
 * Write a description of class MathHelper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MathHelper  
{
    public static  double quadraticEquationRoot1(double a, double b, double c){    
        double root1, root2; //This is now a double, too.
        root1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
        root2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
        return Math.max(root1, root2);  
    }

    public static double quadraticEquationRoot2(double a, double b, double c){    
        double root1, root2; //This is now a double, too.
        root1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
        root2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
        return Math.max(root1, root2);  
    }
    
    public static double trajectoryEquationRoot1(double v, double g, double x, double y){
        double root1, root2;
        return
            (Math.pow(v,2)+Math.sqrt( Math.pow(v,4) - (g*( (g*Math.pow(x,2))+(2*y*Math.pow(v,2)) )  ) ))
            /
            g*x;
    }
    public static double trajectoryEquationRoot2(double v, double g, double x, double y){
        double root1, root2;
        return
            (v*v-Math.sqrt( v*v*v*v - (g*g*x*x) + (g*2*y*v*v) ) )
            /
            g*x;
    }
    
    
}
