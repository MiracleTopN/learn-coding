package design.memento;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * Memento模式
 * CareTaker(负责人角色) 负责何时进行拍摄快照，何时撤销以及保存信息
 * @author hason
 * @since 2023/6/29 23:56
 */
public class MementoMain {

    public static final String SAVE_FILE_NAME = "game.dat";

    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        // CareTaker与 Memento是弱关联 只能操纵Memento的部分信息 比如getMoney
        // Memento对于CareTaker是一个黑盒
        Memento memento = gamer.createMemento();
//        Memento memento = loadMemento();
        for (int i = 0; i < 100; i++) {
            System.out.println("====" + i);
            System.out.println("当前状态:" + gamer);
            gamer.bet();
            System.out.println("所持金钱为" + gamer.getMoney() + "元。");
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("所持金钱增加了许多,因此保持游戏当前的状态");
                memento = gamer.createMemento();
//                saveMemento(memento);
            } else if (gamer.getMoney() < memento.getMoney()) {
                System.out.println("所持金钱减少了许多，因此将游戏状态恢复至以前的状态");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveMemento(Memento memento) {
        try {
            // Deflater对输出流的压缩
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new DeflaterOutputStream(new FileOutputStream(SAVE_FILE_NAME)));
            objectOutputStream.writeObject(memento);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Memento loadMemento() {
        Memento memento = null;
        try {
            // Inflater对输入流的压缩
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new InflaterInputStream(new FileInputStream(SAVE_FILE_NAME)));
            memento = (Memento)objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return memento;
    }

}
