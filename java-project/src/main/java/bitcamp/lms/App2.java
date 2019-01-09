// 1,2,3 단계 실행
package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    final int length = 100;

    int[] no = new int[length];
    String[] name = new String[length];
    String[] email = new String[length];
    String[] password = new String[length];
    String[] photo = new String[length];
    String[] tel = new String[length];
    Date[] registeredDate = new Date[length];

    int index = 0;
    while (index < length) {
      System.out.print("번호? ");
      no[index] = Integer.parseInt(keyboard.nextLine());

      System.out.print("이름? ");
      name[index] = keyboard.nextLine();

      System.out.print("이메일? ");
      email[index] = keyboard.nextLine();

      System.out.print("암호? ");
      password[index] = keyboard.nextLine();

      System.out.print("사진? ");
      photo[index] = keyboard.nextLine();

      System.out.print("전화? ");
      tel[index] = keyboard.nextLine();

      registeredDate[index] = new Date(System.currentTimeMillis()); 

      System.out.println();
      index++;

      // 계속 진행할 것인가?
      System.out.println("계속 입력 하시겠습니까?(Y/n) ");
      String answer = keyboard.nextLine();
      if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("")) {
        break;
      }
    }

    // 사용후 스캐너 객체의 자원을 해제한다.
    keyboard.close();

    System.out.println(); // 빈 줄 출력

    for (int i = 0; i < index; i++) {
      System.out.printf("%3d, %-20s, %-30s, %-10s, %-20s, %s, %s\n", 
          no[i], name[i], email[i], password[i], photo[i], tel[i], registeredDate[i]);
    }
  }
}
