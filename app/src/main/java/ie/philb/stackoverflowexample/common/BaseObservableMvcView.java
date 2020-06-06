package ie.philb.stackoverflowexample.common;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ie.philb.stackoverflowexample.screens.QuestionsListMvcView;

public abstract class BaseObservableMvcView<ListenerType> extends BaseMvcView implements ObservableMvcView<ListenerType> {

    private Set<ListenerType> listeners = new HashSet<>();

    public void registerListener(ListenerType listener) {
        listeners.add(listener);
    }

    public void unRegisterListener(ListenerType listener) {
        listeners.remove(listener);
    }

    protected Set<ListenerType> getListeners() {
        return Collections.unmodifiableSet(listeners);
    }
}
