package lab_3;

public class NonlinearEquation {
    private double begin;
    private double end;

    public NonlinearEquation(double begin, double end) {
            this.begin = begin;
            this.end = end;
    }

    private double getBegin() {
        return begin;
    }

    private double getEnd() {
        return end;
    }

    private double GetMidPoint() {
        return (begin + end) / 2;
    }
    private double GetValue(double x) {
        return(Math.pow(x,3)- (3 * (x * x - 1)));
    }
    public double Solve() {
        double functionBegin = getBegin();
        double functionEnd = getEnd();
        assert (functionBegin * functionEnd < 0);
        double eps = 1e-8;
        while (Math.abs(functionBegin - functionEnd) > eps) {
            double mid = GetMidPoint();
            double fMid = GetValue (mid);
            if (fMid * functionBegin < 0) {
                end = mid;
                functionEnd = fMid;
            } else if (fMid * functionEnd < 0) {
                begin = mid;
                functionBegin = fMid;
            }
        }
        return GetMidPoint();
    }

}
