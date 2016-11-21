package basico;
public class Pokemon
{
    private int Number;
    private String Name;
    private String Type;
    public void setNumber (int Number) {
        this.Number = Number;
    }
    public void setName (String Name) {
        this.Name = Name;
    }
    public void setType (String Type) {
        this.Type = Type;
    }
    public int getNumber () {
        return Number;
    }
    public String getName () {
        return Name;
    }
    public String getType () {
        return Type;
    }
}
