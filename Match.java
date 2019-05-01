//chris
public class Match {

	private Team home,away,winner,loser;
	private boolean isTie,isOverTime;
	private int numKicks;
	
	public Match()
	{
		home=new Team();
		away=new Team();
		this.numKicks=20;
		isTie=false;
		isOverTime=false;
	}
	public Match(Team home, Team away)
	{
		this.home=home;
		this.away=away;
		this.numKicks=20;
		isTie=false;
		isOverTime=false;
	}
	//returns the winning team. Or null if it is a tie
	public void playMatch()
	{
		int homePts=home.score(numKicks);
		int awayPts=away.score(numKicks);
		if(homePts>awayPts)
		{
			winner=home;
			loser=away;
			isTie=false;
		}
		else if(awayPts>homePts)
		{
			winner=away;
			loser=home;
			isTie=false;
		}
		else
		{
			isTie=true;
			winner=null;
			loser=null;
		}	
			
	}
	//tells you whether the match resulted in a tie
	public boolean isTie()
	{
		return isTie;
	}
	public boolean hasWinner()
	{
		if(winner!=null)
			return true;
		return false;
	}
	public boolean hasLoser()
	{
		if(loser!=null)
		{
			return true;
		}
		return false;
	}
	//returns the winner, or null if there isnt one
	public Team getWinner()
	{
		if(hasWinner())
			return winner;
		return null;
	}
	//returns the loser, or null if there isnt one
	public Team getLoser()
	{
		if(hasLoser())
			return loser;
		return null;
	}
	public void runTieBreaker()
	{
		if(isTie())
		{
			playMatch();
			isOverTime=true;
		}
	}
	public boolean playedOverTime()
	{
		return isOverTime;
	}

}
