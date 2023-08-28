import obj.Member;
import obj.mapper.MemberMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String res = "./properties/config.xml";
        SqlSessionFactory sessionFactory = null;
        SqlSession session = null;

        System.out.println("● 검색할 유저 이름을 적어주세요.");
        Scanner scanner = new Scanner(System.in);
        String userid = scanner.nextLine().trim();

        try{
            InputStream inputStream = Resources.getResourceAsStream(res);
            sessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);
            session = sessionFactory.openSession();
            
            MemberMapper mapper = session.getMapper(MemberMapper.class);
            
            Member member = mapper.selectMember(userid);

            if(member != null){
                System.out.println("ID : " + member.getId());
                System.out.println("비밀번호 : " + member.getPwd());
                System.out.println("성별 : " + member.getGender());
                System.out.println("전화번호 : " + member.getPhone());
            } else {
                System.out.println("찾을 수 없는 유저입니다.");
            }

        } catch(IOException e){
            System.err.println("xml 설정 파일 불러오기 실패!");
        }
    }
}
