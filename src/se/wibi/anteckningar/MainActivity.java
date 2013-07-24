package se.wibi.anteckningar;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;


public class MainActivity extends SherlockFragmentActivity {
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
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		   MenuInflater inflater = getSupportMenuInflater();
		   inflater.inflate(R.menu.top_menu, menu);
		   return super.onCreateOptionsMenu(menu);
		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this,"Sparat",Toast.LENGTH_LONG).show(); 
	    
	    return true;
	    
	}
	
	private class MyTabListener implements ActionBar.TabListener{
		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			if(tab.getPosition()==0){
				Anteckningar anteckningar = new Anteckningar();
				ft.replace(android.R.id.content, anteckningar);
			}
			if(tab.getPosition()==1){
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