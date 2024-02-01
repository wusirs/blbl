package com.heisenberg.blbl.convert;

import com.heisenberg.blbl.bean.CardTypeEnums;
import com.heisenberg.blbl.bean.dto.BankCardDto;
import com.heisenberg.blbl.bean.dto.BankUserDto;
import com.heisenberg.blbl.bean.po.BankCard;
import com.heisenberg.blbl.bean.po.BankUser;
import com.heisenberg.blbl.bean.vo.BankCardVo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankUserConvert {
    @Mapping(target = "bankCards", ignore = true) // 忽略这个字段，需要从字符串查询转实体list对象
    BankUserDto po2Dto(BankUser bankUser);

    @Mapping(target = "cardType", expression = "java(cardType(bankCard.getCardType()))")
    BankCardDto po2BankCardDto(BankCard bankCard);

    List<BankUserDto> po2BanKUserDto(List<BankUser> bankUserList);

    List<BankCardDto> po2BankCardDto(List<BankCard> bankCardList);


    @Mapping(source = "balance", target = "balance", numberFormat = "￥#.00", defaultValue = "￥0.00")
    BankCardVo dto2BankCarVo(BankCardDto bankCardDto);


    /**
     * 反转
     * @param bankCardVo vo
     * @return BankCardDto
     */
    @InheritInverseConfiguration(name = "dto2BankCarVo")
    BankCardDto vo2BankUserDto(BankCardVo bankCardVo);


    default String cardType(Integer cardType) {
        return CardTypeEnums.byCode(cardType).getLabel();
    }
}
