package domain;
import java.util.List;

public class Spittle {
    private Long id;
    private String message;
    private String date;
    private List<Spittle> spittles;

    public Spittle(Long id, String message, String date) {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Spittles{" +
                "message='" + message + '\'' +
                ", date=" + date +
                '}'+'\n';
    }
}
