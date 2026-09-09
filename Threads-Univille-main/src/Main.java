import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        Thread.ofPlatform().start(new Includer(list1, list2));
        Thread.ofPlatform().start(new Includer(list1, list2));
        Thread.ofPlatform().start(new Remover(list1));
        Thread.ofPlatform().start(new Printer(list1));


    }
}