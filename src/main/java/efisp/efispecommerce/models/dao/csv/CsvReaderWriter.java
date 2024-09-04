package efisp.efispecommerce.models.dao.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import efisp.efispecommerce.models.Util;
import efisp.efispecommerce.models.dao.Writable;

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

    public CsvReaderWriter(String clazzName) throws InvalidPathException{
        this.clazzName = clazzName;
        var utilPath = Util.RESOURCES_PATH_FOR_TEST.value();

        path = Path.of(utilPath + "/" + getDatasetName(clazzName));

        if (utilPath.equals(Util.RESOURCES_PATH_FOR_TEST.value())) {
            deleteFile();
        }
    }

    private String getDatasetName(String clazzName) {
        if (clazzName.endsWith("ss")) {
            return clazzName.toLowerCase() + "es.csv";
        }
            return clazzName.toLowerCase() + "s.csv";
    }

    private CSVWriter buildWriter() throws InvalidPathException{
        try {
            Writer writer = Files.newBufferedWriter(path);
            return new CSVWriter(writer);
        } catch (Exception e) {
            throw new InvalidPathException(String.valueOf(path), e.getMessage());
        }
    }

    private CSVReader buildReader() throws InvalidPathException{
        try {
            Reader reader = Files.newBufferedReader(path);
            return new CSVReader(reader);
        } catch (Exception e) {
            throw new InvalidPathException(String.valueOf(path), e.getMessage());
        }
    }

    private void deleteFile(){
        try{
            if (Files.exists(path)) {
                Files.delete(path);
            }
        } catch (IOException e) {
            System.out.println("Error deleting file: " + e.getMessage());
        }
    }

    public void save(List<Writable> data) throws CsvException {
        try {
            deleteFile();
            CSVWriter csvWriter = buildWriter();

           if (data.isEmpty()) return;

           csvWriter.writeNext(data.getFirst().toCSV().getHeader());
           csvWriter.flush();

           for (Writable csv : data) {
               csvWriter.writeNext(csv.toCSV().getData());
           }

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException | InvalidPathException e) {
            throw new CsvException("Error saving file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> read() throws CsvException {
        try {
            if (!Files.exists(path)) {
                return new LinkedList<>();
            }

            CSVReader csvReader = buildReader();
            List<T> tList = new LinkedList<>();
                csvReader.readAll().forEach(obj -> {
                    if (!obj[0].equals("id")){
                        Csv csv = new Csv();
                        csv.setData(obj);
                        tList.add((T) DomainConverter.fromCsv(csv, clazzName));
                    }
                }
           );

           return tList;
        } catch (IOException | InvalidPathException e) {
            throw new CsvException("Error reading file: " + e.getMessage());
        }
    }

}
