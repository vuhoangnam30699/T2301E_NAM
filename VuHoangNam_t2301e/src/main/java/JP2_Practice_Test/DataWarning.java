package JP2_Practice_Test;

public class DataWarning {
    private Integer id;
    private String fieldName;

    public DataWarning(Integer id, String fieldName) {
        this.id = id;
        this.fieldName = fieldName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "DataWarning{" +
                "id=" + id +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }
}
