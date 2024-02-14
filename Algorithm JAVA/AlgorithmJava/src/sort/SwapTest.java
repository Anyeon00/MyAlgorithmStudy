package sort;

public class SwapTest {
    public static void main(String[] args) {
        // 쓰지말기, 배열index로 접근해서 사용하는 경우 뭔가 오류생김
        int a = 2;
        int b = 4;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a + ", " +b);
    }
}
