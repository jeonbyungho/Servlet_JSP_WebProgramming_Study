import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        System.out.println("Hello, World!");
        MybatisBuild batis = new MybatisBuild();

        // 입력
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID 값을 입력해주세요.");
        int id = scanner.nextInt();
        scanner.close();

        // Select query execute
        Temp temp = batis.searchTemp(id);
        System.out.println("id : " + temp.getId());
        System.out.println("name : " + temp.getName());
    }
}
