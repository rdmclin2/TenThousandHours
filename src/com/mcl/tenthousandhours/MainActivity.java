package com.mcl.tenthousandhours;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;


public class MainActivity extends FragmentActivity   
implements ActionBar.TabListener{  

private DreamListFragment dreamListFragment = new DreamListFragment();  
private StatisticsFragment statisticsFragment = new StatisticsFragment();  
private ShareFragment shareFragment = new ShareFragment();  

private static final int TAB_INDEX_COUNT = 3;  

private static final int TAB_INDEX_ONE = 0;  
private static final int TAB_INDEX_TWO = 1;  
private static final int TAB_INDEX_THREE = 2;  

private ViewPager mViewPager;  
private ViewPagerAdapter mViewPagerAdapter;  

/** Called when the activity is first created. */  
@Override  
public void onCreate(Bundle savedInstanceState) {  
super.onCreate(savedInstanceState);  
setContentView(R.layout.activity_main);  

setUpActionBar();  
setUpViewPager();  
setUpTabs();  
}  

@SuppressLint("NewApi")
private void setUpActionBar() {  
final ActionBar actionBar = getActionBar();  
actionBar.setHomeButtonEnabled(false);  
actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);  
actionBar.setDisplayShowTitleEnabled(false);  
actionBar.setDisplayShowHomeEnabled(false);  
}  

private void setUpViewPager() {  
mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());  

mViewPager = (ViewPager)findViewById(R.id.pager);  
mViewPager.setAdapter(mViewPagerAdapter);  
mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {  
@Override  
public void onPageSelected(int position) {  
final ActionBar actionBar = getActionBar();  
actionBar.setSelectedNavigationItem(position);  
}  

@Override  
public void onPageScrollStateChanged(int state) {  
switch(state) {  
    case ViewPager.SCROLL_STATE_IDLE:  
        //TODO  
        break;  
    case ViewPager.SCROLL_STATE_DRAGGING:  
        //TODO  
        break;  
    case ViewPager.SCROLL_STATE_SETTLING:  
        //TODO  
        break;  
    default:  
        //TODO  
        break;  
}  
}  
});  
}  

private void setUpTabs() {  
final ActionBar actionBar = getActionBar();  
for (int i = 0; i < mViewPagerAdapter.getCount(); ++i) {  
actionBar.addTab(actionBar.newTab()  
    .setText(mViewPagerAdapter.getPageTitle(i))  
    .setTabListener(this));  
}  
}  

@Override  
protected void onDestroy() {  
super.onDestroy();  
}  

public class ViewPagerAdapter extends FragmentPagerAdapter {  

public ViewPagerAdapter(FragmentManager fm) {  
super(fm);  
// TODO Auto-generated constructor stub  
}  

@Override  
public Fragment getItem(int position) {  
// TODO Auto-generated method stub  
switch (position) {  
case TAB_INDEX_ONE:  
    return dreamListFragment;  
case TAB_INDEX_TWO:  
    return statisticsFragment;  
case TAB_INDEX_THREE:  
    return shareFragment;  
}  
throw new IllegalStateException("No fragment at position " + position);  
}  

@Override  
public int getCount() {  
// TODO Auto-generated method stub  
return TAB_INDEX_COUNT;  
}  

@Override  
public CharSequence getPageTitle(int position) {  
String tabLabel = null;  
switch (position) {  
case TAB_INDEX_ONE:  
    tabLabel = getString(R.string.dreamlist_fragment_tab);  
    break;  
case TAB_INDEX_TWO:  
    tabLabel = getString(R.string.statics_fragment_tab);  
    break;  
case TAB_INDEX_THREE:  
    tabLabel = getString(R.string.share_fragment_tab);  
    break;  
}  
return tabLabel;  
}  
}  

public void onTabReselected(Tab tab, FragmentTransaction ft) {  
// TODO Auto-generated method stub  

}  

public void onTabSelected(Tab tab, FragmentTransaction ft) {  
	mViewPager.setCurrentItem(tab.getPosition());  
}  

public void onTabUnselected(Tab tab, FragmentTransaction ft) {  
// TODO Auto-generated method stub  

}
}  