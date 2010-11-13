package org.openintents.calendarpicker.demo.provider;

import org.openintents.calendarpicker.contract.IntentConstants;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class EventContentProvider extends ContentProvider {
	
	static final String TAG = "EventContentProvider";
	
	// This must be the same as what as specified as the Content Provider authority
	// in the manifest file.
	public static final String AUTHORITY = "org.openintents.calendarpicker.demo.provider.events";
	
	
	static Uri BASE_URI = new Uri.Builder().scheme(ContentResolver.SCHEME_CONTENT).authority(AUTHORITY).path("events").build();


	// the appended ID is actually not used in this demo.
   public static Uri constructUri(long data_id) {
       return ContentUris.withAppendedId(BASE_URI, data_id);
   }
   
   @Override
   public boolean onCreate() {
       return true;
   }

   @Override
   public String getType(Uri uri) {
	   return IntentConstants.CalendarEventPicker.CONTENT_TYPE_CALENDAR_EVENT;
   }

   @Override
   public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

	   long calendar_id = ContentUris.parseId(uri);
	   
	   SampleEventDatabase database = new SampleEventDatabase(getContext());
	   SQLiteDatabase db = database.getReadableDatabase();
	   
	   SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
	   builder.setTables(SampleEventDatabase.TABLE_EVENTS);
	   builder.appendWhere(SampleEventDatabase.KEY_CALENDAR_ID + "=" + calendar_id);
	   return builder.query(db, projection, selection, selectionArgs, null, null, sortOrder);
   }

   @Override
   public int delete(Uri uri, String s, String[] as) {
       throw new UnsupportedOperationException("Not supported by this provider");
   }

   @Override
   public Uri insert(Uri uri, ContentValues contentvalues) {
       throw new UnsupportedOperationException("Not supported by this provider");
   }
   
   @Override
   public int update(Uri uri, ContentValues contentvalues, String s, String[] as) {
       throw new UnsupportedOperationException("Not supported by this provider");
   }
}
