package day2.part1;

import day2.part1.Command;

/**
 * ����
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.exe();
    }
}
