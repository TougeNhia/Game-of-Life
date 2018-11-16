package game.of.life;
import java.util.ArrayList;
public class Cards {
    private String description;
    private int salary;
    private int raise;
    private String name;
    private static ArrayList<Cards> cards = new ArrayList();
    
    public static void Create(){
       cards.add(new Cards("Rising painter", 45080, 6500, "Artist"));
       cards.add(new Cards("Not very well known", 79063, 1800, "Athlete"));
       cards.add(new Cards("Aerospace engineer", 107830, 2000, "Engineer"));
       cards.add(new Cards("Teaches at a College", 58030, 3500, "Teacher"));
       cards.add(new Cards("Sales variety of things", 42153 , 3000, "Salesman"));
       cards.add(new Cards("Not well known", 63670 , 4000, "Fashion Deigner"));
       cards.add(new Cards("Preforms surgery and helps cure others ", 187200 , 500, "Doctor"));
       cards.add(new Cards("Very well known celebrity", 83342, 1500, "Celebrity"));
       cards.add(new Cards(" ", 67190 , 4000, "Accountant"));
       cards.add(new Cards(" ", 115820 , 1000, "Lawer"));
       cards.add(new Cards("Go around stealing the goods of others.", 27838, 10, "Theif"));
       
       
    }
    
    Cards (String _description, int _salary, int _raise, String _name){
        name = _name;
        description = _description;
        salary = _salary;
        raise = _raise;
        
    }

    
    
}
