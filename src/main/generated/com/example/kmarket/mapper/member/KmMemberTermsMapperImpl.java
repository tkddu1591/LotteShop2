package com.example.kmarket.mapper.member;

import com.example.kmarket.dto.member.KmMemberTermsDTO;
import com.example.kmarket.dto.member.KmMemberTermsDTO.KmMemberTermsDTOBuilder;
import com.example.kmarket.entity.member.KmMemberTermsEntity;
import com.example.kmarket.entity.member.KmMemberTermsEntity.KmMemberTermsEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T09:48:52+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmMemberTermsMapperImpl implements KmMemberTermsMapper {

    @Override
    public KmMemberTermsDTO toDTO(KmMemberTermsEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmMemberTermsDTOBuilder kmMemberTermsDTO = KmMemberTermsDTO.builder();

        kmMemberTermsDTO.terms( articleEntity.getTerms() );
        kmMemberTermsDTO.privacy( articleEntity.getPrivacy() );
        kmMemberTermsDTO.location( articleEntity.getLocation() );
        kmMemberTermsDTO.finance( articleEntity.getFinance() );
        kmMemberTermsDTO.tax( articleEntity.getTax() );

        return kmMemberTermsDTO.build();
    }

    @Override
    public KmMemberTermsEntity toEntity(KmMemberTermsDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmMemberTermsEntityBuilder kmMemberTermsEntity = KmMemberTermsEntity.builder();

        kmMemberTermsEntity.terms( articleDTO.getTerms() );
        kmMemberTermsEntity.privacy( articleDTO.getPrivacy() );
        kmMemberTermsEntity.location( articleDTO.getLocation() );
        kmMemberTermsEntity.finance( articleDTO.getFinance() );
        kmMemberTermsEntity.tax( articleDTO.getTax() );

        return kmMemberTermsEntity.build();
    }
}
