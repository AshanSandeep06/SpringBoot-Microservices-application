package lk.epic.fraud_service.util;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class ResponseUtil<T> {
    private String responseCod;
    private String responseMsg;
    private T content;
}
