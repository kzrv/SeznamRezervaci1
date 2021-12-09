package seznam;

/**
 *
 * @author karel@simerda.cz
 */
public class SeznamRezervaci {

    private Rezervace[] seznam;
    private int pocet;

    /**
     * Konstruktor na vytvoření seznamu rezervací.
     *
     * @param velikost tento parametr musí kladné číslo, které udává
     * inicializační velikost pole se seznamem rezervací
     *
     * @throws IllegalArgumentException tato výjimka se vystaví, když je
     * parametr předává hodnotu velikosti pole nula nebo je když je záporná
     */
    public SeznamRezervaci(int velikost) throws IllegalArgumentException {
        if (velikost<=0){
            throw new IllegalArgumentException("Zaporna,nebo nulova velikost pole");
        }
       else seznam = new Rezervace[velikost];
    }

    /**
     * Metoda vloží do seznamu rezervaci na konec seznamu
     *
     * Jestliže metoda zjistí před vložením odkazu do seznamu(pole), že se
     * vyčerpala kapacita vnitřního pole, tak toto pole zvětší na dvojnásobek a
     * překopíruje do něj všechny odkazy původního pole.
     *
     * Metoda mění aktuální počet rezervacív seznamu.
     *
     * Metoda nekontroluje, zda již byl stejná instance do seznamu vložen!
     *
     * @param rezervace parametr s odkazem na vkládaná rezevace
     *
     *
     * @throws IllegalArgumentException tato výjimka se vystaví když, je v
     * parametru není odkaz na objekt, tj. parametr obsahuje null
     */
    public void vloz(Rezervace rezervace) throws IllegalArgumentException {
        if (rezervace==null) {
            throw new IllegalArgumentException("Zaporna,nebo nulova velikost pole");
        }
        if (pocet==seznam.length){
            rozsireniSeznamu();
        }
        seznam[pocet] = rezervace;
        pocet++;

    }
    
    public void vloz (Rezervace... seznam) {
        for (Rezervace r : seznam) {
            vloz(r);
        }
    }

    /**
     * Metoda vrátí v návratové hodnotě odkaz na rezervace, který je adresován
     * hodnotu v parametru.
     *
     * @param pozice v parametru je hodnota pozice prvku v seznamu, první prvek
     * pole je adresován číslem 1.
     *
     * @return vrací odkaz na rezervace podle hodnoty v parametru pozice
     *
     * @throws IndexOutOfBoundsException tato výjimka se vystaví, když hodnota
     * parametru pozice je mimo povolený rozsah, který je dán naplněností
     * seznamu rezervací. Výjimka dodá tento text¨: "Parametr pozice je mimo
     * povoleny rozsah."
     *
     * @throws IllegalAccessError tato výjimka se vystaví, když je seznam
     * prázdný. Výjimka dodá tento text: "Nepovolená operace, protože seznam je
     * prázdný."
     *
     * XXX Poznámka k implementaci: Při kontrole dvou parametrů může být
     * vystavování výjimek závislé na pořadí kontrol. Zde se může docházet, že
     * výjímky budou závislé na tom, zda je seznam prázdný nebo ne. Proto
     * kombinujte vystavování výjimek tak, abyste vyhověli testům. Přednost má
     * kontrola, zda seznam prázdný nebo ne a potom teprve kontrola, zda je
     * pozice v povoleném rozsahu.
     */
    public Rezervace dej(final int pozice) throws IndexOutOfBoundsException, IllegalAccessError {
        if (pozice> seznam.length || pozice< seznam.length || (pozice >=seznam.length && pocet!=pozice)){
            throw new IllegalAccessError();
        }
//       if (seznam[pozice - 1]==null){
//           throw new IllegalAccessError();
//       }

       else return seznam[pozice];
    }

    /**
     * Metoda odebere odkaz na rezervaci ze seznamu, který je dán
     * adresován hodnotou v parametru pozice
     *
     * Metoda mění aktuální počet rezervací.
     *
     * @param <error>
     * @param pozice v parametru je hodnota pozice prvku v seznamu, první prvek
     * pole je adresován číslem 1.
     *
     *     *
     * @return vrací odkaz na rezervaci podle hodnoty v parametru pozice
     *
     * @throws IndexOutOfBoundsException tato výjimka se vystaví, když hodnota
     * parametru pozice je mimo povolený rozsah, který je dán naplněností
     * seznamu rezervací. Výjimka dodá tento text¨: "Parametr pozice je mimo
     * povoleny rozsah."
     *
     * @throws IllegalAccessError tato výjimka se vystaví, když je seznam
     * prázdný. Výjimka dodá tento text: "Nepovolená operace, protože seznam je
     * prázdný."
     *
     * XXX Poznámka k implementaci: Platí to samé jako u metody dej.
     */
    public Rezervace odeber(final int pozice)
            throws IndexOutOfBoundsException, IllegalAccessError {
        return null;
    }

    /**
     * Metoda vrací aktuální počet rezervací v seznamu
     *
     * @return hodnota s počtem rezervací v seznamu
     */
    public int size() {
        return pocet;
    }


    /**
     * Metoda zruší všechny položky v seznamu.
     */
    public void zrus() {
        
    }


    /* ====================================================================== */
    /**
     * Metoda provede rozšíření velikosti pole na dvojnásobek původní délky
     */
    private void rozsireniSeznamu() {
        Rezervace[] seznam1 = new Rezervace[seznam.length+1];
        for (int i=0; i< seznam.length; i++){
            seznam1[i+1]=seznam[i];
        }
        seznam=seznam1;
    }

    /**
     * Metoda provede posun části pole, které začíná na pozici index. Výsledkem
     * musí být souvislé obsazení pole odkazy od pozice nula až do aktivního
     * počtu položek v poli. Všechny zbylé buňky pole až jeho velikosti musí
     * obsahovat pouze null.
     *
     * Metoda musí vyřešit problém, když se bude index ukazovat na poslední
     * prvek pole.
     *
     * @param index
     */
    private void posunSeznam(int index) {
        
    }

    /**
     * Pomocná metoda, která zkontroluje, zda hodnota parametru je v rozsahu
     * naplnění pole s odkazy na instance rezervací.
     *
     * @param index
     * @return vrací true, když je hodnota v parametru index v rozsahu naplněné
     * části seznamu na poli, jinak vrací false
     */
    private boolean kontrolaIndexu(int index) {
        return false;
    }

}
