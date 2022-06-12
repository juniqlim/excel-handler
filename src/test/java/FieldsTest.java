import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Arrays;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

class FieldsTest {
    @Test
    void test() {
        List<String> fields = Arrays.asList("이름", "닉네임", "이메일", "전화번호", "등록일시");
        Fields excelRow = new Fields(fields);

        XSSFWorkbook workbook = new XSSFWorkbook();
        Row row = workbook.createSheet().createRow(0);

        assertThatCode(() -> excelRow.makeExcelRow(row)).doesNotThrowAnyException();
    }
}