package service.carrot.domain.converter;


import service.carrot.domain.AbstractBaseEnumConverter;
import service.carrot.domain.dao.PostCategory;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class PostCategoryConverter extends AbstractBaseEnumConverter<PostCategory, Integer> {

    @Override
    protected PostCategory[] getValueList() {
        return PostCategory.values();
    }
}