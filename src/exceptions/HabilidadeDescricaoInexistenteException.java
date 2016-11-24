package exceptions;

/**
 * Created by mario on 24/11/16.
 */
public class HabilidadeDescricaoInexistenteException extends Exception {
    public HabilidadeDescricaoInexistenteException(){
        super ("Descrição da habilidade inválida");
    }
}
