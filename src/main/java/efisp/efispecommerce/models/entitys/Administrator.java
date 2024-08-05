package efisp.efispecommerce.models.entitys;

public class Administrator extends User {
    private Title title;

    public Administrator(String name, String email, String password, Title title){
        super(name, email, password);
        this.title = title;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        if (title != null)
            this.title = title;
    }
}