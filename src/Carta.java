/**
 * Un objeta de tipo carta representa una carta de una baraja de pocker,
 * incluyendo comodines. La carta tiene un palo,que puede ser espadas, corazones,
 * diamantes, bastos, o comodín. Una espada, corazón, diamante, o basto tiene uno de
 * los siguietes 13 valores: as, 2, 3, 4, 5, 6, 7, 8, 9, 10, sota, reina, o rey. 
 * Notar que "as" se considera el valor más pequeño. Un comodín puede tener
 * también un valor asociado, que puede ser cualquiera.  
 */

public class Carta {
	
	// Códigos para las cuatro palos, mas comodín.
	public final static int ESPADAS = 0; 
	public final static int CORAZONES = 1;
	public final static int DIAMANTES = 2;
	public final static int BASTOS = 3;
	public final static int COMODIN = 4;
	
	// Códigos para las cuatro figuras y el as.
	// Los códigos para las cartes del 2 a la 10 son
	// sus propios valores numéricos.
	public final static int AS = 1; 
	public final static int SOTA = 11; 
	public final static int REINA = 12; 
	public final static int REY = 13;

	/**
	 * El palo de esta carta, una de las constantes ESPADAS, CORAZONES, DIAMANTES,
	 * BASTOS, COMODIN. El palo no puede ser cambiado una vez que la carta ha sido
	 * construida.
	 */

	private final int palo;

	/**
	 * El valor de la carta. Para una carta normal, es uno de los valores de 1 a 13,
	 * con el 1 representando al AS. Para un comodión, el valor puede ser cualquiera
	 * de ellos. El valor no puede ser cambiado una vez que la carta ha sido
	 * construida
	 */
	
	private final int valor;
	
	//*** CONSTRUCTORES

	/**
	 * Crea un comodín, con 1 como valor. (Observar que "new Carta()" es equivalente
	 * a "new Carta(1,Carta.COMODIN)")
	 */
	public Carta() {
		palo = COMODIN;
		valor = 1;
		// Las dos líneas de arriba se pueden sustituir por esta, que
		// es una llamada al otro constructor pasándole los valores de
		// inicialización:
		// this(1,COMODIN);
	}

	/**
	 * Crea la carta con su palo y valor.
	 * 
	 * @param valor el valor de la nueva carta. Para una carta normal (no comodín),
	 *              el valor debe estar en el ranto 1 a 13, donde 1 representa un
	 *              As. Puedes usar las constantes Carta.AS, Carta.SOTA,
	 *              Carta.REINA, y Carta.REY para el as y las figuras. Para un comodión el
	 *              valor puede ser cualquiera.
	 * @param palo  el palo de la nueva carta. Debe ser un de los valores
	 *              Carta.ESPADAS, Carta.CORAZONES, Carta.DIAMANTES, Carta.BASTOS, o
	 *              Carta.COMODIN.
	 * @throws IllegalArgumentException si el parámetro valor ne esta en el rango
	 *                                  permitido.
	 */
	public Carta(int valor, int palo) {
		
		if (palo != ESPADAS && palo != CORAZONES && palo != DIAMANTES && palo != BASTOS && palo != COMODIN)
			throw new IllegalArgumentException("Palo de carta ilegal");
		if (palo != COMODIN && (valor < 1 || valor > 13))
			throw new IllegalArgumentException("Valor de la carta ilegal");

		// Valores son consistentes, entonces se asignan y crea objeto.
		// Una constante se puede asignar una primera vez desde un constructor.
		this.valor = valor; // le asigna a la constante de la clase el valor
		this.palo = palo; // le asigna a la constante de la clase el palo
	}

	/**
	 * Devuelve el palo de esta carta
	 * 
	 * @returns el palo, el cual es una de las constantes Carta.ESPADAS,
	 *          Carta.CORAZONES, Carta.DIAMENTES, Carta.Bastos, or Carta.COMODIN
	 */
	public int getPalo() {
		return palo;
	}

	/**
	 * Devuelve el valor de esta carta.
	 * 
	 * @return el valor, el cual es un número entre 1 y 13 inclusive para una carta
	 *         normal, y que puede ser el valor de un comodín.
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Devuelve un string que representa el nombre del palo de la carta.
	 * 
	 * @return uno de los strings "Espadas", "Corazones", "Diamantes", "Bastos" o
	 *         "Comodín".
	 */
	public String damePaloComoString() {
		switch (palo) {
		case ESPADAS:
			return "Espadas";
		case CORAZONES:
			return "Corazones";
		case DIAMANTES:
			return "Diamantes";
		case BASTOS:
			return "Bastos";
		default:
			return "Comodín";
		}
	}

	/**
	 * Devuelve un String representando el valor de la carta.
	 * 
	 * @return para una carta normal, uno de los strings "As", "2", "3", ..., "10",
	 *         "Sota", "Reina", o "Rey". Para un comodín, el string es siempre numérico.
	 *         numerical.
	 */
	public String dameValorComoString() {
		if (palo == COMODIN)
			return "" + valor;   // equivalente a return String.valueOf(valor); 
		else if (valor >= 2 && valor <= 10){
			return "" + valor;
		} else {
			switch (valor) {
			case 1:
				return "As";
			case 11:
				return "Sota";
			case 12:
				return "Reina";
			default:
				return "Rey";
			}
		}
	}

	/**
	 * Devuelve un string representando la carta, incluye el palo y su valor
	 *  (excepto para un comodión con valor 1, para el que devuelve solo el valor
	 * "Comodín"). Ejemplos de valor devuelto: "Reina de Corazones", "10 de Diamantes", "As
	 * de Espadas", "Comodín", "Comodín #2"
	 */
	public String toString() {
		if (palo == COMODIN) {
			if (valor == 1)
				return "Comodín";
			else
				return "Comodín #" + valor;
		} else
			return dameValorComoString() + " de " + damePaloComoString();
	}

} // fin clase carta
