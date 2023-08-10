package store;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Zipcode {
    private String zip;
    private String address;
    private Double lat;
    private Double lng;

    public Zipcode(String zip, String address, Double lat, Double lng) {
        this.zip = zip;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }
}

