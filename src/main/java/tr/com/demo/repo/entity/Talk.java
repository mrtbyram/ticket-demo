package tr.com.demo.repo.entity;

import javax.persistence.*;

/**
 * Created by muratbayram on 07/03/2017.
 */
@Entity
@Table(name = "talk")
public class Talk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "speaker")
    private String speaker;

    @Column(name = "subject")
    private String subject;

    @Column(name = "image")
    private String image;


    public Integer getId() {
        return id;
    }

    public Integer getEventId() {
        return eventId;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getSubject() {
        return subject;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
