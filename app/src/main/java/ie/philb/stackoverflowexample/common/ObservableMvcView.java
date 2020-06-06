package ie.philb.stackoverflowexample.common;

public interface ObservableMvcView<ListenerType> extends MvcView {

    void registerListener(ListenerType listener);

    void unRegisterListener(ListenerType listener);
}
