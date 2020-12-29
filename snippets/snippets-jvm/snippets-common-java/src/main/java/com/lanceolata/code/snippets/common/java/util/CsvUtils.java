package com.lanceolata.code.snippets.common.java.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CsvUtils {
    private static final String NEW_LINE_SEPARATOR = "\n";

    public CsvUtils() {
    }

    public static void write(OutputStream os, String[] headers, List<String[]> recordList) throws IOException {
        CSVFormat formator = CSVFormat.DEFAULT.withRecordSeparator("\n");
        OutputStreamWriter osw = new OutputStreamWriter(os);
        CSVPrinter printer = new CSVPrinter(osw, formator);
        printer.printRecord(headers);
        if (null != recordList) {
            Iterator var6 = recordList.iterator();

            while(var6.hasNext()) {
                String[] lineData = (String[])var6.next();
                printer.printRecord(lineData);
            }
        }

        printer.flush();
        printer.close();
    }

    public static List<CSVRecord> read(InputStream is, String[] headers) throws IOException {
        CSVFormat formator = CSVFormat.DEFAULT.withHeader(headers);
        Reader reader = new InputStreamReader(is);
        CSVParser parser = new CSVParser(reader, formator);
        List<CSVRecord> records = parser.getRecords();
        parser.close();
        is.close();
        return records;
    }
}
