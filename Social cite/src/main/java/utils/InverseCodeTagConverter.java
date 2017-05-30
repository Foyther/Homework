package utils;

import models.CodeTag;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InverseCodeTagConverter implements Converter<CodeTag, String> {

    @Override
    public String convert(CodeTag s) {
        return Integer.toString(s.getId());
    }
}
