package negocio.local;

/**
 * Created by gevd on 22/11/2016.
 */
public class Local {

    private String name;

    public Local(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

}
