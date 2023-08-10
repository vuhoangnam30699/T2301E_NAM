package store;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Store
{
    private String zip;
    private String name;
    private String address;
    private String code;

    public Store(String zip, String name, String address, String code) {
        this.zip = zip;
        this.name = name;
        this.address = address;
        this.code = code;
    }

    public static Store getStoreFromCode(List<Store> storeList, String code){
        return storeList.stream()
                .filter(s -> s.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }
}

