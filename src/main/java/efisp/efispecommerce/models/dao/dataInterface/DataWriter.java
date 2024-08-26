package efisp.efispecommerce.models.dao.dataInterface;

import com.opencsv.CSVWriter;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class DataWriter {

    private final CSVWriter csvWriter;

    public DataWriter(String datasetName, Writable<?> writable) {
        try {
            Writer writer = Files.newBufferedWriter(Path.of(Paths.get("./").toAbsolutePath().getParent() + "/resources/dataset/" + datasetName + ".csv"));
            csvWriter = new CSVWriter(writer);
            csvWriter.writeNext(writable.toCSV().getHeader());
        } catch (Exception e) {
            throw new InvalidPathException(String.valueOf(Path.of(Paths.get("./").toAbsolutePath().getParent() + "/resources/dataset/" + datasetName + ".csv")), e.getMessage());
        }
    }

    public void writeCsv(Writable<?> writable) {
        try {
            csvWriter.writeNext(writable.toCSV().getData());
            csvWriter.flush();
        } catch (Exception e) {
            throw new RuntimeException("Error writing to CSV file: " + e.getMessage());
        }
    }

    public void writeAllCsv(Writable<?>[] writables) {
        if (writables != null) {
            for (Writable<?> writable : writables) {
                writeCsv(writable);
            }
        }

        throw new NullPointerException("Array is null");
    }

    public void overwriteAllCsv(Writable<?>[] writables) {
        try {
            Files.deleteIfExists(Path.of(Paths.get("./").toAbsolutePath().getParent() + "/resources/dataset/users.csv"));
            writeAllCsv(writables);
        } catch (Exception e) {
            throw new RuntimeException("Error overwriting CSV file: " + e.getMessage());
        }
    }

}
