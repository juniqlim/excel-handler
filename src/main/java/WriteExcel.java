import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
    private final List<Fields> dataset;

    public WriteExcel(List<Fields> dataset) {
        this.dataset = dataset;
    }

    public File excelFile(String filePath) {
        Workbook workbook = makeWorkbook();
        return makeFile(filePath, workbook);
    }

    public File excelFile(String filePath, CellStyle cellStyle) {
        Workbook workbook = makeWorkbook(cellStyle);
        return makeFile(filePath, workbook);
    }

    private Workbook makeWorkbook() {
        Workbook workbook = new XSSFWorkbook();
        makeSheet(workbook);
        return workbook;
    }

    private Workbook makeWorkbook(CellStyle cellStyle) {
        Workbook workbook = new XSSFWorkbook();
        makeSheet(workbook, cellStyle);
        return workbook;
    }

    private void makeSheet(Workbook workbook) {
        Sheet sheet = workbook.createSheet();
        for (int i = 0; i < dataset.size(); i++) {
            dataset.get(i).makeExcelRow(sheet.createRow(i));
        }
    }

    private void makeSheet(Workbook workbook, CellStyle cellStyle) {
        Sheet sheet = workbook.createSheet();
        for (int i = 0; i < dataset.size(); i++) {
            dataset.get(i).makeExcelRow(sheet.createRow(i), cellStyle);
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
