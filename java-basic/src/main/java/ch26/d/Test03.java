// select 결과 값을 자바 인스턴스에 온전히 담는 방법
//
package ch26.d;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test03 {

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
    
    // select 문에서 컬럼을 지정할 때 자바 인스턴스의 프로퍼티 이름과 다르다면
    // 별명을 이용하여 프로퍼티 명과 같게 한다.
    Board2 board = sqlSession.selectOne("board.select4"); // OK!
    System.out.println(board);
    
  }

}
