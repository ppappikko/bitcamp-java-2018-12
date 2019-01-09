/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int length = 10; // 배열 크기
    int[] nums = new int[length];
    String[] contents = new String[length];
    Date[] createdDate = new Date[length];
    int[] count = new int[length];

    // 입력할 내용
    int i = 0; // 배열의 index값 0 초기화
    while (i < length) {
      System.out.print("번호? ");
      nums[i] = Integer.parseInt(keyboard.nextLine());

      System.out.print("내용? ");
      contents[i] = keyboard.nextLine();

      // 생성 날짜 자동 입력
      createdDate[i] = new Date(System.currentTimeMillis());

      // 조회수 초기화
      count[i] = 0;

      i++; // index 값 증가

      // 계속 진행할 것인가?
      System.out.println("계속 입력 하시겠습니까?(Y/n) ");
      String answer = keyboard.nextLine();
      if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("")) {
        break;
      }
    }
    keyboard.close();
    System.out.println(); // 공백 출력

    // 출력할 내용
    i = 0; // 배열의 index값 0으로 초기화
    while (i < length) {
      System.out.printf("%d, %-20s, %s, %d\n", 
          nums[i], contents[i], createdDate[i], count[i]);
      i++;
    }


  }
}
