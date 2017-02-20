package com.lyw.exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class InputMethodManagerActivity extends AppCompatActivity {
	private EditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_method_manager);
		editText = (EditText) findViewById(R.id.edit);
	}

	public void onClick(View view) {
		InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		switch (view.getId()) {
			case R.id.hide:
				manager.hideSoftInputFromWindow(editText.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
				break;
			case R.id.show:
				manager.showInputMethodPicker();
				manager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
				break;
			case R.id.toggle:
				manager.toggleSoftInputFromWindow(editText.getWindowToken(), InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_IMPLICIT_ONLY);
				break;
		}
	}
}
