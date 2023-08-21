package WorkWithJavaFile;


import java.io.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("pom.xml");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = fileInputStream.readAllBytes();
        String s = new String(bytes);
        System.out.println(s);


//        BufferedReader reader = new BufferedReader(new FileReader("pom.xml"));
//        System.out.println(reader.ready());
//        while (reader.ready()){
//            System.out.println(reader.readLine());
//        }


//        Path path = Paths.get("pom.xml");
//
//        List<String> lines = Files.readAllLines(path);
//        System.out.println(lines);

        Student user = new Student();
        user.setName("Josh");
        try (FileOutputStream bos = new FileOutputStream("C:\\Users\\Admin\\IdeaProjects\\untitled\\src\\main\\java\\WorkWithJavaFile\\student.txt");
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(user);
            oos.writeObject(new Date());
        }

//        String str = "Hello";
//        BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
//        writer.write(new Student().toString());
//
//        writer.close();


        FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\untitled\\src\\main\\java\\WorkWithJavaFile\\student.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student student = (Student) ois.readObject();
        Date date = (Date) ois.readObject();
        System.out.println(student);
        System.out.println(date);
    }
}