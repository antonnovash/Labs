package lab_3;

public class NonlinearEquation {
    private double _begin;
    private double _end;
    double _eps=1e-8;

    public NonlinearEquation(double begin, double end) {
            _begin = begin;
            _end = end;
    }

    public double get_begin() {
        return _begin;
    }

    public double get_end() {
        return _end;
    }

    private double GetMidPoint() {
        return (_begin + _end) / 2;
    }
    private double GetValue(double x) {
        return(Math.pow(x,3)- (3 * (x * x - 1)));
    }
    public double Solve() {
        double fBeg = get_begin();
        double fEnd = get_end();
        assert (fBeg * fEnd < 0);
        while (Math.abs(fBeg - fEnd) > _eps) {
            double mid = GetMidPoint();
            double fMid = GetValue (mid);
            if (fMid * fBeg < 0) {
                _end = mid;
                fEnd = fMid;
            } else if (fMid * fEnd < 0) {
                _begin = mid;
                fBeg = fMid;
            }
        }
        return GetMidPoint();
    }

}
