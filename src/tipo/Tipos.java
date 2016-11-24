package tipo;

public class Tipos {
    private String[] types = {"Inseto", "Dragao", "Eletrico", "Lutador", "Fogo", "Voador", "Fantasma", "Grama", "Solo", "Gelo", "Normal", "Venenoso", "Psiquico", "Pedra", "Agua"};

    public boolean exist(String name) {
        for (int i = 0; i < types.length; i++) {
            if (types[i].equalsIgnoreCase(name))
                return true;    
        }
        return false;
    }
}