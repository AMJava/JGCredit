package lv.javaguru.java2.domain;

import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.UUID;

/**
 * Created by ArtursMaslennikovs on 13/09/2016.
 */

@MappedSuperclass
public class BaseEntityWithId {
    @Id
    @Column(name = "id", nullable = false, length = 36, columnDefinition = "int")
    private String id;

    @PrePersist
    public void prePersistLogic() {
        if (StringUtils.isEmpty(this.id)) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntityWithId)) return false;

        BaseEntityWithId that = (BaseEntityWithId) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
