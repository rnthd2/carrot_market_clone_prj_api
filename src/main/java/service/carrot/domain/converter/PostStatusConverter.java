package service.carrot.domain.converter;


import service.carrot.domain.AbstractBaseEnumConverter;
import service.carrot.domain.dao.PostStatus;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class PostStatusConverter extends AbstractBaseEnumConverter<PostStatus, Integer> {

    @Override
    protected PostStatus[] getValueList() {
        return PostStatus.values();
    }
}