package lk.epic.customer_service.util;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class ResponseUtil<T> {
    private String responseCode;
    private String responseMsg;
    private T content;
}
