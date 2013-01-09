package com.cmpe451.cmpecommunity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Adapts NewsEntry objects onto views for lists
 */
public final class EventAdapter extends ArrayAdapter<Event> {

	private final int layoutResource;

	public EventAdapter(final Context context, final int layoutResource) {
		super(context, 0);
		this.layoutResource = layoutResource;
	}

	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent) {

		// We need to get the best view (re-used if possible) and then
		// retrieve its corresponding ViewHolder, which optimizes lookup efficiency
		final View view = getWorkingView(convertView);
		final ViewHolder viewHolder = getViewHolder(view);
		final Event event = getItem(position);

		viewHolder.placeText.setText(event.getPlace());		
		viewHolder.nameText.setText(event.getOwnerName());
		viewHolder.dateText.setText(event.getTime()); 
			
		return view;
	}

	private View getWorkingView(final View convertView) {
		// The workingView is basically just the convertView re-used if possible
		// or inflated new if not possible
		View workingView = null;

		if(null == convertView) {
			final Context context = getContext();
			final LayoutInflater inflater = (LayoutInflater)context.getSystemService
					(Context.LAYOUT_INFLATER_SERVICE);

			workingView = inflater.inflate(layoutResource, null);
		} else {
			workingView = convertView;
		}

		return workingView;
	}

	private ViewHolder getViewHolder(final View workingView) {
		// The viewHolder allows us to avoid re-looking up view references
		// Since views are recycled, these references will never change
		final Object tag = workingView.getTag();
		ViewHolder viewHolder = null;


		if(null == tag || !(tag instanceof ViewHolder)) {
			viewHolder = new ViewHolder();

			viewHolder.placeText = (TextView) workingView.findViewById(R.id.place);
			viewHolder.nameText = (TextView) workingView.findViewById(R.id.name);
			viewHolder.dateText = (TextView) workingView.findViewById(R.id.date);
			
			workingView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) tag;
		}

		return viewHolder;
	}

	/**
	 * ViewHolder allows us to avoid re-looking up view references
	 * Since views are recycled, these references will never change
	 */
	private static class ViewHolder {
		public TextView placeText;
		public TextView nameText;
		public TextView dateText;
	}


}