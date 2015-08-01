package com.example.dataparser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.health.data.DataClass;

public class DataParser {

	public static List<DataClass> dataParser(String ip){
		
		try {
			JSONArray jsonArray = new JSONArray(ip);
			List<DataClass> list = new ArrayList<DataClass>();
			DataClass dataClass = new DataClass();
			JSONObject jsonObject;
			for (int i=0;i< jsonArray.length();i++){
				jsonObject=jsonArray.getJSONObject(i);
				dataClass.setTime(jsonObject.getInt("time"));
				dataClass.setValue(jsonObject.getInt("value"));
				list.add(dataClass);
			}
			
			return list;
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
