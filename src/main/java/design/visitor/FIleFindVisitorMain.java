package design.visitor;

import java.util.Iterator;

import design.visitor.common.FileTreatmentException;

/**
 * @author hason
 * @since 2023/6/24 14:29
 */
public class FIleFindVisitorMain {

    public static void main(String[] args) {
        try {
            Directory rootDir = new Directory("root");
            Directory bindDir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrDir = new Directory("usr");
            rootDir.add(bindDir);
            rootDir.add(tmpdir);
            rootDir.add(usrDir);
            rootDir.add(new File("vi", 10000));
            rootDir.add(new File("latex", 20000));

            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("hanako");
            Directory tomura = new Directory("tomura");
            usrDir.add(yuki);
            usrDir.add(hanako);
            usrDir.add(tomura);
            yuki.add(new File("diary.html", 100));
            yuki.add(new File("Composite.java", 200));
            hanako.add(new File("memo.tex", 300));
            hanako.add(new File("index.html", 350));
            tomura.add(new File("game.doc", 400));
            tomura.add(new File("junk.mail", 500));

            FileFindVisitor ffv = new FileFindVisitor(".html");
            rootDir.accept(ffv);

            System.out.println("HTML files are:");
            Iterator<File> it = ffv.getFoundFiles();
            while (it.hasNext()) {
                File file = it.next();
                System.out.println(file.toString());
            }
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }

    }

}