import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

public class WriteExcelRow {
    private final List<String> fields;

    public WriteExcelRow(List<String> fields) {
        this.fields = fields;
    }

    public void makeRow(Row row) {
        for (int i = 0; i < fields.size(); i++) {
            setCell(row.createCell(i), fields.get(i));
        }
    }

    public void changeCellStyle(Row row, CellStyle cellStyle) {
        for (int i = 0; i < fields.size(); i++) {
            row.getCell(i).setCellStyle(cellStyle);
        }
    }

    private void setCell(Cell cell, String field) {
        cell.setCellValue(field);
    }
}
