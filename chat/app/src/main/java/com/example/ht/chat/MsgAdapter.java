package com.example.ht.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


/**
 * Created by HT on 2016/10/6.
 */

public class MsgAdapter extends ArrayAdapter<Msg> {
    private int resourceId;

    public MsgAdapter(Context context, int textViewResourceId, List<Msg> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Msg msg = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
            viewHolder.rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
            viewHolder.leftMsg = (TextView) view.findViewById(R.id.left_msg);
            viewHolder.rightMsg = (TextView) view.findViewById(R.id.right_msg);
            viewHolder.left_head=(ImageView)view.findViewById(R.id.left_head) ;
            viewHolder.right_head=(ImageView)view.findViewById(R.id.right_head) ;
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (msg.getType() == Msg.TYPE_RECEIVED) {
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftMsg.setText(msg.getContent());
            viewHolder.left_head.setVisibility(View.VISIBLE);
            viewHolder.right_head.setVisibility(View.GONE);
        } else if (msg.getType() == Msg.TYPE_SEND) {
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightMsg.setText(msg.getContent());
            viewHolder.left_head.setVisibility(View.GONE);
            viewHolder.right_head.setVisibility(View.VISIBLE);
        }
        return view;
    }

    class ViewHolder {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        ImageView left_head;
        ImageView right_head;
    }
}

/*前面我一直在纠结Adapter和viewholder和getview函数之间色复杂关系，现在有了较为清晰的认识，Apda
* Adapter 其实就是一个桥梁在控件和数据搭起来的，只不过我们要根据自己的需求来重写Adapter
 *在微信中我们会打字，然后数据在listview中显示出来，但是移动端内存资源很宝贵，就算很富足我们也要靠靠用户的需求
 * 所以我们用Recycler，就是当有控件移除屏幕时候，我们应该回收利用，第一步就是对convertview判断是不是空值，如果是那就用viewholder进行控件的实例缓存，如果不是，那就进行重利用*/
