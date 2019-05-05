import java.util.ArrayList;

/**Task: This is the class group rounds where the group rounds are carried out
 *
 */
public class GroupRounds {

    private Group a;
    private Group b;
    private Group c;
    private Group d;
    private Group e;
    private Group f;
    private Group g;
    private Group h;

    private ArrayList<Group> groupList;

    public GroupRounds(ArrayList<Team> finalist){
        a= new Group();
        b= new Group();
        c= new Group();
        d= new Group();
        e= new Group();
        f= new Group();
        g= new Group();
        h= new Group();

        groupList.add(a);
        groupList.add(b);
        groupList.add(c);
        groupList.add(d);
        groupList.add(e);
        groupList.add(f);
        groupList.add(g);
        groupList.add(h);

        assignGroups(finalist);//here teams are assigned to groups
    }

    public void assignGroups(ArrayList<Team> finalist){

        //How a seed is assigned to each group
        for(int i = 0; i < 8;i++){
            for(int j = 0; j < i; j++){
                groupList.get(j).add(finalist.get(i));
                finalist.remove(i);
            }
        }
        //Group a
        groupList.get(0).add(finalist.get(8));
        groupList.get(0).add(finalist.get(9));
        groupList.get(0).add(finalist.get(10));

       // Group B
        groupList.get(1).add(finalist.get(11));
        groupList.get(1).add(finalist.get(12));
        groupList.get(1).add(finalist.get(13));

        //Group C
        groupList.get(2).add(finalist.get(14));
        groupList.get(2).add(finalist.get(15));
        groupList.get(2).add(finalist.get(16));

        //Group D
        groupList.get(3).add(finalist.get(17));
        groupList.get(3).add(finalist.get(18));
        groupList.get(3).add(finalist.get(19));

        //Group E
        groupList.get(4).add(finalist.get(20));
        groupList.get(4).add(finalist.get(21));
        groupList.get(4).add(finalist.get(22));

        //Group F
        groupList.get(5).add(finalist.get(23));
        groupList.get(5).add(finalist.get(24));
        groupList.get(5).add(finalist.get(25));


        //Group G
        groupList.get(6).add(finalist.get(26));
        groupList.get(6).add(finalist.get(27));
        groupList.get(6).add(finalist.get(28));


        //Group H
        groupList.get(7).add(finalist.get(29));
        groupList.get(7).add(finalist.get(30));
        groupList.get(7).add(finalist.get(31));


        }
        Match groupMatch ;
    // simulate group round takes the list of groups, makes a league for each group an runs the specific group sim so each team play once.
    // the top two players get added to the Finalist list of teams (final 16)
    public void simulateGroupRound(){

        //This simulates each group playing round robin
        for (Group g:groupList) {
            for (int i = 1; i < g.getTeams().size(); i++) {
                groupMatch = new Match(g.getList(0), g.getList(i));
                groupMatch.playMatch();
                g.addMatchHistory(groupMatch);
            }
        }
        //Sorting each team in each group based on points
        for(Group g: groupList){
            g.sortGroup();
        }

        //This loop then removes the last two teams from the list
        for(Group g: groupList){
            g.remove(g.getTeams().size());
            g.remove(g.getTeams().size()-1);//Removes last placeing teams from all groups
        }
        //Here the groups are refactored and advance.
        for(int i = 0; i < 4; i++){
            groupList.get(i).add(groupList.get(groupList.size()).getList(0));
            groupList.get(i).add(groupList.get(groupList.size()).getList(1));
    }
        //Empty groups left over from refactoring are removed. Leaveing only 4 groups with 4 teams 16 total
        for(int i = 4; i < groupList.size(); i++){
            groupList.remove(4);
        }
    }


    public void simulateFinals(){
        for (Group g:groupList) {


        }
    }


    }





