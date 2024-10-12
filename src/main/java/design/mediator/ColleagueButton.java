package design.mediator;

import java.awt.*;

/**
 * ConcreteColleague角色
 * @author hason
 * @since 2023/6/27 22:02
 */
public class ColleagueButton extends Button implements Colleague {

    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueChangedEnabled(boolean enabled) {
        setEnabled(enabled);
    }
}
