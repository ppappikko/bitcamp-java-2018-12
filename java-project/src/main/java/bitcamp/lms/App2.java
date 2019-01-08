/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    // 키보드 입력 장치 선언
    Scanner keyboard = new Scanner(System.in);

    int length = 10; // 배열 크기
    int[] nums = new int[length];
    String[] names = new String[length];
    String[] emails = new String[length];
    String[] passWords = new String[length];
    String[] photos = new String[length];
    String[] phoneNums = new String[length];
    Date[] today = new Date[length];

    // 입력 받을 내용
    while (true) {
      System.out.print("번호? ");
      int select = Integer.parseInt(keyboard.nextLine())-1;
      nums[select] = select +1;

      System.out.print("이름? ");
      names[select] = keyboard.nextLine();

      System.out.print("이메일? ");
      emails[select] = keyboard.nextLine();

      System.out.print("암호? ");
      passWords[select] = keyboard.nextLine();

      System.out.print("사진? ");
      photos[select] = keyboard.nextLine();

      System.out.print("전화? ");
      phoneNums[select] = keyboard.nextLine();

      // 현재 가입 날짜 생성
      today[select] = new Date(System.currentTimeMillis());
      // java.sql.Date registeredDate = new java.sql.Date(System.currentTimeMillis());

      System.out.println();  // 빈 줄 출력
      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String choose = keyboard.nextLine();
      if (!choose.equalsIgnoreCase("y") && !choose.equalsIgnoreCase("")) {
        break;
      }
    }

    keyboard.close();

    System.out.println();  // 빈 줄 출력

    // 출력할 내용
    int i = 0;
    while (i < length) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          nums[i], names[i], emails[i], phoneNums[i], today[i]);
      i++;
    }
  }
}
