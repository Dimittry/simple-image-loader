package imageloader.imageloader.Entities;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AppImageIdSequence")
    @SequenceGenerator(name = "AppImageIdSequence", sequenceName = "users_seq_gen_users_id_seq_seq")
    private Long id;

    private String name;

    public Image() {}

    public Image(final String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
