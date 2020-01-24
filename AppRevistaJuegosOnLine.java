/**
 * Punto de entrada a la aplicación
 * 
 * @author - Richard Eguaras
 */
public class AppRevistaJuegosOnLine 
{
    public static void main(String[] args)
    {
        if(args.length != 2)
        {
            System.out.println("Error\n java AppRevistaJuegosOnline <nombre> <int>");
        }
        else 
        {
            String nombre = args[0];
            int x = Integer.parseInt(args[1]);
            RevistaOnLineJuegos games = new RevistaOnLineJuegos(nombre, x);
            games.leerDeFichero();
            
        } 

        
    }

}
