package efisp.efispecommerce.models.dao.dataInterface;

public class CSV {
    private String[] header;
    private String[] data;

    public String[] getHeader() {
        return header;
    }

    public String[] getData() {
        return data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
