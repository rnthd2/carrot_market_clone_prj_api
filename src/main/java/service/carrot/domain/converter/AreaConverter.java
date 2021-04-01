package service.carrot.domain.converter;

import service.carrot.domain.dao.Area;
import service.carrot.domain.AbstractBaseEnumConverter;

import javax.persistence.Converter;

@Converter(autoApply = true)//글로벌하게 설정도 가능하다. 특정 속성에 @Convert(converter = ..._) 가 등록되지 않아도 된다는 의미이다.
public class AreaConverter extends AbstractBaseEnumConverter<Area, String> {

    @Override
    protected Area[] getValueList() {
        return Area.values();
    }
}