package kr.osci.addons.app;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageResourceHelper {

    private final MessageSource messageSource;

    public String getMessage(String code, Object... args) {
        // LocaleContextHolder.getLocale() -- 현재 스레드의 Locale
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
