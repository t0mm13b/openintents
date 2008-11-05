package org.openintents.dbbase;

import org.openintents.dbbase.DBBase.Columns;
import org.openintents.dbbase.DBBase.Tables;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class TablesView extends ListActivity {

	private static final String TAG = "TablesView";
	private static final int MENU_ADD_TABLE = Menu.FIRST;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		createList();
	}

	private void createList() {
		Uri uri = Tables.CONTENT_URI;
		Cursor cursor = managedQuery(uri,
				new String[] { Tables._ID, Tables.TABLE_NAME }, null, null, null);
		ListAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_1, cursor,
				new String[] { Tables.TABLE_NAME },
				new int[] { android.R.id.text1 });
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, MENU_ADD_TABLE, 0, R.string.add_table).setIcon(
				android.R.drawable.ic_menu_add);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_ADD_TABLE:
			addTableWithDialog();
			break;
		}
		return true;
	}

	private void addTableWithDialog() {
		LayoutInflater factory = LayoutInflater.from(this);
        final View view = factory.inflate(R.layout.add_table_dialog, null);
        final TextView textView = (TextView) view.findViewById(R.id.text);
        AlertDialog dialog = new AlertDialog.Builder(this)
            .setIcon(android.R.drawable.alert_dark_frame)
            .setTitle(R.string.add_table_dialog_title)
            .setView(view)
            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {

                   addTable(textView.getText().toString());
                }
            })
            .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {

                    /* User clicked cancel so do some stuff */
                }
            })
            .show();
		
	}

	protected void addTable(String tableName) {
		Uri uri = Tables.CONTENT_URI;
		ContentValues values = new ContentValues();
		values.put(Tables.TABLE_NAME, tableName);
		getContentResolver().insert(uri, values);
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, ColumnsView.class);
		intent.setData(Uri.withAppendedPath(Tables.CONTENT_URI, String.valueOf(id)));
		startActivity(intent );
	}
}