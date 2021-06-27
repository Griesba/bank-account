package com.kata.bankaccount.web.mapper;

import com.kata.bankaccount.model.ClientAction;
import com.kata.bankaccount.web.model.ClientActionDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface ClientActionMapper {
    ClientAction dtoToClientAction(ClientActionDto clientActionDto);

    ClientActionDto clientActionToDto(ClientAction clientAction);
}
