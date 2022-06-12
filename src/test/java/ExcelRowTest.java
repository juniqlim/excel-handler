import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Arrays;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

class ExcelRowTest {
    @Test
    void test() {
        ExcelRow excelRow = new ExcelRow(Arrays.asList("이름", "닉네임", "이메일", "전화번호", "등록일시"));

        XSSFWorkbook workbook = new XSSFWorkbook();
        Row row = workbook.createSheet().createRow(0);

        assertThatCode(() -> excelRow.row(row)).doesNotThrowAnyException();
    }
}