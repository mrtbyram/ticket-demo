package tr.com.demo.repo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by muratbayram on 07/03/2017.
 */
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "place")
    private String place;

    @Column(name = "date")
    private Date date;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPlace() {
        return place;
    }

    public Date getDate() {
        return date;
    }
}
