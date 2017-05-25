package com.ly.selector.customview;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ly.selector.R;
import com.ly.selector.bean.Bucket;
import com.ly.selector.util.ImageLoadUtil;


/**
 * 相册列表
 * @author Qiao
 * 2015-3-18
 */
public class BucketView extends FrameLayout {

	private ImageView imageView;
	private TextView nameTextView, countTextView;
	private Bucket bucket;
	
	public BucketView(Context context) {
		super(context);
		initialize();
	}

	public BucketView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize();
	}

	private void initialize() {
		LayoutInflater.from(getContext()).inflate(R.layout.bucket_item, this);
		imageView = (ImageView) findViewById(R.id.iv_album_la);
		nameTextView = (TextView) findViewById(R.id.tv_name_la);
		countTextView = (TextView) findViewById(R.id.tv_count_la);
	}

	public void setView(Bucket bucket){
		this.bucket = bucket;
		ImageLoadUtil.getInstance(3,ImageLoadUtil.Type.LIFO).loadImage(bucket.bucketUrl, imageView);
		nameTextView.setText(bucket.bucketName);
		countTextView.setText(""+bucket.count);
	}
	
	public Bucket getBucket(){
		return bucket;
	}
}
