package design.visitor;

import design.visitor.common.FileTreatmentException;

/**  
 * visitor的这种形消息分发的方式称为"double dispatch(双重分发)"
 * visitor的主要目的是要将数据结构和对数据的处理剥离开来
 * 易于增加ConcreteVisitor,难以增加ConcreteElement
 * @author hason
 * @since 2023/6/23 01:02
 */
public class ListVisitorMain {

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
            rootDir.accept(new ListVisitor());

            System.out.println("");
            System.out.println("Making user entries...");
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
            rootDir.accept(new ListVisitor());
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
