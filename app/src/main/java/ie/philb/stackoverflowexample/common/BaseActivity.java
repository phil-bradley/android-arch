package ie.philb.stackoverflowexample.common;

import androidx.appcompat.app.AppCompatActivity;

import ie.philb.stackoverflowexample.CustomApplication;
import ie.philb.stackoverflowexample.common.dependencyinjection.CompositionRoot;
import ie.philb.stackoverflowexample.common.dependencyinjection.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot compositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {

        if (compositionRoot == null) {
            this.compositionRoot = new ControllerCompositionRoot(getAppCompositionRoot(),this);
        }

        return compositionRoot;
    }

    private CompositionRoot getAppCompositionRoot() {
        return getCustomApplication().getCompositionRoot();
    }

    private CustomApplication getCustomApplication() {
        return (CustomApplication)getApplication();
    }
}
