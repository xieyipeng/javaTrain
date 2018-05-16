* Run

```java
package day4;

public class Run implements Runnable{
    private int ticket=10;
    @Override
    public void run() {
        while (ticket>0){
            System.out.println(Thread.currentThread().getName()+" 还剩 "+--ticket+"张");
        }
    }

    public static void main(String[] args) {
        Run run=new Run();
        Thread thread1=new Thread(run,"a");
        Thread thread2=new Thread(run,"b");
        Thread thread3=new Thread(run,"c");
        thread1.start();
        thread2.start();
        thread3.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"hello");
            }
        }).start();
    }
}
```

* test

```java

package day4;

import java.io.*;

/**
 * IO流
 * https://github.com/DreamYHD/StudyNotes/blob/master/Java/java%20io.md
 */
public class test {
    public static void main(String[] args) {
        String s="F:\\IDEA\\demo";
        File file=new File(s);
//        if(file.exists()){//判断是否存在
//            System.out.println("存在");
//        }
//        if (file.isDirectory()){//是否文件夹
//            System.out.println("isDirectory");
//        }
        if (!file.exists()){
            file.mkdirs();//创建,有没有上级都可以创建，和mkdir区分；创建文件夹
        }

        String path=s+File.separator+"test.txt";//相当于反斜杠
        File file1=new File(path);
        if(!file1.exists()){//判断是否存在
            try {
                file1.createNewFile();//创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        /**
//         * 在文件下创建10个文件
//         */
//        for (int i = 0; i <= 10; i++) {
//            System.out.println("hello");
//            String s1=s+File.separator+"test"+i+".txt";
//            File file2=new File(s1);
//            if(!file2.exists()){//判断是否存在
//                try {
//                    file2.createNewFile();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

//        String[] strings=file.list();//list 方法   **  String[] strings=文件夹名称.list(); **
//        for (String st:
//             strings) {
//            System.out.println(st);
//        }

//        File[] files=file.listFiles();
//        for (int i = 0; i < files.length; i++) {
//            System.out.println(files[i].getName());
//            System.out.println(files[i].getPath());
//        }

//        File[] files1=file.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                if (pathname.toString().endsWith(".txt")){
//                    System.out.println(pathname);
//                }
//                return false;
//            }
//        });

        //输入流是读，输出流是写

        //输出
//        File fileshow =new File("F:\\IDEA\\demo\\test.txt");
//        try {
//            FileOutputStream fileOutputStream=new FileOutputStream(fileshow);
//            String s1="android";
//            fileOutputStream.write(s1.getBytes());
//            fileOutputStream.close();
//        } catch (FileNotFoundException e) {//可以去掉
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /**
         * 字节输出流
         * 循环输入android i；
         */
//        for (int i = 0; i <=10; i++) {
//            String string=s+File.separator+"test"+i+".txt";
//            File filein =new File(string);
//            try {
//                FileOutputStream fileOutputStream=new FileOutputStream(filein,true);//输出模式
//                String s1="android"+i;
//                fileOutputStream.write(s1.getBytes());
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {//可以去掉
//                e.printStackTrace();
//            }
//        }
        /**
         * 字符输出流
         */
//        File fileshow =new File("F:\\IDEA\\demo\\test.txt");
//        try {
//            FileWriter fileWriter=new FileWriter(fileshow,true);
//            fileWriter.write("hello");
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /**
         * 字节输入流
         * FileReader
         * FileInputStream
         */
//        File file2=new File("F:\\IDEA\\demo\\test0.txt");
//        try {
//            FileInputStream fileInputStream=new FileInputStream(file2);
//            byte[] bytes=new byte[(int)file2.length()];
//            //将读取出来的存放到byte里
//            fileInputStream.read(bytes);
//            for (byte aByte : bytes) {
//                System.out.println(aByte);
//            }
//            System.out.println(new String(bytes));//将字节转化成字符串
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            FileReader fileReader=new FileReader("F:\\IDEA\\demo\\test0.txt");
//            char[] chars=new char[1024];
//            fileReader.read(chars);
//            System.out.println(new String (chars));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //文件的复制，图片

    }
}
```

* test2

```Java
package day4;

import java.io.*;

/**
 * 图片的复制
 */
public class test2 {
    public static void main(String[] args) {
        String string="F:\\IDEA\\demo";
        File file=new File(string);
        if (!file.exists()){
            file.mkdirs();
        }
        File file1=new File(string+File.separator+"33F8CBC314D7651F53B97C46EB2DE031.jpg");
        File file2=new File(string+File.separator+"testCopy.jpg");
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(file2);
            FileInputStream fileInputStream = new FileInputStream(file1);
            byte[]bytes=new byte[(int) file1.length()];
            try {
                fileInputStream.read(bytes);
//                for (byte by :
//                        bytes) {
//                    System.out.println(by);
//                }
                fileOutputStream.write(bytes);
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            byte[]bytes=new byte[(int) fileshow.length()];
//            int len=0;
//            int index=0;
//            try {
//                while ((len=fileInputStream.read())!=-1){
//                    fileOutputStream.write(len);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

* thread

```Java
package day4;

public class thread extends Thread{
    private int ticket=3;
    public thread(String name) {
        super(name);
    }
    @Override
    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName()+i);
//        }
        while (ticket>0){
            System.out.println(Thread.currentThread().getName()+" 还剩 "+--ticket+"张");
        }
    }

    public static void main(String[] args) {
        //System.out.println(Thread.currentThread().getName());//输出线程
        new thread("a").start();
        new thread("b").start();
        new thread("c").start();
        new thread("d").start();
        new thread("e").start();
    }
}
```

* thread1

```Java
package day4;

public class thread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+1);
        }
    }
}
```
