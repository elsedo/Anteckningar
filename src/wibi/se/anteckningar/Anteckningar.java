package wibi.se.anteckningar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

public class Anteckningar extends SherlockFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle saved){
		return inflater.inflate(R.layout.fragment_anteckningar, group, false);
	}
}
