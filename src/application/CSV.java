package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Class permettant de r�aliser des op�ration � partir d'un fichier Created by
 * Alexis on 01/12/2015.
 */
public class CSV {
	private ArrayList<Operation> csv;

	/**
	 * Constructeur de la class CSV
	 * 
	 * @param file
	 *            : le fichier � charger qui contient les op�rations
	 */
	public CSV(String file) {
		csv = new ArrayList<Operation>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			String line = "";
			int i = 0;
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			while ((line = bufferedReader.readLine()) != null) {
				String compte = "";
				String client = "";
				String type = "";
				Date date = new Date();
				Double montant = 0.0;
				TypeOperation typeOperation = TypeOperation.DEBITE;
				if (i != 0) {
					StringTokenizer stringTokenizer = new StringTokenizer(line, ";");

					client = stringTokenizer.nextToken();
					compte = stringTokenizer.nextToken();
					try {
						date = simpleDateFormat.parse(stringTokenizer.nextToken());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					type = stringTokenizer.nextToken();
					if (type.equals("apport")) {
						typeOperation = TypeOperation.CREDITE;
					} else if (type.equals("retrait")) {
						typeOperation = TypeOperation.DEBITE;
					}
					try {
						montant = Double.parseDouble(stringTokenizer.nextToken());
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
					csv.add(new Operation(compte, client, date, montant, typeOperation));
				} else {
					i++;
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Getter permettant de r�cup�rer la liste des op�rations du fichier
	 * 
	 * @return la liste des op�rations
	 */
	public ArrayList<Operation> getCsv() {
		return csv;
	}
}
