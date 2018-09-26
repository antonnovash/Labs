package lab_3;

public class Test {
    public static void main(String args[]) {
        double begin = -10;
        double end = 15;
        NonlinearEquation equation = new NonlinearEquation(begin, end);
        System.out.println("Solution of the system of equations x^3-3*x^2+3=0:");
        System.out.println(equation.Solve());
    }
}
