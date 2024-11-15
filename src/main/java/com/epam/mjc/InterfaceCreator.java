package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> list.stream().allMatch(s -> Character.isUpperCase(s.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> even = list.stream()
                    .filter(val -> val % 2 == 0)
                    .collect(Collectors.toList());

            list.addAll(even);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(val -> Character.isUpperCase(val.charAt(0))
                        && val.charAt(val.length() - 1) == '.'
                        && val.split(" ").length > 3)
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> list.stream().collect(
                Collectors.toMap(
                        str -> str,
                        str -> str.length()
                )
        );
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> list3 = new ArrayList<>();
            list3.addAll(list1);
            list3.addAll(list2);
            return list3;
        };
    }
}
