package utils;

import models.CodeTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import repositories.TagRepository;

@Component
public class CodeTagConverter implements Converter<String, CodeTag> {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public CodeTag convert(String s) {
        if(s.equals("NONE")){
            return null;
        }
        CodeTag codeTag = tagRepository.findOne(Integer.parseInt(s));
        return codeTag;
    }
}
