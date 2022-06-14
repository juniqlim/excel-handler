import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadExcelRow {
    private final Row row;
    private final int cellSize;

    public ReadExcelRow(Row row) {
        this(row, 0);
    }

    public ReadExcelRow(Row row, int cellSize) {
        this.row = row;
        this.cellSize = cellSize;
    }

    public List<String> makeFields() {
        List<String> fields = new ArrayList<>();
        for (int j = 0; j < cellSize(); j++) {
            fields.add(makeField(row.getCell(j)));
        }
        return fields;
    }

    public int cellSize() {
        if (cellSize == 0) {
            return row.getPhysicalNumberOfCells();
        } else {
            return cellSize;
        }
    }

    private String makeField(Cell cell) {
        if (cell == null) {
            return "";
        }
        return cell.toString();
    }
}
