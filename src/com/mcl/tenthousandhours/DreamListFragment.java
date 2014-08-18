package com.mcl.tenthousandhours;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class DreamListFragment extends Fragment {  
	private String [] dreams = new String[]{"Ð´×÷","Á·×Ö","±à³Ì","ÒôÀÖ¼øÉÍ"};
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {  
        return inflateAndSetupView(inflater, container, savedInstanceState, R.layout.dreamlist_fragment);  
    }  
      
    private View inflateAndSetupView(LayoutInflater inflater, ViewGroup container,   
            Bundle savedInstanceState, int layoutResourceId) {  
    	List<Map<String, Object>> listItems = new ArrayList<Map<String,Object>>();
    	for(int i = 0;i< dreams.length;i++)
		{
			Map<String, Object> listItem = new HashMap<String,Object>();
			listItem.put("dream", dreams[i]);
			listItems.add(listItem);
		}
        View dreamView = inflater.inflate(layoutResourceId, container, false);  
        SimpleAdapter simpleAdapter = new SimpleAdapter(dreamView.getContext(), listItems,R.layout.dreamlist_item, new String[]{"dream"}, new int[]{R.id.dream});
		ListView listView = (ListView)dreamView.findViewById(R.id.dreamlist);
		listView.setAdapter(simpleAdapter);
        return dreamView;  
    }   
}  