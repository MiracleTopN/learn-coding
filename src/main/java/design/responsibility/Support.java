package design.responsibility;

/**
 * @author hason
 * @since 2023/6/26 00:20
 */
public abstract class Support {

    private String name;

    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    // 核心方法
    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    // 非递归的support
    public final void supportNoRecursion(Trouble trouble) {
        Support curr = this;
        boolean resolved;
        do {
            resolved = curr.resolve(trouble);
            if (resolved) {
                curr.done(trouble);
                break;
            }
            curr = curr.next;
        } while (curr != null);
        if (!resolved) {
            fail(trouble);
        }
    }

    // 非递归的support
    public final void supportNoRecursion1(Trouble trouble) {
        for (Support curr = this; true; curr = curr.next) {
            if (curr.resolve(trouble)) {
                curr.done(trouble);
                break;
            } else if (curr.next == null) {
                curr.fail(trouble);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + " .");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved");
    }

}
