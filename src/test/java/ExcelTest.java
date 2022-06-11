import static org.assertj.core.api.Assertions.assertThatCode;

import java.io.File;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class ExcelTest {
    @Test
    void 엑셀파일_로드() {
        File file = Paths.get("src/test/resources/sample.xlsx").toFile();
        assertThatCode(() -> new Excel(file)).doesNotThrowAnyException();
    }
}
