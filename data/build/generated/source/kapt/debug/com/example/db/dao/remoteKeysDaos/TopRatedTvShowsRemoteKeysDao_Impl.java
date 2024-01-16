package com.example.db.dao.remoteKeysDaos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.cinemaxv3.models.TopRatedTvShowsRemoteKeys;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TopRatedTvShowsRemoteKeysDao_Impl implements TopRatedTvShowsRemoteKeysDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TopRatedTvShowsRemoteKeys> __insertionAdapterOfTopRatedTvShowsRemoteKeys;

  private final SharedSQLiteStatement __preparedStmtOfClearTopRatedTvShowsRemoteKeys;

  public TopRatedTvShowsRemoteKeysDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTopRatedTvShowsRemoteKeys = new EntityInsertionAdapter<TopRatedTvShowsRemoteKeys>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `toprated_tvshows_remote_keys` (`movie_id`,`prevKey`,`currentPage`,`nextKey`,`created_at`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TopRatedTvShowsRemoteKeys value) {
        stmt.bindLong(1, value.getMovieID());
        if (value.getPrevKey() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getPrevKey());
        }
        stmt.bindLong(3, value.getCurrentPage());
        if (value.getNextKey() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getNextKey());
        }
        stmt.bindLong(5, value.getCreatedAt());
      }
    };
    this.__preparedStmtOfClearTopRatedTvShowsRemoteKeys = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete From  toprated_tvshows_remote_keys";
        return _query;
      }
    };
  }

  @Override
  public Object insertTopRatedTvShowsRemoteKeys(
      final List<TopRatedTvShowsRemoteKeys> topRatedTvShowsRemoteKeys,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTopRatedTvShowsRemoteKeys.insert(topRatedTvShowsRemoteKeys);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearTopRatedTvShowsRemoteKeys(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearTopRatedTvShowsRemoteKeys.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfClearTopRatedTvShowsRemoteKeys.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getTopRatedTvShowsRemoteKeysById(final int id,
      final Continuation<? super TopRatedTvShowsRemoteKeys> $completion) {
    final String _sql = "SELECT * FROM toprated_tvshows_remote_keys Where movie_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<TopRatedTvShowsRemoteKeys>() {
      @Override
      public TopRatedTvShowsRemoteKeys call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMovieID = CursorUtil.getColumnIndexOrThrow(_cursor, "movie_id");
          final int _cursorIndexOfPrevKey = CursorUtil.getColumnIndexOrThrow(_cursor, "prevKey");
          final int _cursorIndexOfCurrentPage = CursorUtil.getColumnIndexOrThrow(_cursor, "currentPage");
          final int _cursorIndexOfNextKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextKey");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final TopRatedTvShowsRemoteKeys _result;
          if(_cursor.moveToFirst()) {
            final int _tmpMovieID;
            _tmpMovieID = _cursor.getInt(_cursorIndexOfMovieID);
            final Integer _tmpPrevKey;
            if (_cursor.isNull(_cursorIndexOfPrevKey)) {
              _tmpPrevKey = null;
            } else {
              _tmpPrevKey = _cursor.getInt(_cursorIndexOfPrevKey);
            }
            final int _tmpCurrentPage;
            _tmpCurrentPage = _cursor.getInt(_cursorIndexOfCurrentPage);
            final Integer _tmpNextKey;
            if (_cursor.isNull(_cursorIndexOfNextKey)) {
              _tmpNextKey = null;
            } else {
              _tmpNextKey = _cursor.getInt(_cursorIndexOfNextKey);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new TopRatedTvShowsRemoteKeys(_tmpMovieID,_tmpPrevKey,_tmpCurrentPage,_tmpNextKey,_tmpCreatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTopRatedTvShowsRemoteKeysCreaionTime(
      final Continuation<? super Long> $completion) {
    final String _sql = "Select created_at From toprated_tvshows_remote_keys Order By created_at DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if(_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getLong(0);
            }
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
