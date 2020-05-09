
public class VertelIntegrator {
    double tStart;
    double hStart; //wysokość początkowa
    double hStop; //wysokość horyzontu
    double mStart; //masa całkowita początkowa
    //  double mStop; //masa całkowita końcowa
    double vStart; //prędkość początkowa
    double g; //stała
    double k; //stała
    double u; //zmiennna siła ciągu


    double step; //krok całkowania

    public VertelIntegrator ( double step ) {
        this.step = step;
    }


    public void integrate ( CalculateAcceleration calculateAcceleration , ODEUpdate odeUpdate ,
                            double tStart , double hStart , double vStart , double mStart , double g , double k , double u ) {

        //int nSteps = (int) ((tStop - tStart) / step);
        double t = tStart;
        double m = mStart;
        double v = vStart;
        double h = hStart;
        double a = calculateAcceleration.a ( m , u , g , k );


        while (h >= 0) {
            System.out.println ( "step: " + step );
            double vHalf = v + step * a / 2;
            double mNew = m + step * u;

            double aNew = calculateAcceleration.a ( mNew , u , g , k );
            double vNew = v + step * (a + aNew) / 2;
            //  double hNew=h+step*vNew;
            a = aNew;
            double hNew = h + step * vHalf;
            t += step;
            m = mNew;
            v = vNew;
            h = hNew;
            odeUpdate.update ( t , m , v , h );
            if (m < 1000) {
                u = 0;
            }

        }


    }
}
