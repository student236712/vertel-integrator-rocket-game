
import java.io.FileNotFoundException;

public class Tester {

    public static void main ( String[] args ) throws FileNotFoundException {
        StatekKosmiczny pendulum = new StatekKosmiczny ( );
        Analizer analizer = new Analizer ( );

        analizer.clearValues ( );

        VertelIntegrator vertelIntegrator = new VertelIntegrator ( 1 );
        vertelIntegrator.integrate ( pendulum , analizer , 0 , 5000  , -150 ,2730.14 , 1.63 , 636 , -15.5 );


        analizer.wyswietlNaKonsoliWszystko ( );

        //  System.out.println (analizer.findPeriod () );

        //analizer.saveToFile ( "C:\\Users\\Magda\\Desktop\\rakietaTester.txt" );
    }

}


