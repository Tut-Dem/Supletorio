import java.util.List;
import java.util.Scanner;
import utilitario.Atajos;



public class App {
    public static String chUser;
    public static final String chTema = "\t ------------------------------------------ \n\t\t  NETWORK cristian.hernandez@epn.edu.ec \n\t ------------------------------------------ ";
    enum Menu { SALIR, AGREGAR, AGREGAR_SI, MOSTRAR_NETWORK, MOSTRAR_NETWORKAMIGOS, MOSTRAR_NETWORKAMIGAS };

    public static void main(String[] args) throws Exception {
        //permite limpiar la consola al momento de la ejecución
        Atajos.clear();
        
        System.out.println("\n\n"+ chTema);
        if( !chLogin() )  
            System.exit(0); 
            Atajos.pressKey();
            Atajos.clear();

        Persona p = new Persona();
        do{
            switch (chMenu())
            {
                case SALIR : 	        System.out.println(" Regresa pronto "+ chUser );
                                        System.exit(0); 
                case AGREGAR: 	        p.chAddAmigo();
                                        break;
                case AGREGAR_SI: 	    p.chAddAmigoDe();
                                        break;
                case MOSTRAR_NETWORK: 	p.chShowAmigos(p, 0);
                                        break;
            }
            Atajos.pressKey();
        } while (true);
    }

    public static Menu chMenu()
    {
        int numero=-1; 
        Atajos.clear();

        System.out.println("\n\n\n"+ chTema);
        System.out.println("\t  Usuario: "+ chUser +"\n\n");
        System.out.println(Menu.AGREGAR.ordinal()  	        + " AGREGAR AMIGO"               ); 	
        System.out.println(Menu.AGREGAR_SI.ordinal()  	    + " AGREGAR AMIGO DE AMIGO"      ); 	
        System.out.println(Menu.MOSTRAR_NETWORK.ordinal()   + " MOSTRAR NETWORK "	         );
        System.out.println(Menu.MOSTRAR_NETWORKAMIGOS.ordinal() + " MOSTRAR NETWORK AMIGOS ");
        System.out.println(Menu.MOSTRAR_NETWORKAMIGAS.ordinal() + " MOSTRAR NETWORK AMIGAS ");  
        System.out.println(Menu.SALIR.ordinal()     		+ " SALIR "	                     );
        do
        {
            numero = Atajos.getNumeroPositivo("<+> Ingresa Opc: ");
            if (numero>= 0 && numero <= 5 )
            {	
                Atajos.clear();
                System.out.println("\n\n"+ chTema);
                System.out.println("\t  Usuario: "+ chUser +"\n");
                break;
            }
        } while (true);
        return Menu.values()[numero];
    }

    public static boolean chLogin()
    {
        int intentos = 3;
        List<String> usuariosClaves = List.of("cristian1234","profe1234");
        do
        {
            System.out.println("\n \t\t ........................ ");
            String u = Atajos.getCaracteres  ("\t\t +  usuario: ");
            String c = u + Atajos.getCaracteres  ("\t\t +  clave  : ");
            System.out.println("\t\t ........................ ");
            for (String uc : usuariosClaves) 
                if( c.equals(uc))
                {
                    chUser = u.toUpperCase();
                    System.out.println("\n :: Bienvenido "+ chUser);
                    return true;
                }
            System.out.println("\t\t * Nro de intentos: "+ --intentos );
        } while (intentos > 0);
        System.out.println("\n\n \t :(  Lo sentimos tu usuario y clave son incorrectos..! " );
        return false;
    }
    
}
