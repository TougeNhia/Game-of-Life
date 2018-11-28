package game.of.life;
import java.util.ArrayList;
public class Cards {
    private String description;
    public static final int BAD = 0;
    public static final int GOOD = 1;
    
    public static final int LIN = 0;
    public static final int MULT = 1;
    public static final int DIV = 2;
    
    public static final int DEGREE = 2;
    public static final int UNSTABLE = 1;
    public static final int NON = 0;
    public static final int CAREER = 1;
    public static final int EVENT = 3;
    public static final int PAYDAY = 2;
    //outlier means any special 'traits' like degree and unstable
    private static int preview = 0;
    private int outlier;
    private int operator;
    private int salary;
    private int raise;
    private String name;
    private static ArrayList<Cards> career = new ArrayList();
    private static ArrayList<Cards> events = new ArrayList();
    //if i wanted more to scroll through
    private static ArrayList<Cards>mult = new ArrayList();
    private double outcome;
    private int karma;
    private static Cards event;
    public static int reason;
    public static void Create(){
       career.add(new Cards(
                        "You draw crude fanart \n" +
                       "on tumblr but you get paid?", 500, 5500, "Artist",UNSTABLE));
       career.add(new Cards("You play Sports and \n"
               + " people just pay you for that", 1250, "Athlete"));
       career.add(new Cards("...So you quit your job\n"
               + " to do WHAT?", 600,1000,"Twitch Streamer",UNSTABLE));
       career.add(new Cards("An Engineer of socks, not bad", 2000, "Engineer"));
       career.add(new Cards("All you do is narrate\n"
               + "through a powerpoint", 2000, 3500, "Professor",DEGREE));
       career.add(new Cards("A thief but more Charismatic", 1000, "Salesman"));
       career.add(new Cards(""
               + "As long if you slap\n" +
               "on a popular brand/logo\n" +
               "on your clothing, you’re all good. ", 1800, "Fashion Deigner"));
       career.add(new Cards(""
               + "Despite the title, you are\n" +
               "really just an actor playing as a doctor.\n" +
               "(with good pay though) ", 3500 , 500, "Doctor",DEGREE));
       career.add(new Cards("You are a very popular\n vlogger my friend.", 83342, "Celebrity"));
       career.add(new Cards("Collect taxes and deals with  finances", 1500 , 4000, "Accountant",DEGREE));
       career.add(new Cards("Studies and practices laws", 2500 , 1000, "Lawyer",DEGREE));
       career.add(new Cards("     *whistles*", 1, 6500, "Thief",UNSTABLE));
        
       events.add(new Cards("Robbed",
                         "you were unlucky enough"
                        + "\n to be jumped by the"
                        + "\n notorious penny pincher,"
                        + "\n however he took more"
                        + "\n than a few pennies."
                        + "\n (Lose $1,000)",-1000,BAD,LIN));
        events.add(new Cards("Lucky",
                          "The notorious penny pincher\n "
                        + "has become the penny pinched,"
                        + "\n as you pick up the cash that\n he had stolen (and misplaced)"
                        + "\n from a poor victim."
                        + "\n (Gain $1,000)",1000,GOOD,LIN));
        events.add(new Cards("Profitting from stocks",
                        "After conciding with your\n" +
                        "basic economics books\n" +
                        " for an hour, your prodigal stocks\n" +
                        " has reaped in quite a profit.\n" +
                        "(Gain +%10 money)",1.1,GOOD,MULT));
        events.add(new Cards("Accident",
                        "While you were ice skating \n" +
                        "you slipped and broke a \n" +
                        "bone. You had to go to the ER.\n" +
                        "(Lose $2,000)",-2000,BAD,LIN));
        events.add(new Cards("Law Suit",
                        "You invent a new product \n" +
                        "and unfortunately someone \n" +
                        "sues you for 'stealing' their\n" +
                        "idea. You go to court and must\n" +
                        "pay a lawyer to defend you.\n" +
                        "(Lose $1,500)",-1500,BAD,LIN));
        // Need statement to make it less frequent
//        events.add(new Cards("Millionaire!",
//                        "You decide to buy a\n" +
//                        "lottery ticket. You surprisingly\n" +
//                        "win the biggest prize.\n" +
//                        "(Win $1,000,000)",+1000000,GOOD,LIN));
        events.add(new Cards("Working Overtime",
                        "Your manager rewards\n" +
                        "your hark with\n" +
                        "a slight bonus.\n" +
                        "(Gain +%15)",1.15,GOOD,MULT));
        events.add(new Cards("Tipsy",
                        "You decide to go to the\n" +
                        "bar with your buddies.\n" +
                        "However, you all got a bit\n" +
                        " tipsy and spent a fortune on\n" +
                        " Minecraft merchandise.\n" +
                        "(Lose $1,500)",-1500,BAD,LIN));
        events.add(new Cards("Misbehaving",
                        "Your misbehavior\n" +
                        "managed to cause 20%\n" +
                        " of your balance in damages.\n" +
                        "(Lose -%20)",0.80,BAD,MULT));
        events.add(new Cards("very Lucky",
                         "You find a gym bag with\n "
                        + "$2500. You hear someone"
                        + "\n cry for a medic bag"
                        + "\n as you stride off."
                        + "\n (Gain $2500)",2500,GOOD,LIN));
    }
    public static void Reset(){
        career.clear();
        events.clear();
        Create();
    }
    public static void eventRoll(Player cpr){
        int roll = (int)(Math.random()* events.size());
        reason = EVENT;
        Page.eventStat(true);
        event = events.get(roll);
        System.out.println(Page.event());

    }
    public static void careerRoll(Player cpr){    
        int roll = (int)(Math.random()* career.size());
        
        if(cpr.getStats() == Player.COLLEGE){
            mult.add(new Cards("Graduated","Congrats! You graduated from\n" +
"college and got yourself a degree.\n" +
"With this degree, you get to choose from 3\n" +
"random jobs, including jobs \n" +
"that require degrees.\n" +
"Use [Arrow Keys] to navigate\n" +
"through each job and \n" +
"[Spacebar] to confirm"));
            for(int i = 1; i<4;i++){

                    while(Player.CheckJob(career.get(roll)))
                        roll = (int)(Math.random()* career.size());

                    mult.add(career.get(roll));
            }
        } 
        else{
            
                while(Player.CheckJob(career.get(roll)) && career.get(roll).outlier == DEGREE)
                    roll = (int)(Math.random()* career.size());
            
            event = career.get(roll);
        }

        reason = CAREER;
        Page.eventStat(true);
        
    }
    public static void payDay(Player cpr){
        reason = PAYDAY;
        Page.eventStat(true);
        event = cpr.getJob();
        if(event.outlier == UNSTABLE)
            event.outcome = (int)(Math.random()* event.raise)+event.salary;

                
    }
//    public static void getChoice(){
//        new Cards("A Choice","")
//    }
    public static ArrayList getMult(){
        return mult;
    }
    public static void doAfter(){
        Player cpr = Player.getCurrentPlayer();
        if(reason == EVENT){
            cpr.changeMoney(event.outcome,event.operator);            
        }
        else if(reason == CAREER){
                cpr.obtainJob(event);
            cpr.setStat(Player.CAREER);
        }
        else if(reason == PAYDAY){
            if(event.outlier == UNSTABLE){
                cpr.changeMoney(event.outcome, LIN);
        }
            else
                cpr.changeMoney(cpr.getJob().getSalary(), LIN);
        }
        mult.clear();
        preview = 0;
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
     Cards( String _name, String _description){
        name = _name;
        description = _description;
    }
    public int getSalary(){
        return salary;
    }
    public int getOutlier(){
        return outlier;
    }
    public static Cards getEvent(){
        return event;
    }
    public String getName(){
        return name;
    }
    public int getRaise(){
        return raise;
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
    public boolean checkMEvent(){
        if(mult.size() > 0)
            return true;
        return false;
    }
    public static int getPreview(){
        return preview;
    }
    public static void changePreview(int i){
     if(preview+i > mult.size()-1)
         preview = 0;
     else if (preview+i < 0)
         preview = mult.size()-1;
     else if( preview + i >= 0 && preview + i < mult.size())
        preview += i;
    }
    public static void Confirm(){
        ArrayList<Button> ptr = Page.getElems();
        if(reason == CAREER && preview != 0){
            event = mult.get(preview);    
            ptr.get(Page.EXITBUTTON).pressed(Page.GetCurrPage());
        }
        else{
            event = mult.get(preview);  
            ptr.get(Page.EXITBUTTON).pressed(Page.GetCurrPage());
        }
    }
}
