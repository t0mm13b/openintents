/* 
 * Copyright (C) 2011 OpenIntents.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openintents.historify.ui.views.popup;

import org.openintents.historify.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public abstract class AbstractPopupWindow extends PopupWindow {

	protected Context mContext;
	private View mArrow;
	
	public AbstractPopupWindow(Context context) {
		super(context);
		mContext = context;
	
		
		ViewGroup contentView = (ViewGroup) ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.popupwindow, null);
		mArrow = contentView.findViewById(R.id.popupwindow_arrow);
		
		addContent((ViewGroup) contentView.findViewById(R.id.popupwindow_root));
		setContentView(contentView);
				
		setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
		setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
		setFocusable(true);
		setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.transparent_popup_background));
		//setBackgroundDrawable(null);
	}
	
	public void show(View anchor) {
		super.showAsDropDown(anchor);
	}
	
	public void setArrowGravity(int gravity) {
//		LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//		layoutParams.gravity = gravity;
//		mArrow.setLayoutParams(layoutParams);
		((LinearLayout.LayoutParams)mArrow.getLayoutParams()).gravity = gravity;		
	}
	
	protected void setArrowVisibility(int visibility) {
		mArrow.setVisibility(visibility);
	}
	
	protected abstract void addContent(ViewGroup contentRoot);
}
