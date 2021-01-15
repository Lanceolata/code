package com.lanceolata.code.snippets.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

/**
 * CSV工具类
 */
public final class CsvUtils {
    private CsvUtils() {}

    private static final String NEW_LINE_SEPARATOR = "\n";

    /**
     * 读CSV
     *
     * @param is
     * @param headers
     * @return
     * @throws IOException
     */
    public static List<CSVRecord> read(InputStream is, String[] headers) throws IOException {
        CSVFormat formator = CSVFormat.DEFAULT.withHeader(headers);
        Reader reader = new InputStreamReader(is);
        CSVParser parser = new CSVParser(reader, formator);
        List<CSVRecord> records = parser.getRecords();
        parser.close();
        is.close();
        return records;
    }

    /**
     * 写CSV
     *
     * @param os
     * @param headers
     * @param recordList
     * @throws IOException
     */
    public static void write(OutputStream os, String[] headers, List<String[]> recordList) throws IOException {
        CSVFormat formator = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        CSVPrinter printer = new CSVPrinter(osw, formator);
        printer.printRecord(headers);
        if (null != recordList) {
            for (String[] it : recordList) {
                printer.printRecord(it);
            }
        }
        printer.flush();
        printer.close();
    }
}
