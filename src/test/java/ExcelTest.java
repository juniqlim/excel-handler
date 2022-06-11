import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.Test;

class ExcelTest {
    @Test
    void 엑셀파일_로드() {
        File file = Paths.get("src/test/resources/sample.xlsx").toFile();
        assertThatCode(() -> new Excel(file)).doesNotThrowAnyException();
    }

    @Test
    void 엑셀파일을_데이터셋으로_변환() {
        File file = Paths.get("src/test/resources/sample.xlsx").toFile();
        Excel excel = new Excel(file);
        List<List<String>> dataset = excel.dataset();

        assertThat(dataset.size()).isNotZero();
    }
}
