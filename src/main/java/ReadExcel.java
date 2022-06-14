import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
    private final File file;

    public ReadExcel(File file) {
        this.file = file;
    }

    public List<List<String>> dataset() {
        Workbook workbook = openWorkbook();
        Sheet sheet = firstSheet(workbook);
        List<List<String>> dataset = makeDataset(sheet);
        closeWorkbook(workbook);
        return dataset;
    }

    private List<List<String>> makeDataset(Sheet sheet) {
        return new ReadExcelSheet(sheet).makeDataSheet();
    }

    private Sheet firstSheet(Workbook workbook) {
        return workbook.getSheetAt(0);
    }

    private void closeWorkbook(Workbook workbook) {
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Workbook openWorkbook() {
        try {
            return WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
