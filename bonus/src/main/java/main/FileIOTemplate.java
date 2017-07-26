package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import domain.GameInfo;
import domain.Team;
import domain.TeamNameComparator;

public class FileIOTemplate {

	public static void main(String[] args) throws IOException, ParseException {
		ArrayList<Team> teams = new ArrayList<Team>();
		ArrayList<GameInfo> games = new ArrayList<GameInfo>();

		try {
			FileInputStream excelFile = new FileInputStream(new File("Analytics_Attachment.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);

			/******************************** read file ******************************************/

			/****** get first data sheet, Division_Info ******/
			XSSFSheet Sheet = workbook.getSheetAt(0);
			// get rows
			Iterator<Row> iterator = Sheet.iterator();
			// eliminate the first row
			iterator.next();

			// iterate through all rows
			while (iterator.hasNext()) {
				// get current working rows and create trade object
				XSSFRow currentRow = (XSSFRow) iterator.next();
				Team team = new Team(currentRow);
				teams.add(team);
			}

			/****** get second data sheet, 2016_17_NBA_Scores ******/
			Sheet = workbook.getSheetAt(1);
			// get rows
			iterator = Sheet.iterator();
			// eliminate the first row
			iterator.next();

			// iterate through all rows
			while (iterator.hasNext()) {
				// get current working rows and create trade object
				XSSFRow currentRow = (XSSFRow) iterator.next();
				GameInfo game = new GameInfo(currentRow);
				games.add(game);
			}

			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}

		// //////////////////test use////////////////////////////
		FileWriter writer = new FileWriter(new File("data.txt"));
		for (Team team : teams) {
			writer.write(team.toString() + "\n");
		}
		for (GameInfo game : games) {
			writer.write(game.toString() + "\n");

		}
		writer.close();

		/******************************** write file ******************************************/
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		XSSFSheet sheet = workbook1.createSheet("NBA_Clinch_Dates");

		// create file field header
		Object[] fields = { "Team", "Date Eliminated" };

		System.out.println("Creating excel");
		int rowNum = 0;
		int colNum = 0;
		// write data field header
		XSSFRow row = sheet.createRow(rowNum++);
		for (Object field : fields) {
			Cell cell = row.createCell(colNum++);
			cell.setCellValue((String) field);
		}

		// sort teams according to their name's alphabet order
		teams.sort(new TeamNameComparator());
		
		//write team's playoff/eliminated information
		for (Team team : teams) {
			row = sheet.createRow(rowNum++);
			colNum = 0;

			XSSFCell cell;
			cell = row.createCell(colNum++);
			cell.setCellValue(team.getTeam_name());
			cell = row.createCell(colNum++);
			cell.setCellValue(team.getDate_eliminated());
		}

		// output to file
		try {
			FileOutputStream outputStream = new FileOutputStream("NBA_Clinch_Dates.xlsx");
			workbook1.write(outputStream);
			workbook1.close();
		} catch (FileNotFoundException e) {
			 e.printStackTrace();
			throw new IOException();
		} catch (IOException e) {
			 e.printStackTrace();
			throw new IOException();
		}
		
		System.out.println("Done");

	}
}
