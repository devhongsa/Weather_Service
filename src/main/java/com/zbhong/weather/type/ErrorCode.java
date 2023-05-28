package com.zbhong.weather.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_DATE("너무 먼 미래의 날짜입니다."),
    INTERNAL_SERVER_ERROR("내부 서버 오류가 발생하였습니다");

    private final String description;
}
