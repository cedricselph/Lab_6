package pokerBase;

import java.util.ArrayList;
import java.util.LinkedList;

import domain.CardDomainModel;
import domain.GameRuleCardsDomainModel;
import domain.GameRuleDomainModel;
import enums.eGame;
import enums.eRank;
import enums.eSuit;
import logic.GameRuleCardsBLL;

public class Rule {

	private int MaxNumberOfPlayers;
	private int PlayerNumberOfCards;
	private int NumberOfJokers;
	private int PlayerCardsMin;
	private int PlayerCardsMax;
	private int CommunityCardsMin;
	private int CommunityCardsMax;
	private int PossibleHandCombinations;
	private LinkedList iCardsToDraw;
	private ArrayList<CardDomainModel> RuleCards = new ArrayList<CardDomainModel>();
	private eGame Game;

	public Rule(GameRuleDomainModel rle) {
		
		//Gets max # of players
		this.MaxNumberOfPlayers=rle.getMAXNUMBEROFPLAYERS();
		
		//gets number of player cards
		this.PlayerNumberOfCards=rle.getPLAYERNUMBEROFCARDS();
		
		//Number of jokers
		this.NumberOfJokers=rle.getNUMBEROFJOKERS();
		
		//Min # of cards
		this.PlayerCardsMin=rle.getPLAYERCARDSMIN();
		
		//max # of cards
		this.PlayerCardsMax=rle.getPLAYERCARDSMAX();
		
		//min # community
		this.CommunityCardsMin=rle.getCOMMUNITYCARDSMIN();
		
		//max# community
		this.CommunityCardsMax=rle.getCOMMUNITYCARDSMAX();
		
		//Possible # of hands
		this.PossibleHandCombinations=rle.getPOSSIBLEHANDCOMBINATIONS();
		
		//Creates array list of game rule cards domain model
		ArrayList<GameRuleCardsDomainModel> Number_Of_Cards=GameRuleCardsBLL.getCardsRules(rle.getRULEID());
		
		//Runs through and adds to icards to draw
		for (GameRuleCardsDomainModel item: Number_Of_Cards){
			
			iCardsToDraw.add(item.getPICKORDER() -1, item.getNBROFCARDS());
		}

	}

	public int GetMaxNumberOfPlayers() {
		return this.MaxNumberOfPlayers;
	}

	public int GetPlayerNumberOfCards() {
		return this.PlayerNumberOfCards;
	}

	public int GetNumberOfJokers() {
		return this.NumberOfJokers;
	}
	
	public int GetCommunityCardsCount()
	{
		return this.CommunityCardsMax;
	}
	
	public ArrayList<CardDomainModel> GetRuleCards()
	{
		return this.RuleCards;
	}
	public eGame GetGame()
	{
		return this.Game;
	}

	public int getCommunityCardsMin() {
		return CommunityCardsMin;
	}

	public void setCommunityCardsMin(int communityCardsMin) {
		CommunityCardsMin = communityCardsMin;
	}

	public int getCommunityCardsMax() {
		return CommunityCardsMax;
	}

	public void setCommunityCardsMax(int communityCardsMax) {
		CommunityCardsMax = communityCardsMax;
	}

	public int getPlayerCardsMin() {
		return PlayerCardsMin;
	}

	public void setPlayerCardsMin(int playerCardsMin) {
		PlayerCardsMin = playerCardsMin;
	}

	public int getPlayerCardsMax() {
		return PlayerCardsMax;
	}
	
	public int getTotalCardsToDraw()
	{
		return this.GetPlayerNumberOfCards() + this.getCommunityCardsMax();
	}

	public void setPlayerCardsMax(int playerCardsMax) {
		PlayerCardsMax = playerCardsMax;
	}

	public int getPossibleHandCombinations() {
		return PossibleHandCombinations;
	}

	public void setPossibleHandCombinations(int possibleHandCombinations) {
		PossibleHandCombinations = possibleHandCombinations;
	}

	public LinkedList getiCardsToDraw() {
		return iCardsToDraw;
	}

	public void setiCardsToDraw(LinkedList iCardsToDraw) {
		this.iCardsToDraw = iCardsToDraw;
	}
	
}