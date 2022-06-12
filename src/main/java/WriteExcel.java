import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
    private final List<List<String>> dataset;

    public WriteExcel(List<List<String>> dataset) {
        this.dataset = dataset;
    }

    public File file(String filePath) {
        File excelFile = new File(filePath);
        Workbook workbook = makeWorkbook();

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return excelFile;
    }

    private Workbook makeWorkbook() {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet();
        List<String> row;
        for (int i = 0; i < dataset.size(); i++) {
            Row header = sheet.createRow(i);
            row = dataset.get(i);
            for (int j = 0; j < row.size(); j++) {
                header.createCell(j).setCellValue(row.get(j));
            }
        }
        return workbook;
    }
}
