package com.zbhong.weather.exception;

import com.zbhong.weather.type.ErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaryException extends RuntimeException{
    private ErrorCode errorCode;
    private String errorMassage;

    public DiaryException(ErrorCode errorCode){
        this.errorCode = errorCode;
        this.errorMassage = errorCode.getDescription();
    }


}
