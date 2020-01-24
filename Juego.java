
/**
* Un objeto de esta clase guarda informaci�n relativa a un juego
* 
* @author - Richard Eguaras
*/
public class Juego {
    private static final String SEPARADOR = ":";
    private String titulo;
    private Genero genero;
    private int year;
    private int[] valoraciones;

    /**
    *  Inicializa los atributos a partir de la informaci�n recibida
    *  Esta informaci�n se encuentra en linea
    */
    public Juego(String linea) 
    {
            
            String[] datos = linea.split(":");
            datos[0].toUpperCase();
            titulo = datos[0];
           switch(datos[1])
            {
                case "aventura" : genero = genero.valueOf("AVENTURA");
                break;
                case "deporte": genero = genero.valueOf("DEPORTE");
                break;
                case "estrategia": genero = genero.valueOf("ESTRATEGIA");
                break;
                case "rol": genero = genero.valueOf("ROL");
                break;
            }
            int a�o = Integer.parseInt(datos[2].trim());
            year = a�o;
            valoraciones = new int[10];
            int aux = 3;
            for(int i = 0; i < 10; i++)
            {
                valoraciones[i] = Integer.parseInt(datos[aux].trim());
                aux++;
            }
            
           
    }

    /**
     * accesor t�tulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * accesor g�nero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * accesor year
     */
    public int getYear() {
        return year;
    }

    /**
     * accesor valoraciones
     */
    public int[] getValoraciones() {
        return valoraciones;
    }

    /**
     * total votos emitidos
     */
    public int getVotos() {
        int aux = 0;
        for(int i = 0; i < 10; i++)
        {
          aux += valoraciones[i];
          
        }
        return aux;
    }

    /**
     *  obtener valoraci�n media
     */
    public double getValoracionMedia() {
        double media = 0;
        int[] aux;
        aux = new int[10];
        for(int i = 0; i < 10; i++)
        {
         aux[i] = valoraciones[i] * i;
         media += aux[i];
        }
        media = media / aux.length;
        return media;
        
    }

    /**
     *  Un usuario punt�a el juego con un valor entre 1 y 10 
     */
    public void puntuar(int puntuacion) 
    {
        for(int i = 0; i < 10; i++)
        {
          if (puntuacion == i + 1)
          {
            valoraciones[i]++;
          }
        }
    }

    /**
     * Representaci�n textual del juego 
     * (Ver enunciado)
     */
    public String toString() {
        return titulo + "\nG�nero: " + this.genero +
                            "| Lanzamiento: " + this.year +
                            "\nValoraci�n (" + getVotos() + " votos): "
                            + String.format("%.2f", this.getValoracionMedia());

    }

    public static void main(String[] args) {
        Juego juego1 = new Juego(
                            "Steep: deportes: 2016  : 0:0:0:0: 0: 0:0:0:12:  10");
        System.out.println(juego1.toString());

        Juego juego2 = new Juego(
                            "For the King: estrategia: 2018  : 0:0:0:7: 12: 0:33:13:2: 0");
        System.out.println(juego2.toString());

    }
}
