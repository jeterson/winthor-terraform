package com.jmg.providers.excelprovider.domain.core.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
public class DataSet {

    private List<DataTable> tables = new ArrayList<>();
}
