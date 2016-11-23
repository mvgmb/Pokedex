package negocio.pokemon;

public class Pokemon {
    private int number;
    private String name;

    public Pokemon(int number, String name, String type) {
        this.number = number;
        this.name = name;
        this.type = type;
    }

    private String type;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean equals(Pokemon pokemon) {
        return this.number == pokemon.number;
    }
}
