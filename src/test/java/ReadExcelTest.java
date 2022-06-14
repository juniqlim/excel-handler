import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.Test;

class ReadExcelTest {
    @Test
    void 엑셀파일_로드() {
        File file = Paths.get("src/test/resources/sample1.xlsx").toFile();
        assertThatCode(() -> new ReadExcel(file)).doesNotThrowAnyException();
    }

    @Test
    void 엑셀파일을_데이터셋으로_변환() {
        File file = Paths.get("src/test/resources/wallet_charge_NPE.xlsx").toFile();
        ReadExcel readExcel = new ReadExcel(file);
        List<List<String>> dataset = readExcel.dataset();

        assertThat(dataset.size()).isEqualTo(3);
    }

    @Test
    void 엑셀파일을_데이터셋으로_변환_중간에_빈셀_포함() {
        File file = Paths.get("src/test/resources/sample2.xlsx").toFile();
        ReadExcel readExcel = new ReadExcel(file);
        List<List<String>> dataset = readExcel.dataset();

        assertThat(dataset.size()).isNotZero();
        assertThat(dataset.get(2).get(2)).isEqualTo("");
    }
}
