
import java.util.Scanner;



/**
 * Este programa permite jugar a MayorMenor, un sencillo juego de cartas
 * que es descritro en la sentencia de salida al comienzo del método main.  
 * Después de que el usuario juegue varias partidas se emite la puntuación media.
 */
public class CartaMayorOMenor {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		   
	      System.out.println("Este programa te permite jugar a un sencillo juego ");
	      System.out.println("de cartas. Extrae un carta de la baraja");
	      System.out.println("y tienes que predecir si la siguinete carta de la baraja");
	      System.out.println("es mayor o menor. Tu puntuación en el juego es el número de");
	      System.out.println("predicciones correctas realizadas antes de hacer una incorrecta.");
	      System.out.println();
	      
	    
	      
	      int partidasJugadas = 0;     // Número partidas que usuario ha jugado
	      int sumDePuntuaciones = 0;     // Suma de las puntuaciones de todas las tiradas jugadas. 
	                                    
	      double puntuacionMedia;     // Puntuación media, calculada como
	                               //      sumaDePuntuaciones dividido entre partidasJugadas.
	      char otraPartida;       // Guarda la respuesta del usuario cuando se le pregunta si 
	                               //   quiere jugar otra partida.
	                              
	      
	      do {
	         int puntuacionPartida;        // Puntuación de la partida
	         puntuacionPartida = jugar();   // Juega la partida y obtiene la puntuación
	         sumDePuntuaciones += puntuacionPartida;
	         partidasJugadas++;
	         System.out.print("¿Jugar otra vez (S/N)? ");
	         otraPartida = Character.toUpperCase(scanner.next().charAt(0));
	      } while ( otraPartida == 'S');
	      
	      puntuacionMedia = ((double)sumDePuntuaciones) / partidasJugadas;
	      
	      System.out.println();
	      System.out.println("Has jugado " + partidasJugadas + " partidas.");
	      System.out.printf("Tu puntuacón media es %1.3f.\n", puntuacionMedia);
	   
	   }  // end main()
	   

	   /**
	    * Permite al usaurio jugar una partida de MayorMenor, y devuelve
	    * la puntuación del usuario en la partida. La puntuación es el número de
	    * predicciones correctas que el usuario realiza.
	    */
	   private static int jugar() {
	   
	      Baraja baraja = new Baraja();  // Obtiene una nueva barajas de cartas, y 
	                                 //   y guarda una referencia a ella en la
	                                 //   variable, baraja.
	      
	      Carta cartaActual;  // La carta actual, que el usuario ve.

	      Carta siguienteCarta;   // La siguiente carta de la barja.  El usuario intenta
	                             //    adivinar si es mayor or menor que la carta actua.
	                      

	      int prediccionCorrecta ;  // El número de predicciones correctas que
	                            //   el usuario ha realizado. Al final del partida
	                            //   esta será la puntuación del usuario.

	      char prediccion;   // Predicción del usuario.  'G' si usuario predice que
	                    //   la siguiente carta será mahyor, 'P' si el usuario predice
	                    //   que esta será menor.
	      
	      baraja.barajar();  // Mezcla las cartas de la braja de forma aleatoria
	      					//antes de comenzar una nueva partida.
	                       

	      prediccionCorrecta = 0;
	      cartaActual = baraja.extraeCarta();
	      System.out.println("La primera carta es " + cartaActual);
	      
	      while (true) {  // Bucle termina cuando la predicción es incorrecta.
	         
	         /* Obtiene la predicción del usuario, 'G' or 'P' (or 'g' or 'p'). */
	         
	         System.out.print("¿La siguiete carta es más Grande (G) o pequeña (P)?  ");
	         do {
	             prediccion = scanner.next().charAt(0);
	             prediccion = Character.toUpperCase(prediccion);
	             if (prediccion != 'G' && prediccion != 'P') 
	                System.out.print("Por favor responde con G o P:  ");
	         } while (prediccion != 'G' && prediccion != 'P');
	         
	         /* Obtiene la siguiente carta y la muestra al usuario */
	         
	         siguienteCarta = baraja.extraeCarta();
	         System.out.println("La siguiente carta es " + siguienteCarta);
	         
	         /* Chequea la predicción del usuario */
	         
	         if (siguienteCarta.getValor() == cartaActual.getValor()) {
	            System.out.println("El valor es el mismo que el de la carta previa.");
	            System.out.println("Lo siento. Predicción incorrecta.");
	            break;  // End the game.
	         }
	         else if (siguienteCarta.getValor() > cartaActual.getValor()) {
	            if (prediccion == 'G') {
	                System.out.println("Tu predicción fue correcta.");
	                prediccionCorrecta++;
	            }
	            else {
	                System.out.println("Tu predicción fue incorrecta.");
	                break;  // Final del juego.
	            }
	         }
	         else {  // siguienteCarta es menor
	            if (prediccion == 'P') {
	                System.out.println("Tu predicción fue correcta.");
	                prediccionCorrecta++;
	            }
	            else {
	                System.out.println("Tu predicción fue incorrecta.");
	                break;  // fin de la partida.
	            }
	         }
	         
	         /* Actualiza para el siguiente ciclo del bucle, siguienteCarta
	            pasa a ser cartaActual, que es la que el usuario ahora ve,
	           , y la siguienteCarta será la siguiente carta en la baraja 
	           después de que el usuario haga su predicción.
	        */
	         
	         cartaActual = siguienteCarta;
	         System.out.println();
	         System.out.println("La carta es " + cartaActual);
	         
	      } // end bucle while
	      
	      System.out.println();
	      System.out.println("El juego ha terminado.");
	      System.out.println("Has realizado " + prediccionCorrecta 
	                                           + " predicciones correctas.");
	      System.out.println();
	      
	      return prediccionCorrecta;
	      
	   }  // find jugar()

}
