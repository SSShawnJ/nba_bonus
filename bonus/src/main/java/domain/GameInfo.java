package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFRow;

public class GameInfo {

	private Date date;
	private String home_team;
	private String away_team;
	private int home_score;
	private int away_score;
	private String winner;
	
	private static SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");

	
	
	public GameInfo(XSSFRow currentRow) throws ParseException{
		this.date=currentRow.getCell(0).getDateCellValue();
		this.home_team=currentRow.getCell(1).getStringCellValue();
		this.away_team=currentRow.getCell(2).getStringCellValue();
		this.home_score=((int)currentRow.getCell(3).getNumericCellValue());
		this.away_score=((int)currentRow.getCell(4).getNumericCellValue());
		this.winner=currentRow.getCell(5).getStringCellValue();
		
	}
	
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getHome_team() {
		return home_team;
	}
	public void setHome_team(String home_team) {
		this.home_team = home_team;
	}
	public String getAway_team() {
		return away_team;
	}
	public void setAway_team(String away_team) {
		this.away_team = away_team;
	}
	public int getHome_score() {
		return home_score;
	}
	public void setHome_score(int home_score) {
		this.home_score = home_score;
	}
	public int getAway_score() {
		return away_score;
	}
	public void setAway_score(int away_score) {
		this.away_score = away_score;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}



	@Override
	public String toString() {
		return "GameInfo [date=" + date + ", home_team=" + home_team + ", away_team=" + away_team + ", home_score=" + home_score + ", away_score="
				+ away_score + ", winner=" + winner + "]";
	}

}
