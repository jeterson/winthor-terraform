package com.jmg.providers.excelprovider.domain.core.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DataTable {
    private String name;
    private List<String> headers = new ArrayList<>();
    private List<DataRow> rows = new ArrayList<>();
    private Integer index;

    public DataTable(String name) {
        this.name = name;
    }
}
