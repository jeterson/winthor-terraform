package com.jmg.providers.excelprovider.domain.core.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class DataRow {

    private List<DataColumn> columns = new ArrayList<>();
    private Integer index;

    public Optional<Object> getValue(String columnName) {

        return columns
                .stream()
                .filter(x -> x.getName().equals(columnName))
                .map(DataColumn::getValue)
                .findFirst();
    }

    public Optional<Object> getValue(int index) {
        try {
            var column = columns.get(index);
            return Optional.ofNullable(column.getValue());
        }catch (Exception e) {
            return Optional.empty();
        }
    }

}
