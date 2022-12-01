// Generated by view binder compiler. Do not edit!
package com.example.osiris_test2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.osiris_test2.R;
import com.google.android.material.navigation.NavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMain2Binding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final AppBarMain2Binding appBarMain2;

  @NonNull
  public final DrawerLayout drawerLayout;

  @NonNull
  public final NavigationView navView;

  private ActivityMain2Binding(@NonNull DrawerLayout rootView,
      @NonNull AppBarMain2Binding appBarMain2, @NonNull DrawerLayout drawerLayout,
      @NonNull NavigationView navView) {
    this.rootView = rootView;
    this.appBarMain2 = appBarMain2;
    this.drawerLayout = drawerLayout;
    this.navView = navView;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMain2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_bar_main2;
      View appBarMain2 = ViewBindings.findChildViewById(rootView, id);
      if (appBarMain2 == null) {
        break missingId;
      }
      AppBarMain2Binding binding_appBarMain2 = AppBarMain2Binding.bind(appBarMain2);

      DrawerLayout drawerLayout = (DrawerLayout) rootView;

      id = R.id.nav_view;
      NavigationView navView = ViewBindings.findChildViewById(rootView, id);
      if (navView == null) {
        break missingId;
      }

      return new ActivityMain2Binding((DrawerLayout) rootView, binding_appBarMain2, drawerLayout,
          navView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
