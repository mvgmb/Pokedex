package negocio.local;

/**
 * Created by gevd on 22/11/2016.
 */
public class Local {

    private String name;
    private int route;
    private String city;

    public Local(String name, String city, int route){
        this.name = name;
        this.city = city;
        this.route = route;

    }
    public Local(){
        this.name = null;
        this.city = null;
        this.route = 0;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCity() {
        return this.city;
    }
    public static void setCity(String city){
        this.city = city;
    }
    public int getRoute(){
        return this.route;
    }
    public void setRoute(int route){
        this.route = route;
    }

}
