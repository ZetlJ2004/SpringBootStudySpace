package org.example.backendexamples.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backendexamples.exception.Code;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {
    private int code;
    private String msg;
    private Object data;

    private static final ResultVO EMPTY = ResultVO.builder()
            .code(200)
            .build();

    public static ResultVO ok() {
        return EMPTY;
    }

    public static ResultVO success(Object data) {
        return ResultVO.builder()
                .code(200)
                .data(data)
                .build();
    }

    public static ResultVO error(Code code) {
        return null;
    }

    public static ResultVO error(int number, String message) {
        return null;
    }
}
