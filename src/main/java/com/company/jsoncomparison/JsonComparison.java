package com.company.jsoncomparison;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class JsonComparison {

    public static void PrintMessagesAboutComparing(File json1, File json2) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        //тип, в который будет мапиться json
        TypeReference<HashMap<String, Object>> type =
                new TypeReference<HashMap<String, Object>>() {};

        Map<String, Object> leftMap = mapper.readValue(json1, type);
        Map<String, Object> rightMap = mapper.readValue(json2, type);


        //создаём словари без вложенностей
        Map<String, Object> leftFlatMap = FlatMapUtil.flatten(leftMap);
        Map<String, Object> rightFlatMap = FlatMapUtil.flatten(rightMap);


        //https://guava.dev/releases/20.0/api/docs/com/google/common/collect/MapDifference.html
        MapDifference<String, Object> difference = Maps.difference(leftFlatMap, rightFlatMap);

        System.out.println("Entries only on the left\n--------------------------");
        difference.entriesOnlyOnLeft()
                .forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("\n\nEntries only on the right\n--------------------------");
        difference.entriesOnlyOnRight()
                .forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("\n\nEntries differing\n--------------------------");
        difference.entriesDiffering()
                .forEach((key, value) -> System.out.println(key + ": " + value));


    }

}
