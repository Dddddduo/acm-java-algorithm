import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        String result = now.format(formatter).substring(8,12);

        System.out.println(result);

    }
}
