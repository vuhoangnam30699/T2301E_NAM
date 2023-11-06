package product;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class MainStore {
    public static void main(String[] args) throws IOException {
        File file = new File("product.xml");
        XmlMapper mapper = new XmlMapper();
        Store stores = mapper.readValue(file, Store.class);
    }
}
