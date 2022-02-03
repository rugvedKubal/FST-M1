import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Activity13_1 {

        public static void main(String[] args) throws IOException, CsvException {

            CSVReader reader = new CSVReader(new FileReader("src/main/java/sample.csv"));

            List<String[]> rows = reader.readAll();
            System.out.println("Total number of rows are: " + rows.size());

            Iterator<String[]> itr = rows.iterator();

            while(itr.hasNext()) {
                String[] str = itr.next();

                System.out.print("Row values are: ");
                for(int i = 0; i < str.length; i++) {
                    System.out.print(" " + str[i]);
                }
                System.out.println();
            }
            reader.close();
        }
}

