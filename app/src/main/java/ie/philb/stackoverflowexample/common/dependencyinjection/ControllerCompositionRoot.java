package ie.philb.stackoverflowexample.common.dependencyinjection;

import android.app.Activity;
import android.view.LayoutInflater;

import ie.philb.stackoverflowexample.common.MvcViewFactory;
import ie.philb.stackoverflowexample.network.StackOverflowApi;

public class ControllerCompositionRoot {

    private final CompositionRoot compositionRoot;
    private Activity activity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, Activity activity) {
        this.compositionRoot = compositionRoot;
        this.activity = activity;
    }

    public StackOverflowApi getStackOverflowApi() {
        return compositionRoot.getStackOverflowApi();
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(activity);
    }

    public MvcViewFactory getMvcViewFactory() {
        return new MvcViewFactory(getLayoutInflater());
    }
}
