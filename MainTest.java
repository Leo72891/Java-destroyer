import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class MainTest {
    public static void main(String[] args) throws Exception {
        check("sentence", "No pain, no gain\n",
                "n : 4\na : 2\ni : 2\no : 2\ng : 1\np : 1\n");
        check("mixed case", "aAaBBbCc\n", "a : 3\nb : 3\nc : 2\n");
        check("alphabetical tie", "zYxXyZ\n", "x : 2\ny : 2\nz : 2\n");
        check("frequency first", "abbCCCdddd\n", "d : 4\nc : 3\nb : 2\na : 1\n");
        check("ignore non-ASCII", "한글 A1a! B? éÉ İı K\n", "a : 2\nb : 1\n");
        check("no letters", "123 !? 한글\n", "알파벳이 없습니다.\n");
        check("empty line", "\n", "알파벳이 없습니다.\n");
        check("end of input", "", "알파벳이 없습니다.\n");
        String expected = "";
        for (char c = 'a'; c <= 'z'; c++) {
            expected += c + " : 2\n";
        }
        check("all 26 letters", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz\n",
                expected);
        System.out.println("All 9 tests passed.");
    }

    private static void check(String name, String input, String expectedResult)
            throws Exception {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (PrintStream captured = new PrintStream(buffer, true, "UTF-8")) {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(captured);
            Main.main(new String[0]);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
        String separator = "------------------------------------------------\n";
        String expected = separator + "문자열을 입력하시오.\n" + separator
                + separator + "입력한 문자열의 알파벳 출현 횟수\n" + expectedResult;
        String actual = buffer.toString("UTF-8").replace("\r\n", "\n");
        if (!expected.equals(actual)) {
            throw new AssertionError(name + "\nExpected:\n" + expected + "Actual:\n" + actual);
        }
        System.out.println("PASS: " + name);
    }
}
