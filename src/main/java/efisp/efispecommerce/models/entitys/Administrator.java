package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.csv.Csv;

import java.util.Arrays;
import java.util.UUID;

public class Administrator extends User {
    private Title title;

    public Administrator(UUID id, String name, String email, String password, String photo, Title title){
        super(id, name, email, password, photo);
        this.title = title;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        if (title != null)
            this.title = title;
    }

    @Override
    public Csv toCSV() {
        var csv = super.toCSV();
        var csvHeader = Arrays.copyOf(csv.getHeader(), csv.getHeader().length + 1);
        csvHeader[csv.getHeader().length] = "title";
        csv.setHeader(csvHeader);
        var csvData = Arrays.copyOf(csv.getData(), csv.getData().length + 1);
        csvData[csv.getData().length] = title.getId().toString();
        csv.setData(csvData);

        return csv;
    }
}