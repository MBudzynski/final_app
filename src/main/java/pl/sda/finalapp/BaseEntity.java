package pl.sda.finalapp;

import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Version;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EqualsAndHashCode(of="id")
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Version
    private Integer version;

    public Integer getId() {
        return id;
    }


}
