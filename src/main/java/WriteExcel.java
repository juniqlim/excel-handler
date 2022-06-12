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
    private Workbook workbook;

    public WriteExcel(List<Fields> dataset) {
        this.dataset = dataset;
    }

    public void makeWorkbook() {
        Workbook workbook = new XSSFWorkbook();
        this.workbook = workbook;
        makeSheet(workbook);
    }

    public CellStyle cellStyle() {
        return workbook.createCellStyle();
    }

    public File excelFile(String filePath) {
        return makeFile(filePath, workbook);
    }

    private void makeSheet(Workbook workbook) {
        Sheet sheet = workbook.createSheet();
        for (int i = 0; i < dataset.size(); i++) {
            dataset.get(i).makeExcelRow(sheet.createRow(i));
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

    public void changeStyleOfRow(CellStyle cellStyle, int rowIndex) {
        dataset.get(rowIndex).changeCellStyle(workbook.getSheetAt(0).getRow(rowIndex), cellStyle);
    }
}
