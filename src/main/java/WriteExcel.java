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
        Workbook workbook = makeWorkbook();
        return makeFile(filePath, workbook);
    }

    private Workbook makeWorkbook() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        for (int i = 0; i < dataset.size(); i++) {
            makeRows(dataset.get(i), sheet.createRow(i));
        }
        return workbook;
    }

    private void makeRows(List<String> row, Row sheetRow) {
        for (int j = 0; j < row.size(); j++) {
            sheetRow.createCell(j).setCellValue(row.get(j));
        }
    }

    private File makeFile(String filePath, Workbook workbook) {
        File excelFile = new File(filePath);
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return excelFile;
    }
}
