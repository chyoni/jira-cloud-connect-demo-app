package kr.osci.addons.app.domain.board.controller.api.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse <T> {
    private T data;
    private HttpStatus status;
    private String errorMessage;
    private String hostBaseUrl;

    public static <T> ApiResponse<T> ok(T data, String hostBaseUrl) {
        ApiResponse<T> res = new ApiResponse<>();
        res.data = data;
        res.status = HttpStatus.OK;
        res.errorMessage = null;
        res.hostBaseUrl = hostBaseUrl;
        return res;
    }

    public static <T> ApiResponse<T> of(T data, HttpStatus status, String hostBaseUrl) {
        ApiResponse<T> res = new ApiResponse<>();
        res.data = data;
        res.status = status;
        res.errorMessage = null;
        res.hostBaseUrl = hostBaseUrl;
        return res;
    }

    public static <T> ApiResponse<T> of(T data, HttpStatus status, String errorMessage, String hostBaseUrl) {
        ApiResponse<T> res = new ApiResponse<>();
        res.data = data;
        res.status = status;
        res.errorMessage = errorMessage;
        res.hostBaseUrl = hostBaseUrl;
        return res;
    }
}
