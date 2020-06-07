package ie.philb.stackoverflowexample;

import android.app.Application;

import ie.philb.stackoverflowexample.common.dependencyinjection.CompositionRoot;

public class CustomApplication extends Application {

    private CompositionRoot compositionRoot;

    public void onCreate() {
        super.onCreate();
        this.compositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return compositionRoot;
    }
}
