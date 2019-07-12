package redoc.sq.base.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractOptimisticLockable {

    @Version
    private Integer version;

    /**
     * Get the value of version.
     *
     * @return The value of version.
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Set the version.
     *
     * @param version Version.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}
