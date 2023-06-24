package f290_dsm_tp2_testes_unitarios.managers;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import kotlin.Pair;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HttpManagerTest {

    @Test
    public void testSendGerRequest() throws IOException {

        // ARRANGE
        String url = "https://api.hgbrasil.com/weather";

        OkHttpClient mockClientOkHttp = mock(OkHttpClient.class);

        Call mockCall = mock(Call.class);

        Request mockRequest = new Request.Builder()
                .url(url)
                .build();

        Response response = new Response.Builder()
                .request(mockRequest)
                .protocol(Protocol.HTTP_2)
                .code(401) // status code
                .message("")
                .body(ResponseBody.create("{\"code\":200, \"message\":\"Lorem ipsum dolor sit amet.\"}",
                        MediaType.parse("\"application/json; charset=utf-8\"")))
                .build();

        when(mockClientOkHttp.newCall(any(Request.class))).thenReturn(mockCall);
        when(mockCall.execute()).thenReturn(response);

        // ACT

        HttpManager sut = new HttpManager(mockClientOkHttp);
        Optional<Pair<Integer, String>> optional = sut.sendGetRequest(url);

        // ASSERT
        assertDoesNotThrow(() -> sut.sendGetRequest(url));
        assertTrue(optional.isPresent());
        assertEquals(401, optional.get().getFirst());
        assertFalse(optional.get().getSecond().isEmpty());

        
    }
}
