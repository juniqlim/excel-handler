# Excel Handler
POI를 이용하여  
1. 엑셀파일의 데이터를 자바 객체(Collection)로 변환하고
2. 자바 객체(Collection)를 엑셀파일로 변환하는

모듈

## 사용법
Excel file -> Object
```java 
File file = Paths.get("src/test/resources/sample1.xlsx").toFile();
ReadExcel readExcel = new ReadExcel(file);
List<List<String>> dataset = readExcel.dataset();
```
Object -> Excel file
```java
List<List<String>> dataset = Arrays.asList(
    Arrays.asList("이름", "닉네임", "이메일", "전화번호", "등록일시"),
    Arrays.asList("임준규", "juniq", "juniqlim@gmail.com", "01012345678", "2022/06/12 16:59:07"),
    Arrays.asList("전민경", "minkee", "minkeejeon@gmail.com", "01087654321", "2022/06/12 16:59:45")
);

WriteExcel writeExcel = new WriteExcel(dataset);
writeExcel.makeWorkbook();
File file = writeExcel.excelFile("src/test/resources/write1.xlsx"); 
```
자세한 사용법은 [ReadExcelTest](https://github.com/juniqlim/excel-handler/blob/master/src/test/java/ReadExcelTest.java), [WriteExcelTest](https://github.com/juniqlim/excel-handler/blob/master/src/test/java/WriteExcelTest.java) 클래스 참조.