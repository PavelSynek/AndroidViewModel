package eu.inloop.viewmodel.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import eu.inloop.viewmodel.AbstractViewModel;
import eu.inloop.viewmodel.IView;
import eu.inloop.viewmodel.IViewModelFactory;
import eu.inloop.viewmodel.ViewModelHelper;
import eu.inloop.viewmodel.binding.ViewModelBindingConfig;

public abstract class ViewModelBaseActivity<T extends IView, R extends AbstractViewModel<T>> extends ViewModelBaseEmptyActivity implements IView  {

    @NonNull
    private final ViewModelHelper<T, R> mViewModelHelper = new ViewModelHelper<>();

    @CallSuper
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModelHelper.onCreate(this, savedInstanceState, getViewModelFactory(), getIntent().getExtras());
    }

    /**
     * Call this after your view is ready - usually on the end of {@link android.app.Activity#onCreate(Bundle)}
     * @param view view
     */
    @SuppressWarnings("unused")
    public void setModelView(@NonNull final T view) {
        mViewModelHelper.setView(view);
    }

    @Nullable
    public IViewModelFactory<T> getViewModelFactory() {
        return null;
    }

    @CallSuper
    @Override
    public void onSaveInstanceState(@NonNull final Bundle outState) {
        super.onSaveInstanceState(outState);
        mViewModelHelper.onSaveInstanceState(outState);
    }

    @CallSuper
    @Override
    public void onStart() {
        super.onStart();
        mViewModelHelper.onStart();
    }

    @CallSuper
    @Override
    public void onStop() {
        super.onStop();
        mViewModelHelper.onStop();
    }

    @CallSuper
    @Override
    public void onDestroy() {
        mViewModelHelper.onDestroy(this);
        super.onDestroy();
    }

    /**
     * @see ViewModelHelper#getViewModel()
     */
    @SuppressWarnings("unused")
    @NonNull
    public R getViewModel() {
        return mViewModelHelper.getViewModel();
    }

    @Override
    public void removeViewModel() {
        mViewModelHelper.removeViewModel(this);
    }

    @Nullable
    @Override
    public ViewModelBindingConfig getViewModelBindingConfig() {
        return null;
    }

	@NonNull
	protected ViewModelHelper<T, R> getViewModelHelper() {
		return mViewModelHelper;
	}
}
