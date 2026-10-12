# static 변수와 메서드, 생성자 연습

## 학습 목표
- 생성자 `Car(String color)`를 이용해 자동차 객체 생성
- `static` 변수로 전체 자동차와 색상별 자동차 개수 공유
- `equalsIgnoreCase()`로 색상 문자열의 대소문자 구분 없이 비교
- `static` 메서드로 개수 조회

## 파일
- `Car.java`: 자동차 개수를 관리하는 클래스
- `CarTest.java`: 빨간색·파란색 자동차를 생성하고 결과를 출력하는 테스트 클래스

## 실행 방법
JDK가 설치된 터미널에서 이 폴더로 이동한 후 실행합니다.

```sh
javac -encoding UTF-8 Car.java CarTest.java
java -cp . CarTest
```

## 예상 실행 결과
```text
-> 자동차 수 : 3, 빨간색 자동차 수 : 2
-> 자동차 수 : 3, 파란색 자동차 수 : 1
```

`red`, `blue`, `RED` 순서로 객체를 생성하므로 총 3대 중 빨간색 2대, 파란색 1대입니다.
