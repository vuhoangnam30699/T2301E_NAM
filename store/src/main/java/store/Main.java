package store;

import org.apache.lucene.util.SloppyMath;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Zipcode> zipcodes = List.of(
                Zipcode.builder()
                        .zip("10000")
                        .lng(105.784725)
                        .lat(21.029617)
                        .address("Cầu Giấy")
                        .build(),
                Zipcode.builder()
                        .zip("10010")
                        .lng(105.808134)
                        .lat(21.026909)
                        .address("Mỹ Đình")
                        .build(),
                Zipcode.builder()
                        .zip("10323")
                        .lng(105.774526)
                        .lat(21.006677)
                        .address("Hai Bà Trưng")
                        .build(),
                Zipcode.builder()
                        .zip("24230")
                        .lng(106.669533)
                        .lat(20.845220)
                        .address("Chùa Bộc")
                        .build()
        );
        List<Store> stores = List.of(
                Store.builder().zip("10000").name("Store Cầu Giấy").address("Cầu Giấy").code("S1").build(),
                Store.builder().zip("10323").name("Adidas Hai Bà Trưng").address("Hai Bà Trưng").code("S2").build(),
                Store.builder().zip("10010").name("Nike Mỹ Đình").address("Mỹ Đình").code("S3").build(),
                Store.builder().zip("24230").name("Thượng Đình").address("Chùa Bộc").code("S4").build()
        );

        List<Product> products = List.of(
                Product.builder().name("Quần").price(10.0).sku("P1").build(),
                Product.builder().name("Áo").price(7.0).sku("P2").build(),
                Product.builder().name("Giầy").price(20.5).sku("P3").build(),
                Product.builder().name("Mũ").price(6.5).sku("P4").build()
        );

        List<Inventory> inventories = List.of(
                Inventory.builder().sku("P1").storeCode("S1").quantity(0).build(),
                Inventory.builder().sku("P1").storeCode("S1").quantity(4).build(),
                Inventory.builder().sku("P2").storeCode("S2").quantity(5).build(),
                Inventory.builder().sku("P2").storeCode("S2").quantity(1).build(),
                Inventory.builder().sku("P3").storeCode("S3").quantity(0).build(),
                Inventory.builder().sku("P3").storeCode("S3").quantity(9).build(),
                Inventory.builder().sku("P4").storeCode("S4").quantity(5).build(),
                Inventory.builder().sku("P4").storeCode("S4").quantity(2).build()
        );

        final String targetZipcode = "10000";
        final String targetSku = "P1";

        //Q1
//        Zipcode zipcode = zipcodes.stream()
//                .filter(f -> f.getZip().equals(targetZipcode))
//                .findFirst()
//                .orElse(null);

        //Q2
//        List<Zipcode> nearbyZipcodes = zipcodes.stream()
//                .filter(zip ->
//                        SloppyMath.haversinMeters(
//                                zip.getLat(), zip.getLng(),
//                                zipcode.getLat(), zipcode.getLng()) <= 10000)
//                .collect(Collectors.toList());

        //Q3
//        List<String> nearbyZipCodeString = nearbyZipcodes.stream()
//                .map(Zipcode::getZip)
//                .collect(Collectors.toList());
//
//        List<Store> nearbyStores = stores.stream()
//                .filter(s -> nearbyZipCodeString.contains(s.getZip()))
//                .collect(Collectors.toList());


        //Q4
//        List<String> storeCodes = stores.stream()
//                .map(Store::getCode)
//                .collect(Collectors.toList());
//        List<Store> result = inventories.stream()
//                .filter(i -> storeCodes.contains(i.getStoreCode()))
//                .filter(i -> i.getSku().equals(targetSku))
//                .filter(i -> i.getQuantity() > 0)
//                .map(i -> i.getStoreCode())
//                .map(code -> Store.getStoreFromCode(nearbyStores, code))
//                .collect(Collectors.toList());
//        System.out.println(result);


        List<Store> result = inventories.stream()
                .filter(i -> stores.stream()
                        .map(Store::getCode)
                        .collect(Collectors.toList())
                        .contains(i.getStoreCode()))
                .filter(i -> i.getSku().equals(targetSku))
                .filter(i -> i.getQuantity() > 0)
                .map(i -> i.getStoreCode())
                .map(code -> Store.getStoreFromCode(stores.stream()
                        .filter(s -> zipcodes.stream()
                                .filter(zip -> SloppyMath.haversinMeters(
                                        zip.getLat(), zip.getLng(),
                                        zipcodes.stream()
                                                .filter(f -> f.getZip().equals(targetZipcode))
                                                .findFirst()
                                                .orElse(null)
                                                .getLat(), zipcodes.stream()
                                                .filter(f -> f.getZip().equals(targetZipcode))
                                                .findFirst()
                                                .orElse(null)
                                                .getLng()) <= 10000)
                                .map(Zipcode::getZip)
                                .collect(Collectors.toList())
                                .contains(s.getZip()))
                        .collect(Collectors.toList()), code))
                .collect(Collectors.toList());

        System.out.println(result);

    }
}
