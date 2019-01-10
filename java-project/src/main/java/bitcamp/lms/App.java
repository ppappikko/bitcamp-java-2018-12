// 1단계: 입력에 반복문 적용
package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    // 키보드 입력 스트림 (System.in)을 스캐너 객체에 연결한다.
    // => 스캐너는 입력 스트림으로 들어온 문자열을 줄 단위로 잘라주는 역할을 수행한다.
    Scanner keyboard = new Scanner(System.in);
    final int length = 10;
    Lesson[] lesson = new Lesson[length];

    // 입력 받을 내용
    int index = 0;
    while (index < length) {
      lesson[index] = new Lesson();

      System.out.print("번호? ");
      // 정수 값 index를 선언해서 입력 받음. 배열의 인덱스 값은 0부터 이므로 -1 해줌.
      lesson[index].num = Integer.parseInt(keyboard.nextLine()); // 첫 번호를 1로 주기 위해 +1 해줌.

      System.out.print("수업명? ");
      lesson[index].title = keyboard.nextLine();

      System.out.print("수업내용? ");
      lesson[index].content = keyboard.nextLine();

      System.out.print("시작일? ");
      lesson[index].startDate = Date.valueOf(keyboard.nextLine());

      System.out.print("종료일? ");
      lesson[index].endDate = Date.valueOf(keyboard.nextLine());

      System.out.print("총수업시간? ");
      lesson[index].totalTime = Integer.parseInt(keyboard.nextLine());

      System.out.print("일수업시간? ");
      lesson[index].dayTime = Integer.parseInt(keyboard.nextLine());

      System.out.println();  // 빈 줄 출력
      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String choose = keyboard.nextLine();

      index++;

      System.out.println(); // 빈 줄 출력
      if (!choose.equalsIgnoreCase("y") && !choose.equalsIgnoreCase("")) {
        break;
      }
    }
    keyboard.close();

    // 출력할 내용
    int tmp = 0; // 인덱스로 사용하기 위한 정수 값 tmp를 선언 및 0으로 초기화
    while (tmp < index) {
      System.out.printf("%3d, %-20s, %s ~ %s, %4d\n", 
          lesson[tmp].num, lesson[tmp].title, lesson[tmp].startDate,
          lesson[tmp].endDate, lesson[tmp].totalTime);
      tmp++; // 인덱스 증가
    }
  }
}
