package NFL_PlayerManagerClass;

//This is my own work. Chad Galloway
/**  Program: NFL_PlayerManager class testing driver
*    File: ManagerDriverClass.java
*    Summary: Implementation and testing of the NFL:_PlayerManager class.
*               For simplicity the NFL_PlayerManager, Human, and NFL_Player classes are include in this .java file
*    Author: Chad Galloway
*    Date: Jan. 14, 2018
**/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerDriverClass {

    public static void main(String[] args) {
        
        Scanner inputScanner = new Scanner(System.in); // Input scanner for recieving the users input

        // Default constructor with toString tests
        System.out.println("// Default constructor with toString tests");
        NFL_PlayerManager playerManager2 = new NFL_PlayerManager();
        System.out.println(playerManager2.toString());

        // Constructor with args and a toString() tests
        System.out.println("// Constructor with args and a toString() tests");
        NFL_Player player1 = new NFL_Player("Travis Kelce", LocalDate.of(1989, 10, 5), 79f, 260f, "Westlake, OH", 87, "TE", "Cincinnati", 5, 15, 1038, 0, 83, 8, 0, 0);
        NFL_Player player2 = new NFL_Player("Tom Brady", LocalDate.of(1977, 8, 3), 76f, 225f, "San Mateo, CA", 12, "QB", "Michigan", 18, 16, 4577, 581, 385, 32, 0, 8);
        NFL_Player player3 = new NFL_Player("Ezekiel Elliott", LocalDate.of(1995, 7, 22), 72f, 228f, "Alton, IL", 21, "RB", "Ohio State", 2, 10, 983, 242, 0, 7, 1, 0);
        NFL_Player player4 = new NFL_Player("Jarvis Landry", LocalDate.of(1992, 11, 28), 71f, 208f, "Metaire, LA", 14, "WR", "LSU", 4, 16, 987, 0, 112, 9, 3, 0);
        NFL_Player player5 = new NFL_Player("Reshad Jones", LocalDate.of(1988, 2, 25), 73f, 223f, "Atlanta, GA", 20, "FS", "Georgia", 8, 16, 0, 0, 0, 0, 0, 2);
        NFL_Player player6 = new NFL_Player("Khalil Mack", LocalDate.of(1991, 2, 22), 75f, 250f, "Fort Pierce, FL", 52, "DE", "Buffalo", 4, 16, 0, 0, 0, 0, 0, 0);
        
        NFL_PlayerManager playerManager = new NFL_PlayerManager(player1, player2, player3, player4, player5, player6);
        System.out.println(playerManager.toString());
        
        // Player selection tests
        System.out.println("// Player selection tests");
        System.out.print("Enter the number of the player from above you want to select: ");
        playerManager.selectPlayer(inputScanner.nextInt());
        System.out.println(playerManager.toString());
        System.out.println("\"Press enter to continue\"");
        inputScanner.nextLine();
        inputScanner.nextLine();

        
        // Player removal tests
        System.out.println("// Player removal tests");
        playerManager.selectPlayer(87);
        playerManager.selectPlayer(12);
        playerManager.selectPlayer(21);
        playerManager.selectPlayer(20);
        playerManager.selectPlayer(14);
        playerManager.selectPlayer(52);
        System.out.println(playerManager.toString());
        System.out.print("I have added all the players to your team, please select one from above to remove: ");
        playerManager.removePlayer(inputScanner.nextInt());
        System.out.println(playerManager.toString());
        System.out.println("\"Press enter to continue\"");
        inputScanner.nextLine();
        inputScanner.nextLine();
        
        // createPlayers tests
        System.out.println("// createPlayers tests");
        System.out.println(playerManager2.toString());
        playerManager2.createPlayers();
        System.out.println(playerManager2.toString());        
    }

}

class NFL_PlayerManager {
    
    // PrivateProperties
    private ArrayList avaliblePlayers = new ArrayList();
    private ArrayList selectedPlayers = new ArrayList();
    
    // Constructors
    public NFL_PlayerManager(NFL_Player... players) {
        
        for (int i = 0; i < players.length; i++) {
            this.avaliblePlayers.add(players[i]);
        }
    }
    public NFL_PlayerManager() {
        
    }
    
