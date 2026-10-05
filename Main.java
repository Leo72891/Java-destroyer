import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("문자열을 입력하시오.");
        System.out.println("------------------------------------------------");

        // 공백을 포함한 한 줄 전체를 입력받는다.
        String input = scanner.hasNextLine() ? scanner.nextLine() : "";
        int[] counts = new int[26];

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // 영문 대문자를 소문자로 변환한다.
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + ('a' - 'A'));
            }

            // 숫자, 공백, 기호, 한글 등은 집계하지 않는다.
            if (c >= 'a' && c <= 'z') {
                counts[c - 'a']++;
            }
        }

        System.out.println("------------------------------------------------");
        System.out.println("입력한 문자열의 알파벳 출현 횟수");

        boolean[] printed = new boolean[26];
        boolean found = false;

        // 아직 출력하지 않은 문자 중 빈도가 가장 큰 문자를 선택한다.
        for (int rank = 0; rank < 26; rank++) {
            int best = -1;
            for (int i = 0; i < 26; i++) {
                if (!printed[i] && counts[i] > 0) {
                    // a부터 탐색하고 더 클 때만 교체하므로 동률은 알파벳순이다.
                    if (best == -1 || counts[i] > counts[best]) {
                        best = i;
                    }
                }
            }

            if (best == -1) {
                break;
            }

            System.out.println((char) ('a' + best) + " : " + counts[best]);
            printed[best] = true;
            found = true;
        }

        if (!found) {
            System.out.println("알파벳이 없습니다.");
        }
    }
}
