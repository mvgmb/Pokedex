package negocio.tipos;

/**
 * Created by mathe on 24/11/2016.
 */
public enum Tipos {
    INSETO,
    DRAGAO,
    ELETRICO,
    LUTADOR,
    FOGO,
    VOADOR,
    FANTASMA,
    GRAMA,
    SOLO,
    GELO,
    NORMAL,
    VENENOSO,
    PSIQUICO,
    PEDRA,
    AGUA;

    public static boolean contains(String name) {
        try {
            Tipos.valueOf(name.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
