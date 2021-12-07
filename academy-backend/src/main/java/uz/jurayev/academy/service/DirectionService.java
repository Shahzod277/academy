package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Country;
import uz.jurayev.academy.domain.Direction;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.DirectionDto;

import java.util.List;

public interface DirectionService {
    Result addDirection(DirectionDto directionDto);
    List<Direction> getAll();
    Direction getOne(Long id);
    Result edit(Long id, DirectionDto directionDto);
    Result delete(Long id);
}
