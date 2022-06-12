import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WriteExcelTest {
    @Test
    void test() {
        List<Fields> dataset = Arrays.asList(
            new Fields(Arrays.asList("이름", "닉네임", "이메일", "전화번호", "등록일시")),
            new Fields(Arrays.asList("임준규", "juniq", "juniqlim@gmail.com", "01012345678", "2022/06/12 16:59:07")),
            new Fields(Arrays.asList("전민경", "minkee", "minkeejeon@gmail.com", "01087654321", "2022/06/12 16:59:45"))
        );

        WriteExcel writeExcel = new WriteExcel(dataset);

        File file = writeExcel.excelFile("src/test/resources/write.xlsx");
        assertThat(file.exists()).isTrue();
    }
}
