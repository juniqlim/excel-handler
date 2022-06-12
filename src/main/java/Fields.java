import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

public class Fields {
    private final List<String> fields;

    public Fields(List<String> fields) {
        this.fields = fields;
    }

    public void makeExcelRow(Row row) {
        for (int i = 0; i < fields.size(); i++) {
            setCell(row.createCell(i), fields.get(i));
        }
    }

    public void makeExcelRow(Row row, CellStyle cellStyle) {
        for (int i = 0; i < fields.size(); i++) {
            setCell(row.createCell(i), fields.get(i), cellStyle);
        }
    }

    private void setCell(Cell cell, String field, CellStyle cellStyle) {
        setCell(cell, field);
        cell.setCellStyle(cellStyle);
    }

    private void setCell(Cell cell, String field) {
        cell.setCellValue(field);
    }
}
