package se.emilsjolander.flipview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class FlipAdapter extends BaseAdapter implements OnClickListener {
	
	public interface Callback{
		public void onPageRequested(int page);
	}
	
	static class Item {
		static long id = 0;
		
		long mId;
		
		public Item() {
			mId = id++;
		}
		
		long getId(){
			return mId;
		}
	}
	
	private LayoutInflater inflater;
	private Callback callback;
	private List<Item> items = new ArrayList<Item>();
	
	public FlipAdapter(Context context) {
		inflater = LayoutInflater.from(context);
		for(int i = 0 ; i<10 ; i++){
			items.add(new Item());
		}
	}

	public void setCallback(Callback callback) {
		this.callback = callback;
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return items.get(position).getId();
	}
	
	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null){

			if (position % 2 == 0) {
				convertView = inflater.inflate(R.layout.page0, parent, false);
			} else {
				convertView = inflater.inflate(R.layout.page1, parent, false);
			}

		}else{

		}

		
		return convertView;
	}

	@Override
	public void onClick(View v) {
	}

	public void addItems(int amount) {
		for(int i = 0 ; i<amount ; i++){
			items.add(new Item());
		}
		notifyDataSetChanged();
	}

	public void addItemsBefore(int amount) {
		for(int i = 0 ; i<amount ; i++){
			items.add(0, new Item());
		}
		notifyDataSetChanged();
	}

}
