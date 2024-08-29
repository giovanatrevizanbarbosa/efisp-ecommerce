package efisp.efispecommerce.models.repository.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import efisp.efispecommerce.models.repository.Util;
import efisp.efispecommerce.models.repository.Writable;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class CsvReaderWriter<T> {

    private final Path path;
    private final String clazzName;
    private CSVWriter csvWriter;
    private CSVReader csvReader;

    public CsvReaderWriter(String clazzName) throws InvalidPathException{
        this.clazzName = clazzName;
        path = Path.of(Util.RESOURCES_PATH.value() + "/" + getDatasetName(clazzName));
        buildWriter();
        buildReader();
    }

    private String getDatasetName(String clazzName) {
        if (clazzName.endsWith("ss")) {
            return clazzName.toLowerCase() + "es.csv";
        }
            return clazzName.toLowerCase() + "s.csv";
    }

    private void buildWriter() throws InvalidPathException{
        try {
            if (Files.exists(path)) {
                Files.delete(path);
            }

            Writer writer = Files.newBufferedWriter(path);
            csvWriter = new CSVWriter(writer);
        } catch (Exception e) {
            throw new InvalidPathException(String.valueOf(path), e.getMessage());
        }
    }

    private void buildReader() throws InvalidPathException{
        try {
            Reader reader = Files.newBufferedReader(path);
            csvReader = new CSVReader(reader);
        } catch (Exception e) {
            throw new InvalidPathException(String.valueOf(path), e.getMessage());
        }
    }

    public void save(List<Writable> data) throws CsvException {
        try {
            buildWriter();

            csvWriter.writeNext(data.getFirst().toCSV().getHeader());
            csvWriter.flush();

            for (Writable csv : data) {
                csvWriter.writeNext(csv.toCSV().getData());
            }
            csvWriter.flush();
        } catch (IOException | InvalidPathException e) {
            throw new CsvException("Error saving file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> read() throws CsvException {
        try {
           List<T> tList = new LinkedList<>();

            csvReader.readAll().forEach(obj -> {

                Writable writable = DomainConverter.fromCsv(new Csv(obj), clazzName);
                tList.add((T) writable);
            }
           );

           return tList;
        } catch (IOException | InvalidPathException e) {
            throw new CsvException("Error reading file: " + e.getMessage());
        }
    }

}
