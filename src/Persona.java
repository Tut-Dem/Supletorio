import java.util.ArrayList;
import java.util.List;

import utilitario.Atajos;

public class Persona extends Integrante implements IActividad {
    private List<Persona> amigos;
     
    public Persona()
    {
        super(0, 0, "", "");
        amigos = new ArrayList<Persona>();
        newPersona(this);
    }

    public void newPersona(Persona p){
        System.out.println("<+> Por favor registra: " );
        p.chID  = Atajos.getNumeroPositivo(" +  Codigo  (ID) : ");
        p.chNombre =Atajos.getCaracteres  (" +  Nombre o nick: ");
        p.chSexo  = Atajos.getCaracteres  (" +  Sexo : ");
        p.chEdad  = Atajos.getNumeroPositivo(" +  Edad : ");
        //Convierte primera letra a mayuscula
        p.chNombre = p.chNombre.substring(0,1).toUpperCase() + p.chNombre.substring(1,p.chNombre.length()).toLowerCase();
    }

    //Interface
    public void chAddAmigo(){
        amigos.add(new Persona());
    }

    public void chAddAmigoDe(){
        System.out.println("<+> Agrega un amigo a tu Amigo: " );
        int id = Atajos.getNumeroPositivo  (" + Cual es el ID de tu amigo: ");
        for (Persona persona : amigos) {
            if (persona.chID == chid)
                persona.chAddAmigo();
        }
    }

    public void chShowAmigos(Persona p, int n){
        for(int i=1; i<n; i++)
            System.out.print("\t");
            System.out.println("\u001B[34m[" + p.chID + "-" + p.chSexo +"]\u001B[0m " + p.chNombre);
        
        for (Persona persona : p.amigos) {
            System.out.print("\t");
            if( persona.amigos.size()>=0)
                chShowAmigos(persona, n+1);
       }
    }
}
