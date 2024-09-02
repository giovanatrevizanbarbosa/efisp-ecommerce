package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.csv.Csv;

import java.util.Arrays;

public class Administrator extends User {
    private Title title;

    public Administrator(Long id, String name, String email, String password, Title title){
        super(id, name, email, password);
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
        var csvData = Arrays.copyOf(csv.getData(), csv.getData().length + 1);
        csvData[csv.getData().length] = title.getId().toString();
        csv.setData(csvData);

        return csv;
    }
}