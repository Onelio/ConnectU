package com.onelio.connectu.CustomViews;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceViewHolder;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.onelio.connectu.App;
import com.onelio.connectu.R;
import com.squareup.picasso.Picasso;

public class ProfilePreference extends Preference {

  public ProfilePreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  public ProfilePreference(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public ProfilePreference(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public ProfilePreference(Context context) {
    super(context);
  }

  @Override
  public void onBindViewHolder(PreferenceViewHolder holder) {
    super.onBindViewHolder(holder);
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    App app = (App) getContext().getApplicationContext();
    TextView user = (TextView) holder.findViewById(R.id.user_Name);
    ImageView picture = (ImageView) holder.findViewById(R.id.user_Profile);
    String name = app.account.Name;
    if (name == null) {
      name = "User";
    }
    user.setText(name);
    // Bugfix vectors drawable bug <API 19 BY IMPREZA233
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      Picasso.with(getContext())
          .load(app.account.PictureURL)
          .placeholder(R.drawable.ic_placeholder)
          .into(picture);
    } else {
      Picasso.with(getContext())
          .load(app.account.PictureURL)
          .placeholder(R.drawable.logo_launcher)
          .into(picture);
    }
  }
}
