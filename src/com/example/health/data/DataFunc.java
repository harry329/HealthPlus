package com.example.health.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class DataFunc {
   public DataFunc(){
	   //
   }
   public List<String> listOfWords(String content, int num){
	  List<String> list= Arrays.asList(content.split("\\s*(.|,|\\s|(|)|-|!|@|#|$|%|^|&|*|_|+|=|\t|\n)\\s*"));
	  HashMap <String,Integer> map= new HashMap<String, Integer>();
	  for(int i=0;i< list.size();i++){
		   Integer n = map.get(list.get(i));
	        n = (n == null) ? 1 : ++n;
	        map.put(list.get(i), n);
	   }
	  Map<Integer, String> treeMap = new TreeMap<Integer, String>(
				new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
	  });
	  for(Map.Entry<String,Integer> entry : map.entrySet()){
	        treeMap.put(entry.getValue(), entry.getKey());
	    }
	  List<String> freqlist = new ArrayList<String>(treeMap.values());
	   return freqlist.subList(0, num-1);
	   
   }
}
