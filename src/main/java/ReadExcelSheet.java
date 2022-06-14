import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadExcelSheet {
    private final Sheet sheet;

    public ReadExcelSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public List<List<String>> makeDataSheet() {
        List<List<String>> dataset = new ArrayList<>();

        ReadExcelRow headerRow = new ReadExcelRow(sheet.getRow(0));
        int headerCellSize = headerRow.cellSize();
        dataset.add(headerRow.makeFields());

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            dataset.add(new ReadExcelRow(sheet.getRow(i), headerCellSize).makeFields());
        }
        return dataset;
    }
}
