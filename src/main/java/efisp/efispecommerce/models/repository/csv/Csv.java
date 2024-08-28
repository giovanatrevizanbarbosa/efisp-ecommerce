package efisp.efispecommerce.models.repository.csv;

public class Csv {

    private String[] data;
    private String[] header;

    public Csv(String[] header){
        this.header = header;
    }

    public Csv(String[] header, String[] data){
        this.data = data;
        this.header = header;
    }


    public String[] getData() {
        return data;
    }

    public String[] getHeader() {
        return header;
    }


    public void setData(String[] data) {
        this.data = data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

}
