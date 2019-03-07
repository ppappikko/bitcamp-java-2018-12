// dynamic SQL문 다루기 - <sql> 태그 사용법
//
package ch26.g;

import java.io.InputStream;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

  public static void main(String[] args) throws Exception {
    
    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/g/mybatis-config.xml");
    
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    // dynamic sql?
    // => 조건에 따라 SQL이 변경되는 것.
    // => mybatis는 이를 위해 조건문, 반복문 등을 다룰 수 있도록 특별한 태그를 제공한다.
    
    // 조건문 사용하기
    // => 검색어의 여부에 따라 where 절 추가를 조정해보자!
    Scanner keyboard = new Scanner(System.in);
    System.out.print("게시물 번호? ");
    String keyword = keyboard.nextLine();
    keyboard.close();
    
    Board board = sqlSession.selectOne("board.select1", Integer.parseInt(keyword));
    System.out.println(board);
    System.out.println("----------------------------------------------");
    
  }

}
