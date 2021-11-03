package DB;

import android.provider.BaseColumns;

public class SongsContract {
    private SongsContract(){}
    public static class SongsEntry implements BaseColumns {
        public static final String TABLE_NAME ="songs";
        public static final String ID = "id";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_AUTOR = "autor";
        public static final String COLUMN_NAME_DURATION = "duration";
    }

}
