package com.example.moxtrasample;

import com.moxtra.binder.util.ToastMessageUtil;
import com.moxtra.sdk.MXAccountManager;
import com.moxtra.sdk.MXConversationManager;
import com.moxtra.sdk.MXException;
import com.moxtra.sdk.MXAccountManager.MXAccount;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class CopyOfMainActivity extends ActionBarActivity {
	
	
	public String email="";//gnanaoly@gmail.com
	public String appClientId="oy5s2-ISzkU";
	public String appClientSecret="niVBB59vQgU";
	public String authCallbackUrl;
	public MXAccount inAcct;
	
	MXAccountManager mAcctMgr = null;
	public MXConversationManager mConvsMgr;
	
	Context mContext;
	private String mcid="";

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		
		
		
		
try {
			
			MXAccountManager.MXAccount inAcct=new MXAccount(email);
			
			if(mAcctMgr==null){
				
				mAcctMgr=MXAccountManager.getInstance(getApplicationContext(),appClientId,appClientSecret,authCallbackUrl,inAcct);	
				mAcctMgr.setInputAccount(inAcct);
				
			}	
		
			
			
			
			
		}catch(MXException.InvalidParameter invalidParameter)	
		{
			
			 invalidParameter.printStackTrace();	
		 
		}	
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		if(mAcctMgr != null && mConvsMgr == null){
			
			
				mConvsMgr=MXConversationManager.getInstance();
		}
		
				 
		
		if(mAcctMgr!=null&&mAcctMgr.isLinked()){

			
			 mAcctMgr.unlinkAccount(new MXAccountManager.MXAccountUnlinkListener()
			 { @Override public void onUnlinkedAccount(
		
					MXAccountManager.MXAccount acct){ToastMessageUtil.showToastMessage(mContext,"Account("+acct.userIdentity+")is  unlinked!");
					}
			
			 });	
			}
		
		
		mConvsMgr.startConversation(mcid);
		
	
		
	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			
			MXApplication gv = (MXApplication)getApplication();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
