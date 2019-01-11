// 1단계: 입력에 반복문 적용
package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    // 키보드 입력 스트림 (System.in)을 스캐너 객체에 연결한다.
    // => 스캐너는 입력 스트림으로 들어온 문자열을 줄 단위로 잘라주는 역할을 수행한다.
    Scanner keyboard = new Scanner(System.in);
    final int length = 10; // 배열의 크기값
    
    Lesson[] lesson = new Lesson[length]; 
    // Lesson 메모리 타입의 레퍼런스 배열의 주소를 담을 lesson 레퍼런스 변수 생성
    // new Lesson[배열크기]로 배열의 크기값 만큼
    // Lesson 메모리 타입의 인스턴스의 주소를 담을 레퍼런스 배열 생성 후
    // 레퍼런스 배열의 주소를 lesson에 넣는다.
    // 이때 레퍼런스 배열의 인덱스 값은 자동으로 초기화 (null)

    // 입력 받을 내용
    int index = 0;
    while (index < length) {
      lesson[index] = new Lesson();
      // lesson은 레퍼런스 변수이다.
      // 이 레퍼런스가 가르키는 배열은 레퍼런스 배열이다.
      // 레퍼런스 배열은 Heap 영역에 생성되며 인덱스들의 값이 주소값이다. (초기화 상태 null)
      // 인덱스들 마다 각각 Lesson 인스턴스를 생성하여 주소값을 넣어준다.
      // Lesson의 인스턴스들은 Heap 영역에 랜덤하게 생성된다.

      System.out.print("번호? ");
      lesson[index].num = Integer.parseInt(keyboard.nextLine());
      // lesson 레퍼런스 변수가 가리키는 레퍼런스 배열의 index번 인스턴스(객체)에 있는
      // 필드(변수)인 num에 키보드 입력 값을 넣어준다.

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
    // 반복문이 종료되면 Stack 영역에 생성되었던 변수와 메서드들은 사라진다.
    // call by reference
    
    
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
