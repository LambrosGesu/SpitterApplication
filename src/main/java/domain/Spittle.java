package domain;
import javax.persistence.*;


@Entity
@Table(name = "SPITTLES")
public class Spittle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spittle_id", nullable = false)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "date", nullable = false)
    private String date;

    @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "spitter_id", nullable = true)
    private Spitter spitter;

    public Spittle() {
    }

    public Spittle(String message, String date, Spitter spitter) {
        this.message = message;
        this.date = date;
        this.spitter = spitter;
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

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    @Override
    public String toString() {
        return "Spittle{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                ", spitter=" + spitter.getFirstname() + ", " + spitter.getLastname() +
                '}';
    }
}
