package com.example.kmarket.mapper.member;

import com.example.kmarket.dto.member.KmMemberRequestDTO;
import com.example.kmarket.dto.member.KmMemberRequestDTO.KmMemberRequestDTOBuilder;
import com.example.kmarket.entity.member.KmMemberEntity;
import com.example.kmarket.entity.member.KmMemberEntity.KmMemberEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T09:48:52+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmMemberMapperImpl implements KmMemberMapper {

    @Override
    public KmMemberRequestDTO toDTO(KmMemberEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmMemberRequestDTOBuilder kmMemberRequestDTO = KmMemberRequestDTO.builder();

        kmMemberRequestDTO.uid( articleEntity.getUid() );
        kmMemberRequestDTO.pass( articleEntity.getPass() );
        kmMemberRequestDTO.name( articleEntity.getName() );
        kmMemberRequestDTO.nick( articleEntity.getNick() );
        kmMemberRequestDTO.gender( articleEntity.getGender() );
        kmMemberRequestDTO.hp( articleEntity.getHp() );
        kmMemberRequestDTO.email( articleEntity.getEmail() );
        kmMemberRequestDTO.type( articleEntity.getType() );
        kmMemberRequestDTO.point( articleEntity.getPoint() );
        kmMemberRequestDTO.level( articleEntity.getLevel() );
        kmMemberRequestDTO.zip( articleEntity.getZip() );
        kmMemberRequestDTO.addr1( articleEntity.getAddr1() );
        kmMemberRequestDTO.addr2( articleEntity.getAddr2() );
        kmMemberRequestDTO.company( articleEntity.getCompany() );
        kmMemberRequestDTO.ceo( articleEntity.getCeo() );
        kmMemberRequestDTO.bizRegNum( articleEntity.getBizRegNum() );
        kmMemberRequestDTO.comRegNum( articleEntity.getComRegNum() );
        kmMemberRequestDTO.tel( articleEntity.getTel() );
        kmMemberRequestDTO.manager( articleEntity.getManager() );
        kmMemberRequestDTO.managerHp( articleEntity.getManagerHp() );
        kmMemberRequestDTO.fax( articleEntity.getFax() );
        kmMemberRequestDTO.regIp( articleEntity.getRegIp() );
        kmMemberRequestDTO.wdate( articleEntity.getWdate() );
        kmMemberRequestDTO.rdate( articleEntity.getRdate() );
        kmMemberRequestDTO.changeDate( articleEntity.getChangeDate() );
        kmMemberRequestDTO.etc1( articleEntity.getEtc1() );
        kmMemberRequestDTO.etc2( articleEntity.getEtc2() );
        kmMemberRequestDTO.etc3( articleEntity.getEtc3() );
        kmMemberRequestDTO.etc4( articleEntity.getEtc4() );
        kmMemberRequestDTO.etc5( articleEntity.getEtc5() );

        return kmMemberRequestDTO.build();
    }

    @Override
    public KmMemberEntity toEntity(KmMemberRequestDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmMemberEntityBuilder kmMemberEntity = KmMemberEntity.builder();

        kmMemberEntity.uid( articleDTO.getUid() );
        kmMemberEntity.pass( articleDTO.getPass() );
        kmMemberEntity.name( articleDTO.getName() );
        kmMemberEntity.nick( articleDTO.getNick() );
        kmMemberEntity.gender( articleDTO.getGender() );
        kmMemberEntity.hp( articleDTO.getHp() );
        kmMemberEntity.email( articleDTO.getEmail() );
        kmMemberEntity.type( articleDTO.getType() );
        kmMemberEntity.point( articleDTO.getPoint() );
        kmMemberEntity.level( articleDTO.getLevel() );
        kmMemberEntity.zip( articleDTO.getZip() );
        kmMemberEntity.addr1( articleDTO.getAddr1() );
        kmMemberEntity.addr2( articleDTO.getAddr2() );
        kmMemberEntity.company( articleDTO.getCompany() );
        kmMemberEntity.ceo( articleDTO.getCeo() );
        kmMemberEntity.bizRegNum( articleDTO.getBizRegNum() );
        kmMemberEntity.comRegNum( articleDTO.getComRegNum() );
        kmMemberEntity.tel( articleDTO.getTel() );
        kmMemberEntity.manager( articleDTO.getManager() );
        kmMemberEntity.managerHp( articleDTO.getManagerHp() );
        kmMemberEntity.fax( articleDTO.getFax() );
        kmMemberEntity.regIp( articleDTO.getRegIp() );
        kmMemberEntity.wdate( articleDTO.getWdate() );
        kmMemberEntity.rdate( articleDTO.getRdate() );
        kmMemberEntity.changeDate( articleDTO.getChangeDate() );
        kmMemberEntity.etc1( articleDTO.getEtc1() );
        kmMemberEntity.etc2( articleDTO.getEtc2() );
        kmMemberEntity.etc3( articleDTO.getEtc3() );
        kmMemberEntity.etc4( articleDTO.getEtc4() );
        kmMemberEntity.etc5( articleDTO.getEtc5() );

        return kmMemberEntity.build();
    }
}
