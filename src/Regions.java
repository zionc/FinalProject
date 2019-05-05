import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


/**Task: The class region is a class that contains all the leaugs and has
 * access to all their fuinctionslities
 */
public class Regions {

    private ArrayList<Team> finalist;//data structure that will hold all the 32 qualifying teams
    private ArrayList<League> regions;//data structure that holds all Leagues
    private ArrayList<Team> straglers;// This will hold the .5 teams that compete to make it to finalist



    //The the leagues that go into regions
    private League Americas;
    private League Africa;
    private League Asia;
    private League Europe;
    private League Oceania;
    private League SouthAmerica;


    /**Task: This is Region constructor it creates
     * the league and data structure region which will hold all the leagues
     * Straglers is the list that will hold the .5 teams that compete to qualitfy
     * Finalist hold the 32 finalist*/
    public Regions() {

        straglers = new ArrayList<>();
        finalist = new ArrayList<>();
        regions = new ArrayList<>();

        Americas = new League("Americas");
        Africa = new League("Africa");
        Asia = new League("Asia");
        Europe = new League("Europe");
        Oceania = new League("Oceania");
        SouthAmerica = new League("SouthAmerica");

        regions.add(Americas);
        regions.add(Africa);
        regions.add(Asia);
        regions.add(Europe);
        regions.add(Oceania);
        regions.add(SouthAmerica);
    }

    /**Task: Thjis method till setup the world cup and assign get 32 teams ready to compete*/
    public void simulateSeason() { setupWorldCup(); }

    /**Task: This method actually sets up the world cup by calling sorting
     * teams then assigning seeds to groups*/
    public void setupWorldCup() {

        for (League l : regions) {
            l.getSortedTeams();
        }

        getRegionQuals();
        assignSeeds();
    }

    /**Task: This method will get quallifiers from each region. It also get the straglers and puts
     * them in  list where they will compete to see who actually qualifiers*/
    public void getRegionQuals() {

        //Here we cycle through all the leagues
        for (League l : regions) {

            if (l.getName().equals("Americas")) {//add qualifying teams from america
                for (int i = 0; i < 4; i++) {
                    finalist.add(l.getTeam(i));
                    if (i == 3) {
                        straglers.add(l.getTeam(i));
                    }
                }
            } else {

                if (l.getName().equals("Africa")) {//Add qualifying teams from afica
                    for (int i = 0; i < 5; i++)
                        finalist.add(l.getTeam(i));
                } else {
                    if (l.getName().equals("Asia")) {//add qualifying teams from asia
                        for (int i = 0; i < 5; i++) {
                            finalist.add(l.getTeam(i));
                            if (i == 4)
                                straglers.add(l.getTeam(i));
                        }
                    } else {
                        if (l.getName().equals("Europe")) {//add qualifying teams from europe
                            for (int i = 0; i < 13; i++)
                                finalist.add(l.getTeam(i));
                        } else {
                            if (l.getName().equals("Oceania")) {///add qualifying teams from oceania

                                for (int i = 0; i < 1; i++) {
                                    finalist.add(l.getTeam(i));
                                    if (i == 0) {
                                        straglers.add(l.getTeam(i));
                                    }
                                }
                            } else {
                                if (l.getName().equals("SouthAmerica")) {//add qualifying teams from south america
                                    for (int i = 0; i < 5; i++) {
                                        finalist.add(l.getTeam(i));
                                        if (i == 4) {
                                            straglers.add(l.getTeam(i));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        getStraglers();//Will decide which .5 teams get added
    }

    Match temp ;
    Match temp1;

    /**This simulates the qualifying game for the straglers*/
    public void getStraglers(){

        temp = new Match(straglers.get(0),straglers.get(1));
            temp1 = new Match(straglers.get(2),straglers.get(3));

            temp.playMatch();
            temp1.playMatch();

            if(temp.getHomePts()>temp.getAwayPts()) {
                finalist.add(temp.getHome());
            }else{
                finalist.add(temp.getAway());
            }
        if(temp1.getHomePts()>temp1.getAwayPts()) {
            finalist.add(temp1.getHome());
        }else{
            finalist.add(temp1.getAway());
        }
    }

    /**Task: This method will assign seeds to based on their rank after the list finalist have been sorted*/
    public void assignSeeds(){
        sortFinalist();
        for(Team t: finalist){
            for(int i = 7; i< finalist.size(); i++){
                finalist.get(i).setSeed(false);
            }

        }
    }

    /**This uses a bubble sort method to sort the list based on score from high to low*/
    public void sortFinalist(){

        // has the smallest value
        int smallestIndex;

        // of the outer loop
        Team smallest;

        // for each index in the array list
        for (int curIndex = 0; curIndex < finalist.size(); curIndex++) {

            /* find the index at which the element has smallest value */
            // initialize variables
            smallest = finalist.get(curIndex);
            smallestIndex = curIndex;

            for (int i = curIndex + 1; i < finalist.size(); i++) {
                if (smallest.getPoints() > finalist.get(i).getPoints()) {
                    // update smallest
                    smallest = finalist.get(i);
                    smallestIndex = i;
                }
            }

            /* swap the value */
            // do nothing if the curIndex has the smallest value
            if (smallestIndex == curIndex)
                ;
                // swap values otherwise
            else {
                Team temp = finalist.get(curIndex);
                finalist.set(curIndex, finalist.get(smallestIndex));
                finalist.set(smallestIndex, temp);
            }

        }
    }



    public void setAfrica(League africa) {
        Africa = africa;
    }

    public void setSouthAmerica(League southAmerica) {
        SouthAmerica = southAmerica;
    }

    public void setAmericas(League americas) {
        Americas = americas;
    }
    public void setAsia(League asia){
        Asia = asia;
    }

    public void setEurope(League europe) {
        Europe = europe;
    }

    public void setOceania(League oceania) {
        Oceania = oceania;
    }

    public League getAfrica() {
        return Africa;
    }

    public League getAmericas() {
        return Americas;
    }

    public League getAsia() {
        return Asia;
    }

    public League getEurope() {
        return Europe;
    }

    public League getOceania() {
        return Oceania;
    }

    public League getSouthAmerica() {
        return SouthAmerica;
    }

    public ArrayList<League> getRegions() {
        return regions;
    }

    public ArrayList<Team> getFinalist() {
        return finalist;
    }

    public void setRegions(ArrayList<League> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {

        String s = "";

        for (League l : regions) {
            s = s + l.toString() + "\n";
        }
        return s;
    }
}
