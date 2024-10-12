package design.decorator;

/**  
 * 装饰物
 * @author hason
 * @since 2023/6/16 18:45
 */
public abstract class Border extends Display {

    /**
     * 被装饰物
     */
    protected Display displayImpl;

    public Border(Display displayImpl) {
        this.displayImpl = displayImpl;
    }

}
