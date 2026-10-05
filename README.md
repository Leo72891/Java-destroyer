# Java-destroyer — 알파벳 빈도 계산

입력한 한 줄에서 `String.charAt()`으로 문자를 하나씩 읽고 영문 알파벳의 출현 횟수를 계산하는 Java 프로그램입니다.

## 동작 규칙

- `a~z`, `A~Z`만 집계합니다.
- 대소문자를 구분하지 않으며 결과는 소문자로 표시합니다.
- 출현 횟수 내림차순, 횟수가 같으면 알파벳 오름차순으로 출력합니다.
- 출현하지 않은 알파벳은 출력하지 않습니다.
- 공백, 숫자, 특수문자, 한글 등은 무시합니다.
- 빈 줄이나 입력 종료(EOF), 알파벳이 없는 입력은 `알파벳이 없습니다.`로 표시합니다.

## 파일

- `Main.java`: 실행 프로그램. 클래스 이름은 `Main`입니다.
- `MainTest.java`: 외부 라이브러리 없이 실행하는 자동 테스트입니다.

## 실행 방법

JDK 8 이상이 필요합니다. 터미널에서 `java -version`, `javac -version`으로 설치를 확인합니다.

저장소를 다운로드한 후 `Main.java`가 있는 폴더에서 실행합니다.

```sh
javac -encoding UTF-8 Main.java
java Main
```

문자열을 입력하고 Enter를 누르세요. 한 번 실행할 때 한 줄을 처리합니다.

JDK 11 이상에서는 컴파일 명령 없이 다음 방법도 가능합니다.

```sh
java Main.java
```

### VS Code

1. 이 저장소 폴더를 VS Code에서 엽니다.
2. Microsoft의 **Extension Pack for Java**와 JDK가 설치되어 있어야 합니다.
3. `Main.java`를 열어 `main` 메서드 위의 **Run**을 누르거나, 통합 터미널에서 위 명령을 실행합니다.
4. 입력은 터미널에서 합니다. 파일명 `Main.java`와 클래스명 `Main`의 대소문자를 일치시켜야 합니다.

## 실행 예시

입력: `No pain, no gain`

```text
------------------------------------------------
문자열을 입력하시오.
------------------------------------------------
No pain, no gain
------------------------------------------------
입력한 문자열의 알파벳 출현 횟수
n : 4
a : 2
i : 2
o : 2
g : 1
p : 1
```

위 예시의 입력 문자열 줄은 사용자가 입력한 내용입니다.

## 구현 설명

1. `charAt(i)`로 각 문자를 읽습니다.
2. 대문자라면 `'a' - 'A'`만큼 더해 소문자로 바꿉니다.
3. `counts[c - 'a']`에 횟수를 누적합니다.
4. 아직 출력하지 않은 알파벳 중 횟수가 가장 큰 것을 반복 선택합니다.
5. a부터 z까지 탐색하고 횟수가 **더 클 때만** 선택을 바꾸므로 동률이면 알파벳순이 유지됩니다.

입력 길이를 n이라 하면 시간 복잡도는 O(n + 26²), 추가 공간은 O(26)입니다.

## 테스트 실행

```sh
javac -encoding UTF-8 Main.java MainTest.java
java MainTest
```

각 테스트는 입력을 제공한 뒤 안내 문구를 포함한 전체 표준 출력을 예상값과 비교합니다. 실패하면 `AssertionError`로 종료합니다.

## 실제 테스트 결과

OpenJDK 17.0.20 환경에서 아래 9개 테스트를 실행하여 모두 통과했습니다.
검증 환경에는 `javac` 실행 파일이 없어 동일한 JDK 컴파일러를 모듈로 실행했습니다.

```sh
java -m jdk.compiler/com.sun.tools.javac.Main -encoding UTF-8 Main.java MainTest.java
java MainTest
```

| 테스트 | 입력 | 확인된 결과 (출력 순서) |
|---|---|---|
| 기본 문장 | `No pain, no gain` | n:4, a:2, i:2, o:2, g:1, p:1 |
| 대소문자 혼합 | `aAaBBbCc` | a:3, b:3, c:2 |
| 동률 정렬 | `zYxXyZ` | x:2, y:2, z:2 |
| 빈도 우선 정렬 | `abbCCCdddd` | d:4, c:3, b:2, a:1 |
| 비영문 제외 | `한글 A1a! B? éÉ İı K` | a:2, b:1 |
| 알파벳 없음 | `123 !? 한글` | 알파벳이 없습니다. |
| 빈 줄 | Enter만 입력 | 알파벳이 없습니다. |
| 입력 종료 | EOF | 알파벳이 없습니다. |
| 26자 전체 | A~Z 뒤에 a~z | a부터 z까지 각각 2회 |

실제 자동 테스트 출력:

```text
PASS: sentence
PASS: mixed case
PASS: alphabetical tie
PASS: frequency first
PASS: ignore non-ASCII
PASS: no letters
PASS: empty line
PASS: end of input
PASS: all 26 letters
All 9 tests passed.
```
