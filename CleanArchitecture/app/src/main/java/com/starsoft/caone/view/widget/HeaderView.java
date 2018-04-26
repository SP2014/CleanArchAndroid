package com.starsoft.caone.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.starsoft.caone.R;

public class HeaderView extends LinearLayout {
  @BindView(R.id.txt_header_title)
  TextView titleLabel;
  @BindView(R.id.txt_header_subtitle) TextView subTitleLabel;

  public HeaderView(Context context) {
    super(context);
  }

  public HeaderView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public HeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    View view = LayoutInflater.from(getContext()).inflate(R.layout.header_detail, this, true);
    ButterKnife.bind(view);
  }

  public void initializeHeader(String disclaimer, String nickName) {
    titleLabel.setText(disclaimer);
    subTitleLabel.setText(nickName);
  }
}
