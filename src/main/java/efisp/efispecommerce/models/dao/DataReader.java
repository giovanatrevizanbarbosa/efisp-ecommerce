package efisp.efispecommerce.models.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataReader {

    private CSVReader csvReader;

    public DataReader(String datasetName) {
        try {
            Reader reader = Files.newBufferedReader(Path.of(Paths.get("./").toAbsolutePath().getParent() + "/resources/dataset/" + datasetName + ".csv"));
            csvReader = new CSVReader(reader);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public List<String[]> readCsv() {
        try {
            return csvReader.readAll();
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
