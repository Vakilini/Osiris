// Generated by view binder compiler. Do not edit!
package com.example.osiris_test2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.osiris_test2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemConteinerSentTestBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText editText;

  @NonNull
  public final TextView question;

  @NonNull
  public final TextView questionDesription;

  private ItemConteinerSentTestBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText editText, @NonNull TextView question,
      @NonNull TextView questionDesription) {
    this.rootView = rootView;
    this.editText = editText;
    this.question = question;
    this.questionDesription = questionDesription;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemConteinerSentTestBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemConteinerSentTestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_conteiner_sent_test, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemConteinerSentTestBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.editText;
      EditText editText = ViewBindings.findChildViewById(rootView, id);
      if (editText == null) {
        break missingId;
      }

      id = R.id.question;
      TextView question = ViewBindings.findChildViewById(rootView, id);
      if (question == null) {
        break missingId;
      }

      id = R.id.questionDesription;
      TextView questionDesription = ViewBindings.findChildViewById(rootView, id);
      if (questionDesription == null) {
        break missingId;
      }

      return new ItemConteinerSentTestBinding((ConstraintLayout) rootView, editText, question,
          questionDesription);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
