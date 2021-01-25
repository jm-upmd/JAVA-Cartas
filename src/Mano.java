
/**
 * Un objeto de tipo Mano representa una mano de cartas.  Las
 * cartas pertenecen a la clase Carta. Una mano está vacía cuando se crea
 * ,y con posterioridad se le puede añadir un número cartas.
 */

import java.util.ArrayList;

public class Mano {

    private ArrayList<Carta> mano; // Las cartas en la mano.

    /**
     * Crea una mano inicialmente vacía.
     */
    public Mano() {
        mano = new ArrayList<Carta>();
    }

    /**
     * Borra todas las cartas de la mano, dejando esta vacía.
     */
    public void clear() {
        mano.clear();
    }

    /**
     * Añade una carta a la mano.  Es añadida al final de la mano actual.
     * @param c la carta añadida (no null).
     * @throws NullPointerException si el parámetro c es null.
     */
    public void addCarta(Carta c) {
        if (c == null)
            throw new NullPointerException("No puedes añadir una carta null a la mano.");
        mano.add(c);
    }

    /**
     * Quita una carta de la mano, si existe.
     * @param c la Carta a ser borrada.  No hace nada si c es null o la 
     * carta no está en la mano.
     */
    public void borraCarta(Carta c) {
        mano.remove(c);
    }

    /**
     * Quita la carta de la posicion especificada de la mano.
     * @param posicion la posición de la carta a borrar, donde
     * posicion comienza por cero.
     * @throws IllegalArgumentException si la posicion no existe
     * en la mano, esto es, si la posición es menor que 0 o mayor o igual que el 
     * número de cartas en la mano.
     */
    public void borraCarta(int posicion) {
        if (posicion < 0 || posicion >= mano.size())
            throw new IllegalArgumentException("Posición no existe en la mano: "
                    + posicion);
        mano.remove(posicion);
    }

    /**
     * Devuelve el número de cartas en la mano.
     */
    public int dameNumCartas() {
        return mano.size();
    }

    /**
     * Devuelve la carta especificada en la posicion de la mano.  (La carta no 
     * es borrada de la mano)
     * @param posicion la posición de la carta que ha sido devuelta
     * @throws IllegalArgumentException si posicion no existe en la mano
     */
    public Carta dameCarta(int posicion) {
        if (posicion < 0 || posicion >= mano.size())
            throw new IllegalArgumentException("Posicion no existe en la mano: "
                    + posicion);
        return mano.get(posicion);
    }

    /**
     * Ordena las cartas de la mano con las cartas del mismo palo juntas
     * ,ordenadas por su valor.
     * Notea: es as tiene el valor menor, 1.
     */
    public void ordenaPorPalo() {
        ArrayList<Carta> nuevaMano = new ArrayList<Carta>();
        while (mano.size() > 0) {
            int pos = 0;  // Posicion de la carta menor.
            Carta c = mano.get(0);  // Carta menor.
            for (int i = 1; i < mano.size(); i++) {
                Carta c1 = mano.get(i);
                if ( c1.getPalo() < c.getPalo() ||
                        (c1.getPalo() == c.getPalo() && c1.getValor() < c.getPalo() ) ){
                    pos = i;
                    c = c1;
                }
            }
            mano.remove(pos);
            nuevaMano.add(c);
        }
        mano = nuevaMano;
    }

    /**
     * Ordena cartas de la mano con las cartas por su valor. Cartas con mismo valor
     * son ordenadas por su palo.  
     * Note that aces are considered to have the lowest value, 1.
     */
    public void ordenaPorValor() {
        ArrayList<Carta> nuevaMano = new ArrayList<>();
        while (mano.size() > 0) {
            int pos = 0;  // Posición de la carta mínima.
            Carta c = mano.get(0);  // Carta mínima.
            for (int i = 1; i < mano.size(); i++) {
                Carta c1 = mano.get(i);
                if ( c1.getValor() < c.getValor() ||
                        (c1.getValor() == c.getValor() && c1.getPalo() < c.getPalo())) {
                    pos = i;
                    c = c1;
                }
            }
            mano.remove(pos);
            nuevaMano.add(c);
        }
        mano = nuevaMano;
    }

}
