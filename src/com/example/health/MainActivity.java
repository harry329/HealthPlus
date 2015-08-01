package com.example.health;

import java.util.List;

import com.example.datafetch.DataFetch;
import com.example.dataparser.DataParser;
import com.example.health.data.DataClass;

import datatransfer.DataTransfer;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	ImageView imageView;
	Button button;
	TextView tv;
	List<DataClass> list;
	String ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.imageView1);
        button= (Button) findViewById(R.id.button1);
        AsynData adata= new AsynData();
        adata.execute();
        tv= (TextView) findViewById(R.id.textView1);
    }
    
    // method to start another activity 
    public void bloodClick(View v){
    	Intent intent = new Intent(this, GraphActivity.class);
    	startActivity(intent);
    	
    }
    
    public void callingFeature(View v){
    	
    		Toast.makeText(this, "You don't have this feature", Toast.LENGTH_LONG).show();
    	
    }
   
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    class AsynData extends AsyncTask<Void,Void,List<DataClass>>{

		@Override
		protected List<DataClass> doInBackground(Void... params) {
			DataFetch df= new DataFetch(getApplicationContext());
			 ip = df.dataFetch();
			list= DataParser.dataParser(ip);
			DataTransfer tf= new DataTransfer(list);
			return list;
			
			
		}
		protected void onPostResult(List<DataClass> result){
			if(result != null){
			list=result;}
			else{
				list.add(new DataClass());
			}
		}
    	
    }
    
    
    
    
    
}
