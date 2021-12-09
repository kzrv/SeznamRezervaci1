
package seznam;

/**
 *
 * @author kasi0004
 */
public class Rezervace {
    final int id;
    final String datum;

    public Rezervace(int id, String datum) {
        this.id = id;
        this.datum = datum;
    }
    
    public Rezervace(int id) {
        this.id = id;
        this.datum = "";
    }

    public int getId() {
        return id;
    }

    public String getDatum() {
        return datum;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rezervace other = (Rezervace) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
