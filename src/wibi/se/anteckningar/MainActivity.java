package wibi.se.anteckningar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.util.HashMap;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TabHost;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

/**
* This demonstrates how you can implement switching between the tabs of a
* TabHost through fragments. It uses a trick (see the code below) to allow
* the tabs to switch between fragments instead of simple views.
*/
public class MainActivity extends SherlockFragmentActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar bar = getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		ActionBar.Tab tab1 = bar.newTab();
		ActionBar.Tab tab2 = bar.newTab();
		tab1.setText("Text");
		tab2.setText("Bild");
		tab1.setTabListener(new MyTabListener());
		tab2.setTabListener(new MyTabListener());
		bar.addTab(tab1);
		bar.addTab(tab2);
	}
	private class MyTabListener implements ActionBar.TabListener{
		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			if(tab.getPosition()==0){
				Anteckningar anteckningar = new Anteckningar();
				ft.replace(android.R.id.content, anteckningar);
			}
			else{
				Anteckningar anteckningar = new Anteckningar();
				ft.replace(android.R.id.content, anteckningar);
			}
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}
	}
}