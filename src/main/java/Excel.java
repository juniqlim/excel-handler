import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    private final XSSFWorkbook workbook;

    public Excel(File file) {
        this(workbook(file));
    }

    public Excel(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    private static XSSFWorkbook workbook(File file) {
        try {
            return new XSSFWorkbook(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
