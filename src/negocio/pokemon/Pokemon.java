package negocio.pokemon;

import negocio.attack.MoveNegocios;

public class Pokemon {
    private int number;
    private String name;
    private String type;
    private String[] arrayLocalID;
    private String[] arrayMoveID;
    private String AbilityID;

    public Pokemon(int number, String name, String type, String Ability) {
        this.name = name;
        this.number = number;
        this.type = type;

        this.arrayMoveID = new String[4];
        this.arrayLocalID = new String[10];
        this.AbilityID = Ability;
    }

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

    public void setAbilityID(String ability){
        this.AbilityID = ability;
    }

    public String getAbilityID(){
        return AbilityID;
    }

    public void setArrayMoveID(String moveID){
        for (int i = 0; i < 4; i++)
            if (this.arrayMoveID[i] == null)
                this.arrayMoveID[i] = moveID;

    }

    public boolean ExistsSpaceMove() {
        boolean exist = false;
        for (int i = 0; i < this.arrayMoveID.length; i++)
            if (this.arrayMoveID[i] == null)
                exist = true;
        return exist;
    }

    public String getMoveID(int position){
        return this.arrayMoveID[position];
    }

    public boolean ExistMoveInArray(int position) {
        if ((this.arrayMoveID[position] == null)) return true;
        else return false;
    }
    public void setArrayLocalID(String localID){
        for (int i = 0; i < 10; i++)
            if (this.arrayLocalID[i] == null)
                this.arrayLocalID[i] = localID;
    }
    public boolean ExistSpaceLocal(){
        boolean exist = false;
        for (int i = 0; i < this.arrayLocalID.length; i++)
            if (this.arrayLocalID[i] == null)
                exist = true;
        return exist;
    }
    public String getLocalID(int position){
        return this.arrayLocalID[position];
    }

    public boolean ExistLocalInArray(int position) {
        if ((this.arrayLocalID[position] == null)) return true;
        else return false;
    }

    public boolean equals(Pokemon pokemon) {
        return this.number == pokemon.number;
    }

    public boolean existMove(){
        for (int i = 0; i< 4; i++){
            if (this.arrayMoveID != null){
                return true;
            }
        }
        return false;
    }
    public boolean existLocal(){
        for (int i = 0; i < 10; i++){
            if (this.arrayLocalID != null){
                return true;
            }
        }
        return false;
    }
    public boolean existNumber(){
        for (int i = 0; i< 4; i++){
            if (this.number != 0){
                return true;
            }
        }
        return false;
    }
    public boolean existAbilityID(){
        if (this.AbilityID != null){
                return true;
            }
        return false;
        }


}
