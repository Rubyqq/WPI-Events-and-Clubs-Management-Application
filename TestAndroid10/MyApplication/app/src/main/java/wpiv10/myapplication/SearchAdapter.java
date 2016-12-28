package wpiv10.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Tan on 3/14/2016.
 */

public class SearchAdapter extends CursorAdapter {
    TextView txtId,txtName,txtEmail;
    private LayoutInflater mInflater;

    public SearchAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View   view    =    mInflater.inflate(R.layout.event_searchrin, parent, false);
        ViewHolder holder  =   new ViewHolder();
        holder.txtName    =   (TextView)  view.findViewById(R.id.EventName);
        view.setTag(holder);
        return view;
    }

    @Override
    /*public void bindView(View view, Context context, Cursor cursor) {

    }*/

    //@Override
    public void bindView(View view, Context context, Cursor cursor) {
        //If you want to have zebra lines color effect uncomment below code
        /*if(cursor.getPosition()%2==1) {
             view.setBackgroundResource(R.drawable.item_list_backgroundcolor);
        } else {
            view.setBackgroundResource(R.drawable.item_list_backgroundcolor2);
        }*/

        ViewHolder holder  =   (ViewHolder)    view.getTag();
        holder.txtName.setText(cursor.getString(cursor.getColumnIndex("event_name")));

    }

    static class ViewHolder {
        TextView txtName;

    }
}