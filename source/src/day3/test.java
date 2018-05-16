package day3;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String[] s={"hello","android"};
        List list=new ArrayList();
        for (int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
