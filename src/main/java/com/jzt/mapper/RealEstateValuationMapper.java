package com.jzt.mapper;


import com.jzt.entity.RealEstateValuation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RealEstateValuationMapper {

    List<RealEstateValuation> getRealEstateValuation(RealEstateValuation realEstateValuation);

    List<RealEstateValuation> getRealEstateValuation(String name, String cerno);

    List<RealEstateValuation> getRealEstateValuation();

}
