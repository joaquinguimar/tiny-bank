package es.jguimar.tinybankAPI.adapter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequestDto {

    @NotNull
    private Double amount;

    @NotEmpty
    private String walletSource;

    @NotEmpty
    private String walletTarget;

}
