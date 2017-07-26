package domain;

import org.apache.poi.xssf.usermodel.XSSFRow;

public class Team {

	
	private String team_name;
	private String division_id;
	private String conference_id;
	private String date_eliminated;
	
	
	public Team(XSSFRow currentRow){
		this.team_name=currentRow.getCell(0).getStringCellValue();
		this.division_id=currentRow.getCell(1).getStringCellValue();
		this.conference_id=currentRow.getCell(2).getStringCellValue();
		this.date_eliminated="test";
	}
	
	
	
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getDivision_id() {
		return division_id;
	}
	public void setDivision_id(String division_id) {
		this.division_id = division_id;
	}
	public String getConference_id() {
		return conference_id;
	}
	public void setConference_id(String conference_id) {
		this.conference_id = conference_id;
	}



	public String getDate_eliminated() {
		return date_eliminated;
	}



	public void setDate_eliminated(String date_eliminated) {
		this.date_eliminated = date_eliminated;
	}



	@Override
	public String toString() {
		return "Team [team_name=" + team_name + ", division_id=" + division_id + ", conference_id=" + conference_id + "]";
	}
}
