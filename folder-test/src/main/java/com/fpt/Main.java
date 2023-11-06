package com.fpt;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String text = "xin chao moi nguoi";
//        String capitalize = StringUtils.capitalize(text);
//        System.out.println(capitalize);
//
//        String capitalize2 = WordUtils.capitalizeFully(text);
//        System.out.println(capitalize2);

//        -----------------------------------------------------------

//        List<Integer> integers = List.of(9, 6, 8, 1, 5);
//        List<Integer> integers1 = List.of(5, 6, 7, 8);
//        List<Integer> union = ListUtils.union(integers, integers1);
//
//        Integer max = Collections.max(integers);
//        Integer min = Collections.min(integers);
//
//        System.out.println("Số lớn nhất : " + max);
//        System.out.println("Số nhỏ nhất : " + min);
//        System.out.println(union);

//        -------------------------------------------------------------

        String name = "Vũ Hoàng Nam";
        String school = "ĐH GTVT";

        new Student();

        Student student = Student.builder()
                .name(name)
                .school(school)
                .dateOfBirth(LocalDate.of(1999, 6, 30))
                .password("tuwraclo30699")
                .build();
    }
}