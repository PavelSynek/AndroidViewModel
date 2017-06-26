package eu.inloop.viewmodel.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import eu.inloop.viewmodel.AbstractViewModel;
import eu.inloop.viewmodel.IView;

public abstract class ViewModelBaseBindingActivity<T extends IView, R extends AbstractViewModel<T>> extends ViewModelBaseActivity<T, R> implements IView {

	@CallSuper
	@Override
	protected void onCreate(@Nullable final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getViewModelHelper().performBinding(this);
	}
}
