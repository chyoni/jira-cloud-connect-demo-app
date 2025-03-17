package kr.osci.addons.app.domain.board.service.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JiraUserResponse {
    private String accountId;
    private String emailAddress;
    private String displayName;
    private Map<String, String> avatarUrls;
}
