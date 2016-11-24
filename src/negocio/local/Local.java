package negocio.local;

/**
 * Created by gevd on 22/11/2016.
 */
public class Local {

    private String name;
    private String route;
    private String city;

    public Local(String name, String city, String route){
        this.name = name;
        this.city = city;
        this.route = route;

    }
    public Local(){
        this.name = null;
        this.city = null;
        this.route = null;
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
    public void setCity(String city){
        this.city = city;
    }
    public String getRoute(){
        return this.route;
    }
    public void setRoute(String route){
        this.route = route;
    }

}
