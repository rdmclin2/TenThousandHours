package com.mcl.tenthousandhours;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StatisticsFragment extends Fragment {  
	  
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {  
        return inflateAndSetupView(inflater, container, savedInstanceState, R.layout.statistics_fragment);      
    }  
      
    private View inflateAndSetupView(LayoutInflater inflater, ViewGroup container,   
            Bundle savedInstanceState, int layoutResourceId) {  
        View layout = inflater.inflate(layoutResourceId, container, false);  
          
        return layout;  
    }   
}  