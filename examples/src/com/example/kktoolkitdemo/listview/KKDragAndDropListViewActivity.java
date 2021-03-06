package com.example.kktoolkitdemo.listview;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.example.kktoolkitdemo.R;
import com.kkbox.toolkit.listview.adapter.ReorderListAdapter;
import com.kkbox.toolkit.ui.KKActivity;
import com.kkbox.toolkit.ui.KKDragAndDropListView;

import java.util.ArrayList;
import java.util.List;

public class KKDragAndDropListViewActivity extends KKActivity {
    private KKDragAndDropListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draganddrop);
        mListView = (KKDragAndDropListView) findViewById(R.id.drag_listview);

        ArrayList<String> mStrings = new ArrayList<String>();
        mStrings.add("Item 1");
        mStrings.add("Item 2");
        mStrings.add("Item 3");
        mStrings.add("Item 4");
        mStrings.add("Item 5");
        mStrings.add("Item 6");

        mListView.setAdapter(new DragAdapter(
                this,
                R.layout.layout_list_item,
                R.id.item_text,
                mStrings));
        mListView.setGrabberId(R.id.item_grab);

    }
    private class DragAdapter extends ArrayAdapter implements ReorderListAdapter{
        ArrayList<String> data;
        public DragAdapter(Context context, int resource, int textViewResourceId, ArrayList<String> objects) {
            super(context, resource, textViewResourceId, objects);
            data = objects;
        }

        @Override
        public Object removeAtPosition(int position) {
            String temp = data.remove(position);
            notifyDataSetChanged();
            return temp;
        }

        @Override
        public void addAtPosition(int position, Object object) {
            data.add(position, (String)object);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public String getItem(int position) {
            return data.get(position);
        }

    }
}
