public class StatekKosmiczny implements CalculateAcceleration {
    @Override
    public double a ( double m , double u,double g,double k ) {
        return -g-(k*(u/m));
    }
}
