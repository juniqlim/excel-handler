import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WriteExcelTest {
    @Test
    void test() {
        List<List<String>> dataset = Arrays.asList(
            Arrays.asList(new String[]{"이름", "닉네임", "이메일", "전화번호", "등록일시"}),
            Arrays.asList(new String[]{"임준규", "juniq", "juniqlim@gmail.com", "01012345678", "2022/06/12 16:59:07"}),
            Arrays.asList(new String[]{"전민경", "minkee", "minkeejeon@gmail.com", "01087654321", "2022/06/12 16:59:45"})
        );

        WriteExcel writeExcel = new WriteExcel(dataset);

        File file = writeExcel.file("src/test/resources/write.xlsx");
        assertThat(file.exists()).isTrue();
    }
}
