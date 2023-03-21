/**
 * 
 */
public interface IActividad {
    public void chAddAmigo();
    public void chAddAmigoDe();
    /**
     * Presentar los amigos
     * @param p: la personana la cual se va a presentar
     * @param n: el nivel en que se encuentra
     */
    public void chShowAmigos(Persona p, int n);
}
