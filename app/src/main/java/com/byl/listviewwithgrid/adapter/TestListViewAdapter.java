package com.byl.listviewwithgrid.adapter;

import android.app.Activity;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.byl.listviewwithgrid.R;
import com.byl.listviewwithgrid.bean.TestBean;
import com.byl.listviewwithgrid.util.SysUtils;
import com.byl.listviewwithgrid.view.MyGridView;

import net.tsz.afinal.FinalBitmap;

import java.util.List;

public class TestListViewAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private Activity context;
	private List<TestBean> list;
	private FinalBitmap finalImageLoader ;  
	private TestGridViewAdapter nearByInfoImgsAdapter;
	private int wh;

	public TestListViewAdapter(Activity context, List<TestBean> list) {
		super();
		this.mInflater = LayoutInflater.from(context);
		this.context = context;
		this.wh=(SysUtils.getScreenWidth(context)-SysUtils.Dp2Px(context, 99))/3;
		this.list = list;
		this.finalImageLoader=FinalBitmap.create(context);
		this.finalImageLoader.configLoadingImage(R.drawable.ic_head);
	}

	public List<TestBean> getList() {
		return list;
	}

	public void setList(List<TestBean> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		return list == null ? 0 : list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list == null ? null : list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return list == null ? null : arg0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (list.size() == 0) {
			return null;
		}
		final ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_listview, null);
			holder = new ViewHolder();
			holder.headphoto = (ImageView) convertView.findViewById(R.id.info_iv_header);//头像
			holder.disName = (TextView) convertView.findViewById(R.id.info_tv_name);//昵称
			holder.time = (TextView) convertView.findViewById(R.id.info_tv_time);//时间
			holder.content = (TextView) convertView.findViewById(R.id.info_tv_content);//发布内容
			holder.rl4=(RelativeLayout) convertView.findViewById(R.id.rl4);//图片布局
			holder.gv_images = (MyGridView) convertView.findViewById(R.id.gv_images);//图片
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		final TestBean bean = list.get(position);
		
		String name = null,time = null, content = null,headpath = null;
		int contentimage = 0;
		if (bean != null) {
			name = bean.getUsername();
			time = bean.getTime();
			content = bean.getContent();
			headpath = bean.getHeadphoto();
			contentimage = bean.getImgPath().size();

		}
		//昵称
		if (name!=null&&!name.equals("")) {
			holder.disName.setText(name);
		}
		//是否含有图片
		if (contentimage>0) {
			holder.rl4.setVisibility(View.VISIBLE);
			initInfoImages(holder.gv_images,bean.getImgPath());
		} else {
			holder.rl4.setVisibility(View.GONE);
		}
		//发布时间
		if (time!=null&&!time.equals("")) {
			holder.time.setText(time);
		}
		//内容
		if (content!=null&&!content.equals("")) {
			holder.content.setText(content);
			Linkify.addLinks(holder.content, Linkify.WEB_URLS);
		}
        //头像
		if (headpath!=null&&!headpath.equals("")) {
			finalImageLoader.display(holder.headphoto,headpath);
		} else {
			holder.headphoto.setImageResource(R.drawable.ic_head);
		}
		holder.headphoto.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(context, "点击了头像", Toast.LENGTH_LONG).show();
			}
		});
		return convertView;
	}

	static class ViewHolder {
		ImageView headphoto;
		TextView disName;
		TextView time;
		TextView content;
		MyGridView gv_images;
		RelativeLayout rl4;
	}
	
	/**
	 * 加载信息中包含的图片内容
	 * @param listimg
	 */
	public void initInfoImages(MyGridView gv_images,List<String> listimg){

			int w=0;
			switch (listimg.size()) {
			case 1:
				w=wh;
				gv_images.setNumColumns(1);
				break;
			case 2:
			case 4:
				w=2*wh+SysUtils.Dp2Px(context, 2);
				gv_images.setNumColumns(2);
				break;
			case 3:
			case 5:
			case 6:
				w=wh*3+SysUtils.Dp2Px(context, 2)*2;
				gv_images.setNumColumns(3);
				break;
			}
			RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(w, RelativeLayout.LayoutParams.WRAP_CONTENT);
			gv_images.setLayoutParams(lp);
			nearByInfoImgsAdapter=new TestGridViewAdapter(context, listimg);
			gv_images.setAdapter(nearByInfoImgsAdapter);
			gv_images.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
					Toast.makeText(context, "点击了第"+(arg2+1)+"张图片", Toast.LENGTH_LONG).show();
				}
			});
		}

	}

