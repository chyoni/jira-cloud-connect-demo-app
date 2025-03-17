package kr.osci.addons.app.domain.board.client;

import com.atlassian.connect.spring.AtlassianHostRestClients;
import com.atlassian.connect.spring.AtlassianHostUser;
import kr.osci.addons.app.domain.board.service.response.JiraUserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AtlassianRestClient {
    private final AtlassianHostRestClients atlassianHostRestClients;

    public JiraUserResponse getJiraUser(AtlassianHostUser hostUser, String accountId) {
        String baseUrl = hostUser.getHost().getBaseUrl();

        String url = String.format("%s/rest/api/3/user?accountId=%s", baseUrl, accountId);
        log.info("[getJiraUser:21] Request URL: {}", url);

        ResponseEntity<JiraUserResponse> response = atlassianHostRestClients
                .authenticatedAsAddon()
                .getForEntity(url, JiraUserResponse.class);

        // TODO: 예외처리

        return response.getBody();
    }
}
