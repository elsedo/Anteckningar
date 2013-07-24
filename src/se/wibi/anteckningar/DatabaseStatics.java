package se.wibi.anteckningar;

import android.provider.BaseColumns;

public interface DatabaseStatics extends BaseColumns{
	public final int DATABASE_VERSION = 0;
	public final String DATABASE_NAME = "notes";
	public final String TABLE_NAME = "textNote";
	public final String NOTEBOOK_TEXT = "text";
	public final String NOTEBOOK_IMAGE = "image";
	public final String NOTEBOOK_DATE = "date";
}
