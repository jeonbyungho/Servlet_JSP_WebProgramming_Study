import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisBuild {

   private final String RESOURCE = "./config/mybatis-config.xml";

   public Temp searchTemp(int id) {
      try {
         InputStream inputStream = Resources.getResourceAsStream(RESOURCE);
         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

         SqlSession session = sqlSessionFactory.openSession();

         Temp temp = session.selectOne("TempMapper.selectTemp", id);
         
         return temp;

      } catch (IOException e) {
         System.err.println("MyBatios 설정 파일 가져오는 중에 에러 발생!");
         e.printStackTrace();
      }

      return null;
   }
}
