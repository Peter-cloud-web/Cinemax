package com.example.domain.entities.model.tvShowsResponse;

@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 Y2\u00020\u0001:\u0002XYB\u00c1\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017B\u0087\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0018J\t\u0010<\u001a\u00020\u0005H\u00c6\u0003J\t\u0010=\u001a\u00020\u0010H\u00c6\u0003J\t\u0010>\u001a\u00020\u0005H\u00c6\u0003J\t\u0010?\u001a\u00020\u0010H\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010/J\t\u0010B\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u00c6\u0003J\t\u0010G\u001a\u00020\u0005H\u00c6\u0003J\t\u0010H\u001a\u00020\u0005H\u00c6\u0003J\t\u0010I\u001a\u00020\u0005H\u00c6\u0003J\u00aa\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010O\u001a\u00020\u0003H\u00d6\u0001J\t\u0010P\u001a\u00020\u0005H\u00d6\u0001J!\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u00c7\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001cR$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001a\u001a\u0004\b\'\u0010!R\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001cR\u001c\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010\u001cR\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010\u001cR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u001a\u001a\u0004\b4\u00105R\u001c\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u0010\u001cR\u001c\u0010\u0012\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u001a\u001a\u0004\b9\u00105R\u001c\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u001a\u001a\u0004\b;\u0010#\u00a8\u0006Z"}, d2 = {"Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResults;", "", "seen1", "", "backdrop_path", "", "first_air_date", "genre_ids", "", "id", "name", "origin_country", "original_language", "original_name", "overview", "popularity", "", "poster_path", "vote_average", "vote_count", "page", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;DILjava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;DILjava/lang/Integer;)V", "getBackdrop_path$annotations", "()V", "getBackdrop_path", "()Ljava/lang/String;", "getFirst_air_date$annotations", "getFirst_air_date", "getGenre_ids$annotations", "getGenre_ids", "()Ljava/util/List;", "getId", "()I", "getName$annotations", "getName", "getOrigin_country$annotations", "getOrigin_country", "getOriginal_language$annotations", "getOriginal_language", "getOriginal_name$annotations", "getOriginal_name", "getOverview$annotations", "getOverview", "getPage", "()Ljava/lang/Integer;", "setPage", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPopularity$annotations", "getPopularity", "()D", "getPoster_path$annotations", "getPoster_path", "getVote_average$annotations", "getVote_average", "getVote_count$annotations", "getVote_count", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;DILjava/lang/Integer;)Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResults;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "domain_debug"})
@androidx.room.TypeConverters(value = {com.example.domain.converter.ListConverter.class})
@androidx.room.Entity(tableName = "toprated_movieshows")
public final class TvShowsResults {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String backdrop_path = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String first_air_date = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Integer> genre_ids = null;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int id = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.List<java.lang.String> origin_country = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String original_language = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String original_name = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String overview = null;
    private final double popularity = 0.0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String poster_path = null;
    private final double vote_average = 0.0;
    private final int vote_count = 0;
    @androidx.room.ColumnInfo(name = "page")
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer page;
    @org.jetbrains.annotations.NotNull
    public static final com.example.domain.entities.model.tvShowsResponse.TvShowsResults.Companion Companion = null;
    
    public TvShowsResults(@org.jetbrains.annotations.NotNull
    java.lang.String backdrop_path, @org.jetbrains.annotations.NotNull
    java.lang.String first_air_date, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> genre_ids, int id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> origin_country, @org.jetbrains.annotations.NotNull
    java.lang.String original_language, @org.jetbrains.annotations.NotNull
    java.lang.String original_name, @org.jetbrains.annotations.NotNull
    java.lang.String overview, double popularity, @org.jetbrains.annotations.NotNull
    java.lang.String poster_path, double vote_average, int vote_count, @org.jetbrains.annotations.Nullable
    java.lang.Integer page) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBackdrop_path() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "backdrop_path")
    @java.lang.Deprecated
    public static void getBackdrop_path$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFirst_air_date() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "first_air_date")
    @java.lang.Deprecated
    public static void getFirst_air_date$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Integer> getGenre_ids() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "genre_ids")
    @java.lang.Deprecated
    public static void getGenre_ids$annotations() {
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "name")
    @java.lang.Deprecated
    public static void getName$annotations() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getOrigin_country() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "origin_country")
    @java.lang.Deprecated
    public static void getOrigin_country$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOriginal_language() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "original_language")
    @java.lang.Deprecated
    public static void getOriginal_language$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOriginal_name() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "original_name")
    @java.lang.Deprecated
    public static void getOriginal_name$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOverview() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "overview")
    @java.lang.Deprecated
    public static void getOverview$annotations() {
    }
    
    public final double getPopularity() {
        return 0.0;
    }
    
    @kotlinx.serialization.SerialName(value = "popularity")
    @java.lang.Deprecated
    public static void getPopularity$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPoster_path() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "poster_path")
    @java.lang.Deprecated
    public static void getPoster_path$annotations() {
    }
    
    public final double getVote_average() {
        return 0.0;
    }
    
    @kotlinx.serialization.SerialName(value = "vote_average")
    @java.lang.Deprecated
    public static void getVote_average$annotations() {
    }
    
    public final int getVote_count() {
        return 0;
    }
    
    @kotlinx.serialization.SerialName(value = "vote_count")
    @java.lang.Deprecated
    public static void getVote_count$annotations() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getPage() {
        return null;
    }
    
    public final void setPage(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
        return null;
    }
    
    public final double component12() {
        return 0.0;
    }
    
    public final int component13() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Integer> component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.domain.entities.model.tvShowsResponse.TvShowsResults copy(@org.jetbrains.annotations.NotNull
    java.lang.String backdrop_path, @org.jetbrains.annotations.NotNull
    java.lang.String first_air_date, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> genre_ids, int id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> origin_country, @org.jetbrains.annotations.NotNull
    java.lang.String original_language, @org.jetbrains.annotations.NotNull
    java.lang.String original_name, @org.jetbrains.annotations.NotNull
    java.lang.String overview, double popularity, @org.jetbrains.annotations.NotNull
    java.lang.String poster_path, double vote_average, int vote_count, @org.jetbrains.annotations.Nullable
    java.lang.Integer page) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmStatic
    public static final void write$Self(@org.jetbrains.annotations.NotNull
    com.example.domain.entities.model.tvShowsResponse.TvShowsResults self, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"com/example/domain/entities/model/tvShowsResponse/TvShowsResults.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResults;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "domain_debug"})
    @java.lang.Deprecated
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<com.example.domain.entities.model.tvShowsResponse.TvShowsResults> {
        @org.jetbrains.annotations.NotNull
        public static final com.example.domain.entities.model.tvShowsResponse.TvShowsResults.$serializer INSTANCE = null;
        
        private $serializer() {
            super();
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] childSerializers() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.example.domain.entities.model.tvShowsResponse.TvShowsResults deserialize(@org.jetbrains.annotations.NotNull
        kotlinx.serialization.encoding.Decoder decoder) {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.descriptors.SerialDescriptor getDescriptor() {
            return null;
        }
        
        @java.lang.Override
        public void serialize(@org.jetbrains.annotations.NotNull
        kotlinx.serialization.encoding.Encoder encoder, @org.jetbrains.annotations.NotNull
        com.example.domain.entities.model.tvShowsResponse.TvShowsResults value) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResults$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResults;", "domain_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<com.example.domain.entities.model.tvShowsResponse.TvShowsResults> serializer() {
            return null;
        }
    }
}