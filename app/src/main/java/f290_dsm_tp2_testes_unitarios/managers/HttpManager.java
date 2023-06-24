package f290_dsm_tp2_testes_unitarios.managers;

import java.io.IOException;
import java.util.Optional;

import kotlin.Pair;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpManager {

    private OkHttpClient httpClient;

    public HttpManager(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Optional<Pair<Integer, String>> sendGetRequest(String pUrl) throws IOException {

        Request request = new Request.Builder()
                .url(pUrl)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            return Optional.of(new Pair<>(response.code(), response.body().string()));
        }

    }
}
