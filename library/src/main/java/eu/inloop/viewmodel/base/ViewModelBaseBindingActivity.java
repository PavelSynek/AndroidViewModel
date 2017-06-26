package eu.inloop.viewmodel.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import eu.inloop.viewmodel.AbstractViewModel;
import eu.inloop.viewmodel.IView;

public abstract class ViewModelBaseBindingActivity<T extends IView, R extends AbstractViewModel<T>, B extends ViewDataBinding>
		extends ViewModelBaseActivity<T, R>
		implements IView {

	@CallSuper
	@Override
	protected void onCreate(@Nullable final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getViewModelHelper().performBinding(this);
	}

	@SuppressWarnings("unused")
	@NonNull
	public B getBinding() {
		try {
			return (B) getViewModelHelper().getBinding();
		} catch (ClassCastException ex) {
			throw new IllegalStateException("Method getViewModelBindingConfig() has to return same " +
					"ViewDataBinding type as it is set to base Fragment");
		}
	}
}
