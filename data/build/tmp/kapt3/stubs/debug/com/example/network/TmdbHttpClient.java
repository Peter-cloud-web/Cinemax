package com.example.network;

import android.util.Log;
import io.ktor.client.engine.android.Android;
import io.ktor.client.features.DefaultRequest;
import io.ktor.client.features.json.JsonFeature;
import io.ktor.client.features.json.serializer.KotlinxSerializer;
import io.ktor.client.features.logging.Logger;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/example/network/TmdbHttpClient;", "", "()V", "getHttpClient", "Lio/ktor/client/HttpClient;", "Companion", "data_debug"})
public final class TmdbHttpClient {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG_KTOR_LOGGER = "ktor_logger";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG_HTTP_STATUS_LOGGER = "http_status";
    @org.jetbrains.annotations.NotNull
    public static final com.example.network.TmdbHttpClient.Companion Companion = null;
    
    public TmdbHttpClient() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final io.ktor.client.HttpClient getHttpClient() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/network/TmdbHttpClient$Companion;", "", "()V", "TAG_HTTP_STATUS_LOGGER", "", "TAG_KTOR_LOGGER", "data_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}