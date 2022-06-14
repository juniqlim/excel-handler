import static java.awt.Color.lightGray;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.junit.jupiter.api.Test;

class WriteExcelTest {
    @Test
    void 엑셀파일_생성() {
        List<List<String>> dataset = Arrays.asList(
            Arrays.asList("이름", "닉네임", "이메일", "전화번호", "등록일시"),
            Arrays.asList("임준규", "juniq", "juniqlim@gmail.com", "01012345678", "2022/06/12 16:59:07"),
            Arrays.asList("전민경", "minkee", "minkeejeon@gmail.com", "01087654321", "2022/06/12 16:59:45"));

        WriteExcel writeExcel = new WriteExcel(dataset);
        writeExcel.makeWorkbook();
        File file = writeExcel.excelFile("src/test/resources/write1.xlsx");
        assertThat(file.exists()).isTrue();
    }

    @Test
    void 액샐파일_생성_with_셀스타일() {
        List<List<String>> dataset = Arrays.asList(
            Arrays.asList("이름", "닉네임", "이메일", "전화번호", "등록일시"),
            Arrays.asList("임준규", "juniq", "juniqlim@gmail.com", "01012345678", "2022/06/12 16:59:07"),
            Arrays.asList("전민경", "minkee", "minkeejeon@gmail.com", "01087654321", "2022/06/12 16:59:45"));

        WriteExcel writeExcel = new WriteExcel(dataset);
        writeExcel.makeWorkbook();
        XSSFCellStyle cellStyle = (XSSFCellStyle) writeExcel.cellStyle();
        createCellStyle(cellStyle);
        writeExcel.changeStyleOfRow(cellStyle, 0);

        File file = writeExcel.excelFile("src/test/resources/write2.xlsx");
        assertThat(file.exists()).isTrue();
    }

    CellStyle createCellStyle(XSSFCellStyle cellStyle) {
        cellStyle.setFillForegroundColor(new XSSFColor(lightGray, new DefaultIndexedColorMap()));

        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        return cellStyle;
    }
}
