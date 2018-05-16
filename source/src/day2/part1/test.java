package day2.part1;

public class test {
    public static void main(String[] args) {
        Receiver receiver=new Receiver();
        Command command=new MyCommand(receiver);
        Invoker invoker=new Invoker(command);
        invoker.action();
    }
}
