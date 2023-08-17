import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Database<T extends Record> {
    private List<T> records;

    public Database() {
        this.records = new ArrayList<>();
    }

    private int nextId = 1;

    public int getNextId() {
        return nextId++;
    }

    public void save(T record) {
        if (record.getId() == null) {
            record.setId(getNextId());
        }

        boolean isNew = !records.contains(record);
        if (isNew) {
            records.add(record);
        } else {
            records.set(records.indexOf(record), record);
        }
    }

    public T find(int id){
        return records.stream()
                .filter(record -> record.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public T delete(int id){
        T record = find(id);
        if(record != null){
            records.remove(record);
        }
        return record;
    }


    public List<T> findByCreatedAtAfter(ZonedDateTime time) {
        return records.stream()
                .filter(record -> record.getCreatedAt().isAfter(time) || record.getCreatedAt().isEqual(time))
                .collect(Collectors.toList());
    }

    public List<T> findByUpdatedAtAfter(ZonedDateTime time) {
        return records.stream()
                .filter(record -> record.getUpdatedAt().isAfter(time) || record.getCreatedAt().isEqual(time))
                .collect(Collectors.toList());
    }
}
