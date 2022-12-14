// Generated by view binder compiler. Do not edit!
package com.example.osiris_test2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.osiris_test2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentGalleryBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button button;

  @NonNull
  public final EditText inputEmail;

  @NonNull
  public final EditText inputName;

  @NonNull
  public final FrameLayout layou;

  @NonNull
  public final FrameLayout layoutImage;

  @NonNull
  public final LinearLayout linear;

  @NonNull
  public final ScrollView scr;

  private FragmentGalleryBinding(@NonNull RelativeLayout rootView, @NonNull Button button,
      @NonNull EditText inputEmail, @NonNull EditText inputName, @NonNull FrameLayout layou,
      @NonNull FrameLayout layoutImage, @NonNull LinearLayout linear, @NonNull ScrollView scr) {
    this.rootView = rootView;
    this.button = button;
    this.inputEmail = inputEmail;
    this.inputName = inputName;
    this.layou = layou;
    this.layoutImage = layoutImage;
    this.linear = linear;
    this.scr = scr;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentGalleryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentGalleryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_gallery, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentGalleryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button;
      Button button = ViewBindings.findChildViewById(rootView, id);
      if (button == null) {
        break missingId;
      }

      id = R.id.inputEmail;
      EditText inputEmail = ViewBindings.findChildViewById(rootView, id);
      if (inputEmail == null) {
        break missingId;
      }

      id = R.id.inputName;
      EditText inputName = ViewBindings.findChildViewById(rootView, id);
      if (inputName == null) {
        break missingId;
      }

      id = R.id.layou;
      FrameLayout layou = ViewBindings.findChildViewById(rootView, id);
      if (layou == null) {
        break missingId;
      }

      id = R.id.layoutImage;
      FrameLayout layoutImage = ViewBindings.findChildViewById(rootView, id);
      if (layoutImage == null) {
        break missingId;
      }

      id = R.id.linear;
      LinearLayout linear = ViewBindings.findChildViewById(rootView, id);
      if (linear == null) {
        break missingId;
      }

      id = R.id.scr;
      ScrollView scr = ViewBindings.findChildViewById(rootView, id);
      if (scr == null) {
        break missingId;
      }

      return new FragmentGalleryBinding((RelativeLayout) rootView, button, inputEmail, inputName,
          layou, layoutImage, linear, scr);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