    // Methods
    void createPlayers() {
        
        // Create six NFL_players.
        NFL_Player player1 = new NFL_Player("Travis Kelce", LocalDate.of(1989, 10, 5), 79f, 260f, "Westlake, OH", 87, "TE", "Cincinnati", 5, 15, 1038, 0, 83, 8, 0, 0);
        NFL_Player player2 = new NFL_Player("Tom Brady", LocalDate.of(1977, 8, 3), 76f, 225f, "San Mateo, CA", 12, "QB", "Michigan", 18, 16, 4577, 581, 385, 32, 0, 8);
        NFL_Player player3 = new NFL_Player("Ezekiel Elliott", LocalDate.of(1995, 7, 22), 72f, 228f, "Alton, IL", 21, "RB", "Ohio State", 2, 10, 983, 242, 0, 7, 1, 0);
        NFL_Player player4 = new NFL_Player("Jarvis Landry", LocalDate.of(1992, 11, 28), 71f, 208f, "Metaire, LA", 14, "WR", "LSU", 4, 16, 987, 0, 112, 9, 3, 0);
        NFL_Player player5 = new NFL_Player("Reshad Jones", LocalDate.of(1988, 2, 25), 73f, 223f, "Atlanta, GA", 20, "FS", "Georgia", 8, 16, 0, 0, 0, 0, 0, 2);
        NFL_Player player6 = new NFL_Player("Khalil Mack", LocalDate.of(1991, 2, 22), 75f, 250f, "Fort Pierce, FL", 52, "DE", "Buffalo", 4, 16, 0, 0, 0, 0, 0, 0);
        
        // Add the six created players to the avalible playerPlayers ArrayList
        avaliblePlayers.add(player1);
        avaliblePlayers.add(player2);
        avaliblePlayers.add(player3);
        avaliblePlayers.add(player4);
        avaliblePlayers.add(player5);
        avaliblePlayers.add(player6);
    }
    void selectPlayer(int playersNumber) {
        
        NFL_Player player;
        
        for (int i = 0; i < avaliblePlayers.size(); i++) {
            
            player = (NFL_Player)avaliblePlayers.get(i);
            
            if ( player.getPlayersNumber() == playersNumber ) {
                avaliblePlayers.remove(i);
                selectedPlayers.add(player);
            }
        }

    }
    void removePlayer(int playersNumber) {
        NFL_Player player;
        
        for (int i = 0; i < selectedPlayers.size(); i++) {
            
            player = (NFL_Player)selectedPlayers.get(i);
            
            if ( player.getPlayersNumber() == playersNumber ) {
                selectedPlayers.remove(i);
                avaliblePlayers.add(player);
            }
        }

        
    }
    void viewPlayerStatDetails (NFL_Player player){
    
}
       
    @Override
    public String toString() {
        
        NFL_Player player;
        String returnString = "";
        
        returnString += avaliblePlayers.size() + " total avalible players remaining.\n";
        for (int i = 0; i < avaliblePlayers.size(); i++) {
            player = (NFL_Player)avaliblePlayers.get(i);
            returnString += player.getPlayersNumber() + " " + player.getPlayersPosition() + " " +  player.getName() + "\n";
        }
                
        returnString += "\n" + selectedPlayers.size() + " total players selected for the team.\n";
        for (int i = 0; i < selectedPlayers.size(); i++) {
            player = (NFL_Player)selectedPlayers.get(i);
            returnString += player.getPlayersNumber() + " " + player.getPlayersPosition() + " " +  player.getName() + "\n";
        }
      
        return returnString;
    }

    
}

abstract class Human {
    
    // Private properties.
    private String name;
    private LocalDate dob;
    private float height;
    private float weight;
    private String birthPlace;

    // Constructors.
    public Human(String name, LocalDate dob, float height, float weight, String birthPlace) {
        
        this.name = name;
        this.dob = dob;
        this.height = height;
        this.weight = weight;
        this.birthPlace = birthPlace;
    }
    public Human() {
        
        this.name = "";
        this.dob = LocalDate.now();
        this.height = 0f;
        this.weight = 0f;
        this.birthPlace = "";
    }

    // Get accessors.
    public String getName() {
        
        return this.name;
    }
    public LocalDate getDOB() {
        
        return this.dob;
    }
    public float getHeight() {
        
        return this.height;
    }
    public float getWeight() {
        
        return this.weight;
    }
    public String getBirthPlace() {
        
        return this.birthPlace;
    }
    
    // Set accessors.
    public void setName(String newValue) {
        
        this.name = newValue;
    }
    public void setDOB(LocalDate newValue) {
        
        this.dob = newValue;
    }
    public void setHeight(float newValue) {
        
        this.height = newValue;
    }
    public void setWeight(float newValue) {
        
        this.weight = newValue;
    }
    public void setBirthPlace(String newValue) {
        
        this.birthPlace = newValue;
    }

    // Additional get methods
    public int getAge() {
        
        // Get current date for use in calculations.
        LocalDate now = LocalDate.now();
        
        
        // Calculate the base year considered age.
        int age = now.getYear() - dob.getYear();
        
        // Adjust age for month and day born.
        if ( now.getMonthValue() - (dob.getMonthValue()) <= 0 && now.getDayOfMonth() - dob.getDayOfMonth() < 0 ) {
            age--; // Decrease age by one year because they haven't quite reached their birthday yet this year.
        }
        return age;
    }
}

