package game.of.life;
import java.util.ArrayList;
public class Cards {
    private String description;
    private int salary;
    private int raise;
    private String name;
    private static ArrayList<Cards> cards = new ArrayList();
    
    
    Cards(String _description, int _salary, int _raise, String _name){
        name = _name;
        description = _description;
        salary = _salary;
        raise = _raise;
        
    }
    
    
}
