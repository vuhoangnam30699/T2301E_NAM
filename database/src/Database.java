import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Database<T extends Record<ID>, ID> {
    private List<T> records = new ArrayList<>();

    public void save(T record) {
        if (record.getId() == null) {
            Integer maxId = records.stream()
                    .mapToInt(r -> (Integer) r.getId())
                    .max()
                    .orElse(0);
            record.setId((ID) (Integer.valueOf(maxId + 1)));
        }

        T existingRecord = find(record.getId());
        if (existingRecord != null) {
            records.remove(existingRecord);
        }

        record.setUpdatedAt();
        records.add(record);
    }

    public T find(ID id) {
        return records.stream()
                .filter(record -> record.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public T delete(ID id) {
        T record = find(id);
        if (record != null) {
            records.remove(record);
            return record;
        }
        return null;
    }


    public List<T> findByCreatedAtAfter(ZonedDateTime time) {
        return records.stream()
                .filter(record -> !record.getCreatedAt().isBefore(time))
                .collect(Collectors.toList());
    }

    public List<T> findByUpdatedAtAfter(ZonedDateTime time) {
        return records.stream()
                .filter(record -> !record.getUpdatedAt().isBefore(time))
                .collect(Collectors.toList());
    }

    public List<T> getAllRecords() {
        return new ArrayList<>(records);
    }

}
