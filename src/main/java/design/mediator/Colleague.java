package design.mediator;

/**
 * Colleague角色
 * @author hason
 * @since 2023/6/27 22:03
 */
public interface Colleague {

    void setMediator(Mediator mediator);

    void setColleagueChangedEnabled(boolean enabled);

}
