package com.example.moxtrasample;

import com.moxtra.binder.util.ToastMessageUtil;
import com.moxtra.sdk.MXAccountManager;
import com.moxtra.sdk.MXAccountManager.MXAccount;
import com.moxtra.sdk.MXConversationManager;
import com.moxtra.sdk.MXException;

import android.app.Application;
import android.content.Context;

class MXApplication extends Application {

	public String email="gnanaoly@gmail.com";
	public String appClientId="oy5s2-ISzkU";
	public String appClientSecret="niVBB59vQgU";
	public String authCallbackUrl;
	public MXAccount inAcct;
	
	MXAccountManager mAcctMgr = null;
	public MXConversationManager mConvsMgr;
	
	Context mContext;

	@Override
	public void onCreate() {
		
		super.onCreate();
		
		mContext=this;
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
		
		
		/*
		try	
		  {	 //Check email is empty	or not	
			
			
			
		  
		MXAccountManager.MXAccount	 inAcct	 =	new	 MXAccountManager.MXAccount(email);	
		  
		  MXAccountManager mAcctMgr;
		 
		
		  catch(MXException.InvalidParameter invalidParameter)	
		  {	
			 invalidParameter.printStackTrace();	
		  	
		  	
		  }	*/
		
	}
	
	
	public MXAccountManager getAcctMgr(){	
	 
	return mAcctMgr;	
	 }	
	
	 
	
}
