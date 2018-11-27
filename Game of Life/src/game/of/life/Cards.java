package game.of.life;
import java.util.ArrayList;
public class Cards {
    private String description;
    public static final int BAD = 0;
    public static final int GOOD = 1;
    
    public static final int LIN = 0;
    public static final int MULT = 1;
    public static final int DIV = 2;
    
    public static final int DEGREE = 0;
    public static final int UNSTABLE = 1;
    private int outlier;
    private int operator;
    private int salary;
    private int raise;
    private String name;
    private static ArrayList<Cards> career = new ArrayList();
    private static ArrayList<Cards> events = new ArrayList();
    private double outcome;
    private int karma;
    private static Cards event;
    public static void Create(){
       career.add(new Cards("Rising painter", 1000, 6500, "Artist",UNSTABLE));
       career.add(new Cards("You play sports", 79063, "Athlete"));
       career.add(new Cards("Aerospace engineer", 107830, "Engineer"));
       career.add(new Cards("All you do is narrate through a powerpoint", 58030, 3500, "Professor",DEGREE));
       career.add(new Cards("Advertise and promote items", 42153, "Salesman"));
       career.add(new Cards("Design clothing", 63670, "Fashion Deigner"));
       career.add(new Cards("Diagnoze diseases and precribes meds", 187200 , 500, "Doctor",DEGREE));
       career.add(new Cards("Very well known", 83342, "Celebrity"));
       career.add(new Cards("Collect taxes and deals with  finances", 67190 , 4000, "Accountant",DEGREE));
       career.add(new Cards("Studies and practices laws", 115820 , 1000, "Lawyer",DEGREE));
       career.add(new Cards("Steals items and money", 100, 1000, "Theif",UNSTABLE));
        
       events.add(new Cards("Robbed",
                "you were unlucky enough"
                        + "\n to be jumped by the"
                        + "\n notorious penny pincher,"
                        + "\n however he took more"
                        + "\n than a few pennies."
                        + "\n (Lose $1,000)",-1000,BAD,LIN));
        events.add(new Cards("Lucky Day",
                "The notorious penny pincher\n "
                        + "has become the penny pinched,"
                        + "\n as you pick up the cash that\n he had stolen (and misplaced)"
                        + "\n from a poor victim."
                        + "\n (Gain $1,000)",1000,GOOD,LIN));
        events.add(new Cards("Investful Stocks",
                        "After conciding with your\n" +
                        "basic economics books\n" +
                        " for an hour, your prodigal stocks\n" +
                        " has reaped in quite a profit.\n" +
                        "(Gain +%10 money)",1.1,GOOD,MULT));
        events.add(new Cards("Accident",
                        "While you were ice skating \n" +
                        "you slipped and broke a \n" +
                        "bone. You must go to the ER.\n" +
                        "(Lose $2,000)",-2000,BAD,LIN));
        events.add(new Cards("Law Suit",
                        "You invent a new product \n" +
                        "and unfortunately someone \n" +
                        "sues you for 'stealing' their\n" +
                        "idea. You go to court and must\n" +
                        "pay a lawyer to defend you.\n" +
                        "(Lose $,1,500)",-1500,BAD,LIN));
        events.add(new Cards("Millionaire!",
                        "You decide to buy a\n" +
                        "lottery ticket. You surprisingly\n" +
                        "win the biggest prize\n" +
                        "(Win $1,000,000)",+1000000,GOOD,LIN));
    }
    public static void Reset(){
        career.clear();
        events.clear();
        Create();
    }
    public static void eventRoll(Player cpr){
        int roll = (int)(Math.random()* events.size());
        Page.eventStat(true);
        event = events.get(roll);
        cpr.changeMoney(event.outcome,event.operator);
        System.out.println(Page.event());
    }
    public static void careerRoll(Player cpr){
        int roll = (int)(Math.random()* career.size()); 
        
        
        
    }
    
    Cards(String _description, int _salary, String _name){
        name = _name;
        description = _description;
        salary = _salary;
    }
        Cards(String _description, int _salary, int _raise, String _name,int _outlier){
        name = _name;
        description = _description;
        salary = _salary;
        raise = _raise;
        outlier = _outlier;
    }
    Cards( String _name, String _description, double _outcome,int _karma, int _operator){
        name = _name;
        description = _description;
        outcome = _outcome;
        karma = _karma;
        operator = _operator;
    }
    public static Cards getEvent(){
        return event;
    }
    public String getName(){
        return name;
    }
    public String getDesc(){
        return description;
    }
    public double getOutCome(){
        return outcome;
    }
    public int getKarma(){
        return karma; 
    }
    
}
