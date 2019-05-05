import java.util.ArrayList;

//chris
public class MatchHistory {
	
	private ArrayList<Match> history;
	
	public MatchHistory()
	{
		history=new ArrayList<Match>();
	}
	public void addMatch(Match m)
	{
		history.add(m);
	}
	public Match getMatch(int i)
	{
		return history.get(i);
	}
	public int getNumWinners()
	{
		int counter=0;
		for(int i=0;i<history.size();i++)
		{
			if(history.get(i).hasWinner())
				counter++;
		}
		return counter;
	}
	public int getNumLosers()
	{
		int counter=0;
		for(int i=0;i<history.size();i++)
		{
			if(history.get(i).hasLoser())
				counter++;
		}
		return counter;
	}
	public int getNumTies()
	{
		int counter=0;
		for(int i=0;i<history.size();i++)
		{
			if(history.get(i).isTie())
				counter++;
		}
		return counter;
	}
	public ArrayList<Match> getHistory()
	{
		return history;
	}
	public int getNumOverTimes()
	{
		int counter=0;
		for(int i=0;i<history.size();i++)
		{
			if(history.get(i).playedOverTime())
				counter++;
		}
		return counter;
	}

}
