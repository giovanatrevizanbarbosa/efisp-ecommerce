package efisp.efispecommerce.models.dao;

import com.opencsv.CSVWriter;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataWriter {

    private CSVWriter csvWriter;

    public DataWriter(String datasetName) {
        try {
            Writer writer = Files.newBufferedWriter(Path.of(Paths.get("./").toAbsolutePath().getParent().getParent() + "/" + datasetName + ".csv"));
            csvWriter = new CSVWriter(writer);
            csvWriter.writeNext(new String[]{"id", "name", "email", "password"});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeCsv(Writable writable) {
        try {
            csvWriter.writeNext(writable.toCSV());
            csvWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
