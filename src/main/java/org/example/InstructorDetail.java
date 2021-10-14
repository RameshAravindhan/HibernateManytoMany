package org.example;


import javax.persistence.*;

@Entity
@Table(name = "instructor_detail", schema = "PUBLIC")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "youtube_channel")
    private String channel;
    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy="instructorDetail",
            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
                    CascadeType.REFRESH})
    //@JoinColumn(name = "")
    private Instructor instructor;

    public InstructorDetail(String channel, String hobby) {
        this.channel = channel;
        this.hobby = hobby;
    }


    public InstructorDetail() {

    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", channel='" + channel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
