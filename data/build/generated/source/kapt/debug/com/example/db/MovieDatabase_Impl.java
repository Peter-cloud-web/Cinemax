package com.example.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.db.dao.movieDaos.FavouriteMoviesDao;
import com.example.db.dao.movieDaos.FavouriteMoviesDao_Impl;
import com.example.db.dao.movieDaos.MovieDao;
import com.example.db.dao.movieDaos.MovieDao_Impl;
import com.example.db.dao.movieDaos.TopRatedMoviesDao;
import com.example.db.dao.movieDaos.TopRatedMoviesDao_Impl;
import com.example.db.dao.movieDaos.TopRatedTvShowsDao;
import com.example.db.dao.movieDaos.TopRatedTvShowsDao_Impl;
import com.example.db.dao.movieDaos.UpComingMoviesDao;
import com.example.db.dao.movieDaos.UpComingMoviesDao_Impl;
import com.example.db.dao.remoteKeysDaos.RemoteKeysDao;
import com.example.db.dao.remoteKeysDaos.RemoteKeysDao_Impl;
import com.example.db.dao.remoteKeysDaos.TopRatedRemoteKeysDao;
import com.example.db.dao.remoteKeysDaos.TopRatedRemoteKeysDao_Impl;
import com.example.db.dao.remoteKeysDaos.TopRatedTvShowsRemoteKeysDao;
import com.example.db.dao.remoteKeysDaos.TopRatedTvShowsRemoteKeysDao_Impl;
import com.example.db.dao.remoteKeysDaos.UpComingRemoteKeyDao;
import com.example.db.dao.remoteKeysDaos.UpComingRemoteKeyDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDatabase_Impl extends MovieDatabase {
  private volatile MovieDao _movieDao;

  private volatile RemoteKeysDao _remoteKeysDao;

  private volatile UpComingMoviesDao _upComingMoviesDao;

  private volatile UpComingRemoteKeyDao _upComingRemoteKeyDao;

  private volatile TopRatedMoviesDao _topRatedMoviesDao;

  private volatile TopRatedRemoteKeysDao _topRatedRemoteKeysDao;

  private volatile TopRatedTvShowsDao _topRatedTvShowsDao;

  private volatile TopRatedTvShowsRemoteKeysDao _topRatedTvShowsRemoteKeysDao;

  private volatile FavouriteMoviesDao _favouriteMoviesDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(17) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `movies` (`backdrop_path` TEXT, `overview` TEXT, `poster_path` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT, `vote_average` REAL NOT NULL, `page` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `toprated_movies` (`backdrop_path` TEXT, `overview` TEXT, `poster_path` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT, `vote_average` REAL NOT NULL, `page` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `upcoming_movies` (`backdrop_path` TEXT, `overview` TEXT, `poster_path` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT, `vote_average` REAL NOT NULL, `page` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `toprated_movieshows` (`backdrop_path` TEXT NOT NULL, `first_air_date` TEXT NOT NULL, `genre_ids` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `origin_country` TEXT, `original_language` TEXT NOT NULL, `original_name` TEXT NOT NULL, `overview` TEXT NOT NULL, `popularity` REAL NOT NULL, `poster_path` TEXT NOT NULL, `vote_average` REAL NOT NULL, `vote_count` INTEGER NOT NULL, `page` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `favourite_movies` (`backdrop_path` TEXT, `overview` TEXT, `poster_path` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT, `vote_average` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `remote_key` (`movie_id` INTEGER NOT NULL, `prevKey` INTEGER, `currentPage` INTEGER NOT NULL, `nextKey` INTEGER, `created_at` INTEGER NOT NULL, PRIMARY KEY(`movie_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `toprated_remote_key` (`movie_id` INTEGER NOT NULL, `prevKey` INTEGER, `currentPage` INTEGER NOT NULL, `nextKey` INTEGER, `created_at` INTEGER NOT NULL, PRIMARY KEY(`movie_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `upcoming_remote_keys` (`movie_id` INTEGER NOT NULL, `prevKey` INTEGER, `currentPage` INTEGER NOT NULL, `nextKey` INTEGER, `created_at` INTEGER NOT NULL, PRIMARY KEY(`movie_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `toprated_tvshows_remote_keys` (`movie_id` INTEGER NOT NULL, `prevKey` INTEGER, `currentPage` INTEGER NOT NULL, `nextKey` INTEGER, `created_at` INTEGER NOT NULL, PRIMARY KEY(`movie_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'dbc0d08db222964bc023fa71ade61aa5')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `movies`");
        _db.execSQL("DROP TABLE IF EXISTS `toprated_movies`");
        _db.execSQL("DROP TABLE IF EXISTS `upcoming_movies`");
        _db.execSQL("DROP TABLE IF EXISTS `toprated_movieshows`");
        _db.execSQL("DROP TABLE IF EXISTS `favourite_movies`");
        _db.execSQL("DROP TABLE IF EXISTS `remote_key`");
        _db.execSQL("DROP TABLE IF EXISTS `toprated_remote_key`");
        _db.execSQL("DROP TABLE IF EXISTS `upcoming_remote_keys`");
        _db.execSQL("DROP TABLE IF EXISTS `toprated_tvshows_remote_keys`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMovies = new HashMap<String, TableInfo.Column>(7);
        _columnsMovies.put("backdrop_path", new TableInfo.Column("backdrop_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovies.put("overview", new TableInfo.Column("overview", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovies.put("poster_path", new TableInfo.Column("poster_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovies.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovies.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovies.put("vote_average", new TableInfo.Column("vote_average", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovies.put("page", new TableInfo.Column("page", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMovies = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMovies = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMovies = new TableInfo("movies", _columnsMovies, _foreignKeysMovies, _indicesMovies);
        final TableInfo _existingMovies = TableInfo.read(_db, "movies");
        if (! _infoMovies.equals(_existingMovies)) {
          return new RoomOpenHelper.ValidationResult(false, "movies(com.example.cinemaxv3.models.Movie).\n"
                  + " Expected:\n" + _infoMovies + "\n"
                  + " Found:\n" + _existingMovies);
        }
        final HashMap<String, TableInfo.Column> _columnsTopratedMovies = new HashMap<String, TableInfo.Column>(7);
        _columnsTopratedMovies.put("backdrop_path", new TableInfo.Column("backdrop_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovies.put("overview", new TableInfo.Column("overview", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovies.put("poster_path", new TableInfo.Column("poster_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovies.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovies.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovies.put("vote_average", new TableInfo.Column("vote_average", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovies.put("page", new TableInfo.Column("page", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTopratedMovies = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTopratedMovies = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTopratedMovies = new TableInfo("toprated_movies", _columnsTopratedMovies, _foreignKeysTopratedMovies, _indicesTopratedMovies);
        final TableInfo _existingTopratedMovies = TableInfo.read(_db, "toprated_movies");
        if (! _infoTopratedMovies.equals(_existingTopratedMovies)) {
          return new RoomOpenHelper.ValidationResult(false, "toprated_movies(com.example.cinemaxv3.models.TopRatedMovies).\n"
                  + " Expected:\n" + _infoTopratedMovies + "\n"
                  + " Found:\n" + _existingTopratedMovies);
        }
        final HashMap<String, TableInfo.Column> _columnsUpcomingMovies = new HashMap<String, TableInfo.Column>(7);
        _columnsUpcomingMovies.put("backdrop_path", new TableInfo.Column("backdrop_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpcomingMovies.put("overview", new TableInfo.Column("overview", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpcomingMovies.put("poster_path", new TableInfo.Column("poster_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpcomingMovies.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpcomingMovies.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpcomingMovies.put("vote_average", new TableInfo.Column("vote_average", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpcomingMovies.put("page", new TableInfo.Column("page", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUpcomingMovies = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUpcomingMovies = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUpcomingMovies = new TableInfo("upcoming_movies", _columnsUpcomingMovies, _foreignKeysUpcomingMovies, _indicesUpcomingMovies);
        final TableInfo _existingUpcomingMovies = TableInfo.read(_db, "upcoming_movies");
        if (! _infoUpcomingMovies.equals(_existingUpcomingMovies)) {
          return new RoomOpenHelper.ValidationResult(false, "upcoming_movies(com.example.cinemaxv3.models.UpComingMovies).\n"
                  + " Expected:\n" + _infoUpcomingMovies + "\n"
                  + " Found:\n" + _existingUpcomingMovies);
        }
        final HashMap<String, TableInfo.Column> _columnsTopratedMovieshows = new HashMap<String, TableInfo.Column>(14);
        _columnsTopratedMovieshows.put("backdrop_path", new TableInfo.Column("backdrop_path", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovieshows.put("first_air_date", new TableInfo.Column("first_air_date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovieshows.put("genre_ids", new TableInfo.Column("genre_ids", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovieshows.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovieshows.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovieshows.put("origin_country", new TableInfo.Column("origin_country", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovieshows.put("original_language", new TableInfo.Column("original_language", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovieshows.put("original_name", new TableInfo.Column("original_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovieshows.put("overview", new TableInfo.Column("overview", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovieshows.put("popularity", new TableInfo.Column("popularity", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovieshows.put("poster_path", new TableInfo.Column("poster_path", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovieshows.put("vote_average", new TableInfo.Column("vote_average", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovieshows.put("vote_count", new TableInfo.Column("vote_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedMovieshows.put("page", new TableInfo.Column("page", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTopratedMovieshows = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTopratedMovieshows = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTopratedMovieshows = new TableInfo("toprated_movieshows", _columnsTopratedMovieshows, _foreignKeysTopratedMovieshows, _indicesTopratedMovieshows);
        final TableInfo _existingTopratedMovieshows = TableInfo.read(_db, "toprated_movieshows");
        if (! _infoTopratedMovieshows.equals(_existingTopratedMovieshows)) {
          return new RoomOpenHelper.ValidationResult(false, "toprated_movieshows(com.example.domain.entities.model.tvShowsResponse.TvShowsResults).\n"
                  + " Expected:\n" + _infoTopratedMovieshows + "\n"
                  + " Found:\n" + _existingTopratedMovieshows);
        }
        final HashMap<String, TableInfo.Column> _columnsFavouriteMovies = new HashMap<String, TableInfo.Column>(6);
        _columnsFavouriteMovies.put("backdrop_path", new TableInfo.Column("backdrop_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouriteMovies.put("overview", new TableInfo.Column("overview", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouriteMovies.put("poster_path", new TableInfo.Column("poster_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouriteMovies.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouriteMovies.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouriteMovies.put("vote_average", new TableInfo.Column("vote_average", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFavouriteMovies = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFavouriteMovies = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFavouriteMovies = new TableInfo("favourite_movies", _columnsFavouriteMovies, _foreignKeysFavouriteMovies, _indicesFavouriteMovies);
        final TableInfo _existingFavouriteMovies = TableInfo.read(_db, "favourite_movies");
        if (! _infoFavouriteMovies.equals(_existingFavouriteMovies)) {
          return new RoomOpenHelper.ValidationResult(false, "favourite_movies(com.example.domain.entities.model.favourites.FavouriteMovies).\n"
                  + " Expected:\n" + _infoFavouriteMovies + "\n"
                  + " Found:\n" + _existingFavouriteMovies);
        }
        final HashMap<String, TableInfo.Column> _columnsRemoteKey = new HashMap<String, TableInfo.Column>(5);
        _columnsRemoteKey.put("movie_id", new TableInfo.Column("movie_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRemoteKey.put("prevKey", new TableInfo.Column("prevKey", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRemoteKey.put("currentPage", new TableInfo.Column("currentPage", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRemoteKey.put("nextKey", new TableInfo.Column("nextKey", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRemoteKey.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRemoteKey = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRemoteKey = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRemoteKey = new TableInfo("remote_key", _columnsRemoteKey, _foreignKeysRemoteKey, _indicesRemoteKey);
        final TableInfo _existingRemoteKey = TableInfo.read(_db, "remote_key");
        if (! _infoRemoteKey.equals(_existingRemoteKey)) {
          return new RoomOpenHelper.ValidationResult(false, "remote_key(com.example.cinemaxv3.models.MovieRemoteKeys).\n"
                  + " Expected:\n" + _infoRemoteKey + "\n"
                  + " Found:\n" + _existingRemoteKey);
        }
        final HashMap<String, TableInfo.Column> _columnsTopratedRemoteKey = new HashMap<String, TableInfo.Column>(5);
        _columnsTopratedRemoteKey.put("movie_id", new TableInfo.Column("movie_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedRemoteKey.put("prevKey", new TableInfo.Column("prevKey", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedRemoteKey.put("currentPage", new TableInfo.Column("currentPage", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedRemoteKey.put("nextKey", new TableInfo.Column("nextKey", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedRemoteKey.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTopratedRemoteKey = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTopratedRemoteKey = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTopratedRemoteKey = new TableInfo("toprated_remote_key", _columnsTopratedRemoteKey, _foreignKeysTopratedRemoteKey, _indicesTopratedRemoteKey);
        final TableInfo _existingTopratedRemoteKey = TableInfo.read(_db, "toprated_remote_key");
        if (! _infoTopratedRemoteKey.equals(_existingTopratedRemoteKey)) {
          return new RoomOpenHelper.ValidationResult(false, "toprated_remote_key(com.example.cinemaxv3.models.TopRatedRemoteKeys).\n"
                  + " Expected:\n" + _infoTopratedRemoteKey + "\n"
                  + " Found:\n" + _existingTopratedRemoteKey);
        }
        final HashMap<String, TableInfo.Column> _columnsUpcomingRemoteKeys = new HashMap<String, TableInfo.Column>(5);
        _columnsUpcomingRemoteKeys.put("movie_id", new TableInfo.Column("movie_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpcomingRemoteKeys.put("prevKey", new TableInfo.Column("prevKey", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpcomingRemoteKeys.put("currentPage", new TableInfo.Column("currentPage", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpcomingRemoteKeys.put("nextKey", new TableInfo.Column("nextKey", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpcomingRemoteKeys.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUpcomingRemoteKeys = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUpcomingRemoteKeys = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUpcomingRemoteKeys = new TableInfo("upcoming_remote_keys", _columnsUpcomingRemoteKeys, _foreignKeysUpcomingRemoteKeys, _indicesUpcomingRemoteKeys);
        final TableInfo _existingUpcomingRemoteKeys = TableInfo.read(_db, "upcoming_remote_keys");
        if (! _infoUpcomingRemoteKeys.equals(_existingUpcomingRemoteKeys)) {
          return new RoomOpenHelper.ValidationResult(false, "upcoming_remote_keys(com.example.cinemaxv3.models.UpComingRemoteKeys).\n"
                  + " Expected:\n" + _infoUpcomingRemoteKeys + "\n"
                  + " Found:\n" + _existingUpcomingRemoteKeys);
        }
        final HashMap<String, TableInfo.Column> _columnsTopratedTvshowsRemoteKeys = new HashMap<String, TableInfo.Column>(5);
        _columnsTopratedTvshowsRemoteKeys.put("movie_id", new TableInfo.Column("movie_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedTvshowsRemoteKeys.put("prevKey", new TableInfo.Column("prevKey", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedTvshowsRemoteKeys.put("currentPage", new TableInfo.Column("currentPage", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedTvshowsRemoteKeys.put("nextKey", new TableInfo.Column("nextKey", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopratedTvshowsRemoteKeys.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTopratedTvshowsRemoteKeys = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTopratedTvshowsRemoteKeys = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTopratedTvshowsRemoteKeys = new TableInfo("toprated_tvshows_remote_keys", _columnsTopratedTvshowsRemoteKeys, _foreignKeysTopratedTvshowsRemoteKeys, _indicesTopratedTvshowsRemoteKeys);
        final TableInfo _existingTopratedTvshowsRemoteKeys = TableInfo.read(_db, "toprated_tvshows_remote_keys");
        if (! _infoTopratedTvshowsRemoteKeys.equals(_existingTopratedTvshowsRemoteKeys)) {
          return new RoomOpenHelper.ValidationResult(false, "toprated_tvshows_remote_keys(com.example.cinemaxv3.models.TopRatedTvShowsRemoteKeys).\n"
                  + " Expected:\n" + _infoTopratedTvshowsRemoteKeys + "\n"
                  + " Found:\n" + _existingTopratedTvshowsRemoteKeys);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "dbc0d08db222964bc023fa71ade61aa5", "30431994aa0d4466574237c4e6ba2660");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "movies","toprated_movies","upcoming_movies","toprated_movieshows","favourite_movies","remote_key","toprated_remote_key","upcoming_remote_keys","toprated_tvshows_remote_keys");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `movies`");
      _db.execSQL("DELETE FROM `toprated_movies`");
      _db.execSQL("DELETE FROM `upcoming_movies`");
      _db.execSQL("DELETE FROM `toprated_movieshows`");
      _db.execSQL("DELETE FROM `favourite_movies`");
      _db.execSQL("DELETE FROM `remote_key`");
      _db.execSQL("DELETE FROM `toprated_remote_key`");
      _db.execSQL("DELETE FROM `upcoming_remote_keys`");
      _db.execSQL("DELETE FROM `toprated_tvshows_remote_keys`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MovieDao.class, MovieDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(RemoteKeysDao.class, RemoteKeysDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UpComingMoviesDao.class, UpComingMoviesDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UpComingRemoteKeyDao.class, UpComingRemoteKeyDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TopRatedMoviesDao.class, TopRatedMoviesDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TopRatedRemoteKeysDao.class, TopRatedRemoteKeysDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TopRatedTvShowsDao.class, TopRatedTvShowsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TopRatedTvShowsRemoteKeysDao.class, TopRatedTvShowsRemoteKeysDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FavouriteMoviesDao.class, FavouriteMoviesDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public MovieDao getMovieDao() {
    if (_movieDao != null) {
      return _movieDao;
    } else {
      synchronized(this) {
        if(_movieDao == null) {
          _movieDao = new MovieDao_Impl(this);
        }
        return _movieDao;
      }
    }
  }

  @Override
  public RemoteKeysDao getRemoteKeysDao() {
    if (_remoteKeysDao != null) {
      return _remoteKeysDao;
    } else {
      synchronized(this) {
        if(_remoteKeysDao == null) {
          _remoteKeysDao = new RemoteKeysDao_Impl(this);
        }
        return _remoteKeysDao;
      }
    }
  }

  @Override
  public UpComingMoviesDao getUpComingMoviesDao() {
    if (_upComingMoviesDao != null) {
      return _upComingMoviesDao;
    } else {
      synchronized(this) {
        if(_upComingMoviesDao == null) {
          _upComingMoviesDao = new UpComingMoviesDao_Impl(this);
        }
        return _upComingMoviesDao;
      }
    }
  }

  @Override
  public UpComingRemoteKeyDao getUpComingRemoteKeysDao() {
    if (_upComingRemoteKeyDao != null) {
      return _upComingRemoteKeyDao;
    } else {
      synchronized(this) {
        if(_upComingRemoteKeyDao == null) {
          _upComingRemoteKeyDao = new UpComingRemoteKeyDao_Impl(this);
        }
        return _upComingRemoteKeyDao;
      }
    }
  }

  @Override
  public TopRatedMoviesDao getTopRatedMoviesDao() {
    if (_topRatedMoviesDao != null) {
      return _topRatedMoviesDao;
    } else {
      synchronized(this) {
        if(_topRatedMoviesDao == null) {
          _topRatedMoviesDao = new TopRatedMoviesDao_Impl(this);
        }
        return _topRatedMoviesDao;
      }
    }
  }

  @Override
  public TopRatedRemoteKeysDao getTopRatedRemoteKeysDao() {
    if (_topRatedRemoteKeysDao != null) {
      return _topRatedRemoteKeysDao;
    } else {
      synchronized(this) {
        if(_topRatedRemoteKeysDao == null) {
          _topRatedRemoteKeysDao = new TopRatedRemoteKeysDao_Impl(this);
        }
        return _topRatedRemoteKeysDao;
      }
    }
  }

  @Override
  public TopRatedTvShowsDao getTopRatedTvShowsDao() {
    if (_topRatedTvShowsDao != null) {
      return _topRatedTvShowsDao;
    } else {
      synchronized(this) {
        if(_topRatedTvShowsDao == null) {
          _topRatedTvShowsDao = new TopRatedTvShowsDao_Impl(this);
        }
        return _topRatedTvShowsDao;
      }
    }
  }

  @Override
  public TopRatedTvShowsRemoteKeysDao getTopRatedTvShowsRemoteKeysDao() {
    if (_topRatedTvShowsRemoteKeysDao != null) {
      return _topRatedTvShowsRemoteKeysDao;
    } else {
      synchronized(this) {
        if(_topRatedTvShowsRemoteKeysDao == null) {
          _topRatedTvShowsRemoteKeysDao = new TopRatedTvShowsRemoteKeysDao_Impl(this);
        }
        return _topRatedTvShowsRemoteKeysDao;
      }
    }
  }

  @Override
  public FavouriteMoviesDao getFavouriteMoviesDao() {
    if (_favouriteMoviesDao != null) {
      return _favouriteMoviesDao;
    } else {
      synchronized(this) {
        if(_favouriteMoviesDao == null) {
          _favouriteMoviesDao = new FavouriteMoviesDao_Impl(this);
        }
        return _favouriteMoviesDao;
      }
    }
  }
}
