package ar.unrn.tp3.modelo;

import java.util.Arrays;
import java.util.stream.Collectors;

enum Region {

    US("US"), China("China"), Europe("Europa");

    private final String code;

    Region(String code) {
        this.code = code;
    }

    String getCode() {
        return code;
    }

    static Region getByCode(String code) {
        return Arrays.stream(Region.values())
                .filter(region -> region.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("Region desconocida. Las conocidas son: " + getKnownRegions())
                );
    }

    static String getKnownRegions() {
        return Arrays.stream(Region.values())
                .map(Region::getCode)
                .collect(Collectors.joining(", "));
    }

}
