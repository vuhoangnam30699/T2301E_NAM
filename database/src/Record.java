import java.time.ZonedDateTime;

public abstract class Record<ID> {
    private ID id;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public Record(ID id) {
        this.id = id;
        this.createdAt = ZonedDateTime.now();
        this.updatedAt = ZonedDateTime.now();
    }

    public ID getId() {
        return id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public void setUpdatedAt() {
        this.updatedAt = ZonedDateTime.now();
    }
}
