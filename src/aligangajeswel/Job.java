package aligangajeswel;

public class Job {
    private int id;
    private String title;
    private String description;

    public Job(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

   
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}