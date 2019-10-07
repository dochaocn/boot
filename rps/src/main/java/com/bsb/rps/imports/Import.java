package com.bsb.rps.imports;

import java.util.Map;

public interface Import {

    void process(Map<String, String> paramMap);

    String getImportTaskName();
}
