package ie.philb.stackoverflowexample.common;

import android.content.Context;
import android.view.View;

public abstract class BaseMvcView implements MvcView {

    private View rootView;

    @Override
    public View getRootView() {
        return rootView;
    }

    protected void setRootView(View rootView) {
        this.rootView = rootView;
    }

    protected  <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    protected Context getContext() {
        return getRootView().getContext();
    }
}
