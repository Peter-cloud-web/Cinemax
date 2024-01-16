package com.example.db.dao.movieDaos;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.domain.entities.model.favourites.FavouriteMovies;
import java.lang.Class;
import java.lang.Exception;
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
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FavouriteMoviesDao_Impl implements FavouriteMoviesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FavouriteMovies> __insertionAdapterOfFavouriteMovies;

  private final SharedSQLiteStatement __preparedStmtOfDeleteFavouriteMovie;

  public FavouriteMoviesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavouriteMovies = new EntityInsertionAdapter<FavouriteMovies>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `favourite_movies` (`backdrop_path`,`overview`,`poster_path`,`id`,`title`,`vote_average`) VALUES (?,?,?,nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavouriteMovies value) {
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
      }
    };
    this.__preparedStmtOfDeleteFavouriteMovie = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM favourite_movies WHERE  id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertFavouriteMovies(final FavouriteMovies movie,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFavouriteMovies.insert(movie);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteFavouriteMovie(final int id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteFavouriteMovie.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteFavouriteMovie.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<FavouriteMovies>> getAllFavouriteMovies() {
    final String _sql = "SELECT * FROM favourite_movies";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"favourite_movies"}, new Callable<List<FavouriteMovies>>() {
      @Override
      public List<FavouriteMovies> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(_cursor, "backdrop_path");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_path");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_average");
          final List<FavouriteMovies> _result = new ArrayList<FavouriteMovies>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FavouriteMovies _item;
            final String _tmpBackdrop_path;
            if (_cursor.isNull(_cursorIndexOfBackdropPath)) {
              _tmpBackdrop_path = null;
            } else {
              _tmpBackdrop_path = _cursor.getString(_cursorIndexOfBackdropPath);
            }
            final String _tmpOverview;
            if (_cursor.isNull(_cursorIndexOfOverview)) {
              _tmpOverview = null;
            } else {
              _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            }
            final String _tmpPoster_path;
            if (_cursor.isNull(_cursorIndexOfPosterPath)) {
              _tmpPoster_path = null;
            } else {
              _tmpPoster_path = _cursor.getString(_cursorIndexOfPosterPath);
            }
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final float _tmpVote_average;
            _tmpVote_average = _cursor.getFloat(_cursorIndexOfVoteAverage);
            _item = new FavouriteMovies(_tmpBackdrop_path,_tmpOverview,_tmpPoster_path,_tmpId,_tmpTitle,_tmpVote_average);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
