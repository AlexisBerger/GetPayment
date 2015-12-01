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
 * Created by Alexis on 01/12/2015.
 */
public class CSV{
    private ArrayList<Operation> csv;

    public CSV(String file){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        try {
            String line ="";
            int i = 0;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("file"));
            while ((line = bufferedReader.readLine())!=null){
                String compte = "";
                String client ="";
                String type = "";
                Date date = new Date();
                Double montant = 0.0;
                TypeOperation typeOperation = TypeOperation.DEBITE;
                if(i!=0){
                    StringTokenizer stringTokenizer = new StringTokenizer(line,";");

                    client = stringTokenizer.nextToken();
                       compte = stringTokenizer.nextToken();
                    try {
                        date = simpleDateFormat.parse(stringTokenizer.nextToken());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    type = stringTokenizer.nextToken();
                    if(type.equals("apport")){
                        typeOperation = TypeOperation.CREDITE;
                    }else if(type.equals("retrait")){
                        typeOperation = TypeOperation.DEBITE;
                    }
                    try {
                        montant = Double.parseDouble(stringTokenizer.nextToken());
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                    csv.add(new Operation(compte, client, date, montant, typeOperation));
                }else {
                    i++;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Operation> getCsv() {
        return csv;
    }
}
