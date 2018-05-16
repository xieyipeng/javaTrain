package day2.part2;

public class ProxyTest {
    public static void main(String[] args) {
        Sourceable sourceable=new Proxy();
        sourceable.method();
    }
}
