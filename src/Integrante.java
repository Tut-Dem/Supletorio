public abstract class Integrante {
    
    protected int chID;
    protected String chNombre;

    //Valores adicionales
    protected int chEdad;
    protected String chSexo;

    
    public Integrante(int chid, int chedad, String chsexo, String chNombre){
        this.chID = chid;
        this.chNombre = chNombre;
        //Extra
        this.chEdad = chedad;
        this.chSexo = chsexo;
    }
}
