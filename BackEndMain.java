import java.util.ArrayList;


/*
 * Start testing here
 */
public class BackEndMain {
	
	
	
	public static void main(String[] args)
	
	/*
	 * To-do 
	 * - condense main
	 */
	
	{
		FileInitializer fz = new FileInitializer();
		ArrayList<Team> CONCACAF = fz.getRegionTeams("CONCACAF");
		ArrayList<Team> AFC = fz.getRegionTeams("AFC");
		ArrayList<Team> UEFA = fz.getRegionTeams("UEFA");
		ArrayList<Team> CAF = fz.getRegionTeams("CAF");
		ArrayList<Team> OFC = fz.getRegionTeams("OFC");
		ArrayList<Team> CONMEBOL = fz.getRegionTeams("CONMEBOL");
		ArrayList<League> allLeagues = new ArrayList<League>();
		
		League concacafLeague = new League (CONCACAF);
		League afcLeague = new League(AFC);
		League uefaLeague = new League(UEFA);
		League cafLeague = new League(CAF);
		League ofcLeague = new League(OFC);
		League conmebolLeague = new League(CONMEBOL);
		allLeagues.add(concacafLeague);
		allLeagues.add(afcLeague);
		allLeagues.add(uefaLeague);
		allLeagues.add(cafLeague);
		allLeagues.add(ofcLeague);
		allLeagues.add(conmebolLeague);
		
		Regions regions = new Regions(allLeagues);
		regions.simulateQualifiers();
		regions.getTournamentScore();
		
		
	}
}
