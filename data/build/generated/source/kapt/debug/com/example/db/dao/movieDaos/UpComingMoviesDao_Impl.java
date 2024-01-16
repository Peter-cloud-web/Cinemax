package com.example.db.dao.movieDaos;

import android.database.Cursor;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.CursorUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.cinemaxv3.models.UpComingMovies;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UpComingMoviesDao_Impl implements UpComingMoviesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UpComingMovies> __insertionAdapterOfUpComingMovies;

  private final SharedSQLiteStatement __preparedStmtOfClearAllUpComingMovies;

  public UpComingMoviesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUpComingMovies = new EntityInsertionAdapter<UpComingMovies>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `upcoming_movies` (`backdrop_path`,`overview`,`poster_path`,`id`,`title`,`vote_average`,`page`) VALUES (?,?,?,nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UpComingMovies value) {
        if (value.getBackdrop_path() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBackdrop_path());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOverview());
        }
        if (value.getPoster_path() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPoster_path());
        }
        stmt.bindLong(4, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTitle());
        }
        stmt.bindDouble(6, value.getVote_average());
        if (value.getPage() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getPage());
        }
      }
    };
    this.__preparedStmtOfClearAllUpComingMovies = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete From  upcoming_movies";
        return _query;
      }
    };
  }

  @Override
  public Object insertUpComingMovies(final List<UpComingMovies> upComingMovies,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUpComingMovies.insert(upComingMovies);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearAllUpComingMovies(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearAllUpComingMovies.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfClearAllUpComingMovies.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public PagingSource<Integer, UpComingMovies> getUpComingMovies() {
    final String _sql = "SELECT * FROM upcoming_movies Order By page";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new LimitOffsetPagingSource<UpComingMovies>(_statement, __db, "upcoming_movies") {
      @Override
      protected List<UpComingMovies> convertRows(Cursor cursor) {
        final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(cursor, "backdrop_path");
        final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(cursor, "overview");
        final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(cursor, "poster_path");
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
        final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(cursor, "vote_average");
        final int _cursorIndexOfPage = CursorUtil.getColumnIndexOrThrow(cursor, "page");
        final List<UpComingMovies> _result = new ArrayList<UpComingMovies>(cursor.getCount());
        while(cursor.moveToNext()) {
          final UpComingMovies _item;
          final String _tmpBackdrop_path;
          if (cursor.isNull(_cursorIndexOfBackdropPath)) {
            _tmpBackdrop_path = null;
          } else {
            _tmpBackdrop_path = cursor.getString(_cursorIndexOfBackdropPath);
          }
          final String _tmpOverview;
          if (cursor.isNull(_cursorIndexOfOverview)) {
            _tmpOverview = null;
          } else {
            _tmpOverview = cursor.getString(_cursorIndexOfOverview);
          }
          final String _tmpPoster_path;
          if (cursor.isNull(_cursorIndexOfPosterPath)) {
            _tmpPoster_path = null;
          } else {
            _tmpPoster_path = cursor.getString(_cursorIndexOfPosterPath);
          }
          final int _tmpId;
          _tmpId = cursor.getInt(_cursorIndexOfId);
          final String _tmpTitle;
          if (cursor.isNull(_cursorIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = cursor.getString(_cursorIndexOfTitle);
          }
          final double _tmpVote_average;
          _tmpVote_average = cursor.getDouble(_cursorIndexOfVoteAverage);
          final Integer _tmpPage;
          if (cursor.isNull(_cursorIndexOfPage)) {
            _tmpPage = null;
          } else {
            _tmpPage = cursor.getInt(_cursorIndexOfPage);
          }
          _item = new UpComingMovies(_tmpBackdrop_path,_tmpOverview,_tmpPoster_path,_tmpId,_tmpTitle,_tmpVote_average,_tmpPage);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
