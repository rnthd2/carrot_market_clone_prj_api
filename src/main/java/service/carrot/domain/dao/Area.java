package service.carrot.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import service.carrot.domain.BaseEnumCode;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Area implements BaseEnumCode<String> {
    SEOUL("02","서울"),
    BUSAN("051", "부산"),
    DAEGU("053", "대구"),
    INCHEON("032", "인천"),
    GWANGJU("062", "광주"),
    DAEJEON("042", "대전"),
    ULSAN("052", "울산"),
    SEJONG("044", "세종"),
    GYEONGGI("031", "경기"),
    GANGWON("033", "강원"),
    CHUNGBUK("043", "충북"),
    CHUNGNAM("041", "충남"),
    JEONBUK("063", "전북"),
    JEONNAM("061", "전남"),
    GYEONGBUK("054", "경북"),
    GYEONGNAM("055", "경남"),
    JEJU("064", "제주");

    private final String code;
    private final String name;

    @Override
    public String getValue() {
        return this.code;
    }

    public static Area getAreaByAreaCode(String code){
        for (Area area : Area.values()) {
            if(area.getCode().equals(code)){
                return area;
            }
        }
        return null;
    }
}
