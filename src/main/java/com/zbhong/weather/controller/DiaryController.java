package com.zbhong.weather.controller;

import com.zbhong.weather.domain.Diary;
import com.zbhong.weather.exception.DiaryException;
import com.zbhong.weather.service.DiaryService;
import com.zbhong.weather.type.ErrorCode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @ApiOperation(value = "일기 내용과 날씨를 이용해서 DB에 일기 저장", notes = "상세설명")
    @PostMapping("/create/diary")
    public void createDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "일기를 생성할 날짜", example = "2023-01-01")LocalDate date
            , @RequestBody String text) {
        validateDate(date);
        diaryService.createDiary(date, text);
    }

    @ApiOperation(value = "선택한 날짜의 모든 일기를 가져옵니다.")
    @GetMapping("/read/diary")
    public List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 날짜", example = "2023-01-01") LocalDate date) {
        validateDate(date);
        return diaryService.readDiary(date);
    }

    @ApiOperation(value = "선택한 기간중의 모든 일기를 가져옵니다.")
    @GetMapping("/read/diaries")
    public List<Diary> readDiaries(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 기간의 첫번째날", example = "2023-01-01") LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 기간의 마지막날", example = "2023-01-01") LocalDate endDate
    ) {
        validateDate(startDate);
        return diaryService.readDiaries(startDate, endDate);
    }

    @ApiOperation(value = "선택한 날짜의 일기를 수정합니다.")
    @PutMapping("/update/diary")
    public void updateDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "수정할 일기의 날짜", example = "2023-01-01") LocalDate date,
            @RequestBody String text
    ) {
        validateDate(date);
        diaryService.updateDiary(date, text);
    }

    @ApiOperation(value = "선택한 날짜의 일기를 삭제합니다.")
    @DeleteMapping("/delete/diary")
    public void deleteDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "삭제할 일기의 날짜", example = "2023-01-01") LocalDate date
    ) {
        validateDate(date);
        diaryService.deleteDiary(date);
    }

    private void validateDate(LocalDate date) {
        if (date.isAfter(LocalDate.ofYearDay(3000, 1))) {
            throw new DiaryException(ErrorCode.INVALID_DATE);
        }
    }
}
