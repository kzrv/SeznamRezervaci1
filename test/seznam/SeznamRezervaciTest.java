package seznam;

import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author karel@simerda.cz
 */
public class SeznamRezervaciTest {

    static final Rezervace R1 = new Rezervace(1);
    static final Rezervace R2 = new Rezervace(2);
    static final Rezervace R3 = new Rezervace(3);
    static final Rezervace R4 = new Rezervace(4);
    static final Rezervace R5 = new Rezervace(5);
    static final Rezervace R6 = new Rezervace(6);

    static final Rezervace R1klon = new Rezervace(1);
    
    public SeznamRezervaciTest() {
    }

    @Test
    public void testKonstruktlor() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        assertEquals(0, seznam.size());
    }

    @Test
    public void testVloz01() {

        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1);
        assertEquals(1, seznam.size());
    }

    @Test
    public void testVloz02() {

        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1, R2);
        assertEquals(2, seznam.size());
    }

    @Test
    public void testVloz03() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1,R2,R3,R4,R5,R6);
        assertEquals(6, seznam.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVloz04() {
        Rezervace rezervace = null;
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(rezervace);
        fail();
    }

    @Test(expected = IllegalAccessError.class)
    public void testDej01PrazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.dej(1);
        fail();
    }

    @Test(expected = IllegalAccessError.class)
    public void testDej02PrazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.dej(0);
        fail();
    }

    @Test
    public void testDej03NeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1);
        Rezervace result = seznam.dej(1);
        assertEquals(R1, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDej04NeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1);
        seznam.dej(0);
        fail();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDej05NeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1);
        seznam.dej(2);
        fail();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDej06NeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1);
        seznam.dej(-1);
        fail();
    }



    /**
     * Tato varianta porovnává dvě odlišné instance se stejným obsahem. Máme
     * překrytou metodu equals.
     */
    @Test
    public void testDej07cNeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1);
        Rezervace result = seznam.dej(1);
        assertEquals(R1klon, result);
    }

    /**
     * Ukázka chování metody equals, zde se porovnává obsah dvou instancí
     */
    @Test
    public void testDej07dNeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1);
        Rezervace result = seznam.dej(1);
        assertTrue(R1klon.equals(result));
    }

    /**
     * Ukázka chování operátoru porovnání ==, zde se porovnávají reference
     */
    @Test
    public void testDej07eNeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1);
        Rezervace result = seznam.dej(1);
        assertFalse(R1klon == result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDej08NeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1, R2);
        seznam.dej(3);
        fail();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDej09NeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1, R2, R1, R3, R4, R2);
        seznam.dej(7);
        fail();
    }

    @Test(expected = IllegalAccessError.class)
    public void testOdeber01PrazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.odeber(1);
        fail();
    }

    @Test(expected = IllegalAccessError.class)
    public void testOdeber02PrazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.odeber(0);
        fail();
    }

    @Test(expected = IllegalAccessError.class)
    public void testOdeber03PrazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.odeber(-1);
        fail();
    }

    @Test(expected = IllegalAccessError.class)
    public void testOdeber04PrazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.odeber(2);
        fail();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOdeber04NeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1);
        seznam.odeber(2);
        fail();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOdeber05NeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1);
        seznam.odeber(0);
        fail();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOdeber06NeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1);
        seznam.odeber(-1);
        fail();
    }

    @Test
    public void testOdeber07NeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1);
        Rezervace result = seznam.odeber(1);
        assertEquals(R1, result);
    }

    @Test
    public void testOdeber08NeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1, R2);
        Rezervace result = seznam.odeber(1);
        assertEquals(R1, result);
    }

    @Test
    public void testOdeber09NeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1, R2);
        Rezervace result = seznam.odeber(2);
        assertEquals(R2, result);
    }

    @Test
    public void testOdeber10NeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1);
        seznam.odeber(1);
        assertEquals(0, seznam.size());
    }



    @Test
    public void testOdeber12NeprazdnySeznam() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1, R2);
        seznam.odeber(1);
        assertEquals(1, seznam.size());
    }

    @Test
    public void testZrus01() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.zrus();
        assertEquals(0, seznam.size());
    }

    @Test
    public void testZrus02() {
        SeznamRezervaci seznam = new SeznamRezervaci(1);
        seznam.vloz(R1);
        seznam.zrus();
        assertEquals(0, seznam.size());
    }

   

}
