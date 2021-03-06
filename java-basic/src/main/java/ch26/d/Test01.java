// selectOne()과 selectList()
//
package ch26.d;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

  public static void main(String[] args) throws Exception {
    
    // 1) mybatis-config.xml 변경
    //    - 클래스 전체 이름에 대해 별명을 지정한다.
    // 2) BoardMapper.xml 변경
    //    - 결과를 담을 클래스를 지정할 때 클래스 전체 이름을 사용하는 대신에
    //      mybatis 설정 파일에 등록된 별명을 사용할 수 있다.
    //
    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/d/mybatis-config.xml");
    
    InputStream inputStream2 = new FileInputStream(
        "/home/bitcamp/git/bitcamp-java-2018-12/java-basic/src/main/java/ch26/d/mybatis-config.xml");
    
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    // selectList()
    // => 여러 개의 결과 값을 리턴하는 select를 실행할 때 사용한다.
    // => select 실행으로 생성된 각 row의 값은 resultType에 지정한 클래스의 인스턴스에 저장된다.
    // => 그리고 그 인스턴스는 List 구현체에 담겨 리턴된다.
    //
    List<Board> list = sqlSession.selectList("board.select1");
    
    for (Board b : list) {
      System.out.printf("%d, %s, %s, %s, %d\n",
          b.getBoard_id(),
          b.getTitle(),
          b.getContents(),
          b.getCreated_date(),
          b.getView_count());
    }
    System.out.println("------------------------------------");
    
    // selectOne()
    // => 한 개의 결과 값을 리턴하는 select를 실행할 때 사용한다.
    // => 만약 여러 개의 결과가 리턴되는 select를 실행한다면 예외가 발생한다.
    
    // board.select1 SQL 문은 여러 개의 결과값이 리턴되기 때문에
    // selectOne()으로 실행해서는 안된다.
    // 실행중 오류가 발생한다.
    // selectList()를 실행해야 한다.
    //Board board = sqlSession.selectOne("board.select1");
    
    Board board = sqlSession.selectOne("board.select2"); // OK!
    
    System.out.println(board);
  }

}
