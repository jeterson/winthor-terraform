package com.jmg.providers.excelprovider.domain.core.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class DataColumn {
    private static final String STRING_EMPTY = "";
    private String name;
    private Object value;
    private Integer index;
    private XSSFCell apachePoiColumn;

     public void setApachePoiColumn(XSSFCell cell) {
        this.apachePoiColumn = cell;
    }
    private XSSFCell getApachePoiColumn() {
         return apachePoiColumn;
    }

    public double getValueAsDouble() {
        if(apachePoiColumn == null)
            return 0;
        return apachePoiColumn.getNumericCellValue();
    }
    public Optional<Date> getValueAsDate() {
        if(apachePoiColumn == null)
            return Optional.empty();
        return Optional.ofNullable(apachePoiColumn.getDateCellValue());
    }
    public Optional<LocalDateTime> getValueAsLocalDateTime() {
        if(apachePoiColumn == null)
            return Optional.empty();
        return Optional.ofNullable(apachePoiColumn.getLocalDateTimeCellValue());
    }
    public String getValueAsString() {
        if(apachePoiColumn == null)
            return STRING_EMPTY;
        return apachePoiColumn.getStringCellValue();
    }
    public boolean getValueAsBoolean() {
        if(apachePoiColumn == null)
            return false;
        return apachePoiColumn.getBooleanCellValue();
    }

    public Optional<LocalDate> getValueAsLocalDate() {
        if(getValueAsDate().isEmpty())
            return Optional.empty();
        var date = getValueAsDate().get();

        return Optional.ofNullable(Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
    }



}
