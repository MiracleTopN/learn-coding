package design.composite;

/**
 * @author hason
 * @since 2023/6/13 15:17
 */
public class CompositeMain {

    public static void main(String[] args) {
        try {
            System.out.println("Making root entries...");
            Directory rootDir = new Directory("root");
            Directory bindDir = new Directory("bin");
            Directory tmpDir = new Directory("tmp");
            Directory usrDir = new Directory("usr");
            rootDir.add(bindDir);
            rootDir.add(tmpDir);
            rootDir.add(usrDir);
            bindDir.add(new File("vi", 10000));
            bindDir.add(new File("latex", 20000));
            rootDir.printList("");

            System.out.println("");
            System.out.println("Making user entries");
            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("hanako");
            Directory tomura = new Directory("tomura");
            usrDir.add(yuki);
            usrDir.add(hanako);
            usrDir.add(tomura);
            yuki.add(new File("diary.html", 100));
            yuki.add(new File("Composite.java", 200));
            hanako.add(new File("memo.tex", 300));
            tomura.add(new File("game.doc", 400));
            tomura.add(new File("junk.mail", 500));
            Directory myDirectory = new Directory("myDirectory");
            File myFile = new File("hello.html", 123);
            myDirectory.add(myFile);
            System.out.println(myFile.getFullName());
            rootDir.printList("");
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }

}
