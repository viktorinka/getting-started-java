package tests.lesson_10;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class WorkWithFilesTests {
    private ClassLoader cl = WorkWithFilesTests.class.getClassLoader();

    @Test
    void readZipForPdfTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("test_archive.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                if (entry.getName().equals("test_pdf.pdf")) {
                    PDF pdf = new PDF(zs);
                    Assertions.assertTrue(pdf.text.contains("На горной речке перекаты"));
                }
            }
        }
    }

    @Test
    void readZipForCsvTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("test_archive.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                if (entry.getName().equals("test_csv.csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zs));
                    List<String[]> content = csvReader.readAll();
                    Assertions.assertArrayEquals(new String[]{"2;Геворк;бурлят и говорят со мной.;;"}, content.get(2));
                }
            }
        }
    }

    @Test
    void readZipForXlsxTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("test_archive.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                if (entry.getName().equals("test_xlsx.xlsx")) {
                    XLS xls = new XLS(zs);
                    Assertions.assertTrue(xls.excel.getSheetAt(0).getRow(3).getCell(2).getStringCellValue().contains("Там ивы горбятся, лохматы,"));
                }
            }
        }
    }

    @Test
    void readZipForJsonTest() throws Exception {
        Gson gson = new Gson();
        try (InputStream is = cl.getResourceAsStream("person.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            JsonObject jsonObject = gson.fromJson(isr, JsonObject.class);
            Assertions.assertFalse(jsonObject.get("isMarried").getAsBoolean());
            Assertions.assertEquals(30, jsonObject.get("age").getAsInt());
        }
    }

    @Test
    void readZipForJsonPrettyTest() throws Exception {
        Gson gson = new Gson();
        try (InputStream is = cl.getResourceAsStream("person.json");
             InputStreamReader isr = new InputStreamReader(is)) {
           Person person = gson.fromJson(isr, Person.class);
            Assertions.assertEquals("123 123-123", person.contactNumbers.get(0).number);
            Assertions.assertEquals("Football", person.favoriteSports.get(0));
            Assertions.assertEquals(123, person.car.model);
            Assertions.assertFalse(person.isMarried);
        }
    }
}
