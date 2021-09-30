package es.jguimar.tinybankAPI.adapter.rest.tranform;

import es.jguimar.tinybankAPI.adapter.rest.dto.UserResponseDto;
import es.jguimar.tinybankAPI.adapter.rest.dto.WalletResponseDto;
import es.jguimar.tinybankAPI.domain.model.User;
import es.jguimar.tinybankAPI.domain.model.Wallet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-30T15:18:38+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class WalletMapperImpl implements WalletMapper {

    @Override
    public WalletResponseDto toWalletResponseDto(Wallet source) {
        if ( source == null ) {
            return null;
        }

        WalletResponseDto walletResponseDto = new WalletResponseDto();

        walletResponseDto.setId( source.getId() );
        List<Double> list = source.getMovements();
        if ( list != null ) {
            walletResponseDto.setMovements( new ArrayList<Double>( list ) );
        }
        walletResponseDto.setTotalAmount( source.getTotalAmount() );

        return walletResponseDto;
    }

    @Override
    public UserResponseDto toUserResponseDto(User source) {
        if ( source == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId( source.getId() );
        userResponseDto.setName( source.getName() );

        return userResponseDto;
    }
}
