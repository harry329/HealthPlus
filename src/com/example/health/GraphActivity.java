package com.example.health;

import java.lang.reflect.Array;
import java.util.List;

import com.example.health.data.DataClass;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import datatransfer.DataTransfer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.widget.Toast;

public class GraphActivity extends ActionBarActivity {
	List<DataClass> list;
	DataClass dataClass;
	double[] time; 
	double[] value;
	protected void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.graph_layout);
		GraphView graph = (GraphView) findViewById(R.id.graph);
		TextView tv= (TextView) findViewById(R.id.textView2);
		tv.setText(" BP ");
		list= DataTransfer.getList();
	     time= new double[list.size()];
	     value= new double[list.size()];
	     gettingData();
		LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
		        new DataPoint(0, 1),
		          new DataPoint(1, 5),
		          new DataPoint(2, 3),
		          new DataPoint(3, 2),
		          new DataPoint(4, 6)	          
		});
		graph.addSeries(series);
	}
	 
	public void gettingData(){
		for (int i=0; i< list.size();i++){
			dataClass= list.get(i);
			time[i]=(double)dataClass.getTime();
			value[i]=(double)dataClass.getValue();
			
		}
	}

}
