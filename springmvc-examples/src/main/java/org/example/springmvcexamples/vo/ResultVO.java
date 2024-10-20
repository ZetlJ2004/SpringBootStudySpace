package org.example.springmvcexamples.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springmvcexamples.exception.Code;

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
        return ResultVO.builder()
                .code(code.getNumber())
                .msg(code.getMessage())
                .build();
    }
}
