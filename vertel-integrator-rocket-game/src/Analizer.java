import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Double.*;
import static java.lang.String.*;

public class Analizer implements ODEUpdate {

    ArrayList<Double> tValues = new ArrayList<> ( );
    ArrayList<Double> mValues = new ArrayList<> ( );
    ArrayList<Double> vValues = new ArrayList<> ( );
    ArrayList<Double> hValues = new ArrayList<> ( );

    public void clearValues ( ) {
//metoda pozwalająca wyczyścić listy tablicowe przed utworzeniem nowego obiektu
        //pozwala to zapobiec dopisaniu wartości obliczonych dla nowego obiektu do poprzednich
        tValues.clear ( );
        mValues.clear ( );
        vValues.clear ( );
        hValues.clear ( );


    }


    void wyswietlNaKonsoliWszystko ( ) {
//metoda pozwalająca wyświetlić na konsoli wszystkie obliczone wartości w
// kolumnach o kolejności od lewej: czas,położenie kątowe, prędkość kątowa, energia mechaniczna, okres

        for (int i = 0; i < tValues.size ( ); i++) {
            System.out.println ( "Czas: "+tValues.get ( i ) + ", masa:" + mValues.get ( i ) + ", prędkość: " + vValues.get ( i ) + ", wysokość: " + hValues.get ( i ) );
        }


    }

    void wyswietlNaKonsoli ( ArrayList list ) {
//metoda pozwalająca wyświetić wartości jednej z list np. wartości energii

        for (int i = 0; i < tValues.size ( ); i++) {
            System.out.println ( list.get ( i ) );
        }
    }


    void saveToFile ( String string ) throws FileNotFoundException {
        //metoda pozwalająca zapisać wszystkie obliczone wartości w kolumnach
        // o kolejności od lewej: czas,położenie kątowe, prędkość kątowa, energia mechaniczna,okres
        // do pliku tekstowego o ścieżce podanej jako parametr
        PrintWriter zapis = new PrintWriter ( string );

        for (int i = 0; i < tValues.size ( ); i++) {

            zapis.println ( tValues.get ( i ) + "," + mValues.get ( i ) + "," + vValues.get ( i ) + "," + hValues.get ( i ) );

        }


        zapis.close ( );

    }



    @Override
    public void update ( double t , double m , double v ,double h) {
        tValues.add ( t );
        mValues.add ( m );
        vValues.add ( v );
    hValues.add ( h );
    }
}