class NFL_Player extends Human {

    private int playersNumber;
    private String positionAbbreviation;
    private String collegeAttended;
    private int yearsExperienceInNFL;
    private int gamesPlayed;
    private int yards;
    private int attempts;
    private int completions;
    private int touchdowns;
    private int fumbles;
    private int interceptions;

    // Constructors
    public NFL_Player(String name, LocalDate dob, float height, float weight, String birthPlace, int playersNumber, String positionAbbreviation, String collegeAttended, 
                        int yearsExperienceInNFL, int gamesPlayed, int yards, int attempts, int completions, int touchdowns, int fumbles, int interceptions) {
        
        super(name, dob, height, weight, birthPlace);
        this.playersNumber = playersNumber;
        this.positionAbbreviation = positionAbbreviation;
        this.collegeAttended = collegeAttended;
        this.yearsExperienceInNFL = yearsExperienceInNFL;
        this.gamesPlayed = gamesPlayed;
        this.yards = yards;
        this.attempts = attempts;
        this.completions = completions;
        this.touchdowns = touchdowns;
        this.fumbles = fumbles;
        this.interceptions = interceptions;
    }
    public NFL_Player() {
        super();
        this.playersNumber = 0;
        this.positionAbbreviation = "";
        this.collegeAttended = "";
        this.yearsExperienceInNFL = 0;
        this.gamesPlayed = 0;
        this.yards = 0;
        this.attempts = 0;
        this.completions = 0;
        this.touchdowns = 0;
        this.fumbles = 0;
        this.interceptions = 0;
    }

    // Get accessors
    public int getPlayersNumber() {

        return this.playersNumber;
    }
    public String getPlayersPosition() {
        
        return this.positionAbbreviation;
    }
    public String getCollegeAttended() {
        
        return this.collegeAttended;
    }
    public int getPlayersExperience() {
        
        return this.yearsExperienceInNFL;
    }
    public int getGamesPlayed() {
        
        return this.gamesPlayed;
    }
    public int getYards() {
        
        return this.yards;
    }
    public int getAttempts() {
        
        return this.attempts;
    }
    public int getCompletions() {
        
        return this.completions;
    }
    public int getTouchdowns() {
        
        return this.touchdowns;
    }
    public int getFumbles() {
        
        return this.fumbles;
    }
    public int getInterceptions() {
        
        return this.interceptions;
    }

    // Set accessors
    public void setPlayersNumber(int newValue) {
        
        this.playersNumber = newValue;
    }
    public void setPlayersPosition(String newValue) {
        
        this.positionAbbreviation = newValue;
    }
    public void setCollegeAttended(String newValue) {
        
        this.collegeAttended = newValue;
    }
    public void setPlayersExperience(int newValue) {
        
        this.yearsExperienceInNFL = newValue;
    }
    public void setGamesPlayed(int newValue) {
        
        this.gamesPlayed = newValue;
    }
    public void setYards(int newValue) {
        
        this.yards = newValue;
    }
    public void setAttempts(int newValue) {
        
        this.attempts = newValue;
    }
    public void setCompletions (int newValue) {
        
        this.completions = newValue;
    }
    public void setTouchdowns(int newValue) {
        
        this.touchdowns = newValue;
    }
    public void setFumbles(int newValue) {
        
        this.fumbles = newValue;
    }
    public void setInterceptions(int newValue) {
        
        this.interceptions = newValue;
    }

    // Aditional get methods.
    public float getYardsPerCompletion() {
         
        return (float)this.yards / (float)this.completions;
    }
    public float getCompletionsPerGame() {
        
        return (float)this.completions / (float)this.gamesPlayed;
    }
    public float getYardsPerGame() {
        
        return (float)this.yards / (float)this.gamesPlayed;
    }
    public float getCompletionPercentage() {
        
        // Divide by zero check
        if ( this.attempts > 0 ) {
            return (float)this.completions / (float)this.attempts;
        }
        
        return 0f;
    }
        
    @Override
    public String toString() {
        
        String s = "";
        s = getName() + "\n#" + getPlayersNumber() + " " + getPlayersPosition() + "\nHeight: " + getHeight() + "in.  Weight: " + getWeight() + "lb.  Age: " + getAge() + 
                "\nBorn: " + getDOB().getMonthValue() + "/" + getDOB().getDayOfMonth() + "/" + getDOB().getYear() + " " + getBirthPlace() + "\nCollege: " + getCollegeAttended() + "\n" + getPlayersExperience() + " Seasons in the NFL.";
        
        return s;
    }
}
