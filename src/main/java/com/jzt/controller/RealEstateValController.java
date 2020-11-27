package com.jzt.controller;

import com.jzt.entity.RealEstateValuation;
import com.jzt.mapper.RealEstateValuationMapper;
import com.jzt.utils.MybatisUtils;
import com.jzt.utils.SearchRealEstateInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class RealEstateValController {

    @GetMapping("/api/houseEvaluate/{name}/{cerno}")
    public Map<String,Object> getUesrInfo(@PathVariable("name") String name,
                           @PathVariable("cerno") String cerno){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RealEstateValuationMapper realEstateValuationMapper = sqlSession.getMapper(RealEstateValuationMapper.class);

        RealEstateValuation realEstateValuation = new RealEstateValuation();
        realEstateValuation.setName(name);
        realEstateValuation.setCerno(cerno);
        List<RealEstateValuation> realEstateValuationList = realEstateValuationMapper.getRealEstateValuation(realEstateValuation);

        Map<String, Object> map = new HashMap<>();

        // 未访问到房产数据
        if(realEstateValuationList.size()==0){
            sqlSession.close();
            SearchRealEstateInfo.SearchRealEstateInfo(name, cerno);
            sqlSession = MybatisUtils.getSqlSession();
            realEstateValuationMapper = sqlSession.getMapper(RealEstateValuationMapper.class);
            realEstateValuationList = realEstateValuationMapper.getRealEstateValuation(realEstateValuation);
        }

        map.put("code","0");
        map.put("msg","请求成功");
        Map<String,Object> house = new HashMap<>();
        int i=1;
        Map<String,Object> houseInfo;
        for(RealEstateValuation real: realEstateValuationList){
            houseInfo = new HashMap<>();
            houseInfo.put("cfzt",real.getCfzt());
            houseInfo.put("dyzt",real.getDyzt());
            houseInfo.put("zqse",real.getZqse());
            houseInfo.put("fcpgje",real.getFcpgje());
            house.put("house"+String.valueOf(i).toString(),houseInfo);
            i++;
        }
        map.put("data",house);
        sqlSession.close();
        return map;
    }

    /*@GetMapping("/api/houseEvaluate/{name}/{cerno}")
    public List<RealEstateValuation> getUesrInfo(@PathVariable("name") String name,
                                                 @PathVariable("cerno") String cerno){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RealEstateValuationMapper realEstateValuationMapper = sqlSession.getMapper(RealEstateValuationMapper.class);

        RealEstateValuation realEstateValuation = new RealEstateValuation();
        realEstateValuation.setName(name);
        realEstateValuation.setCerno(cerno);
        List<RealEstateValuation> realEstateValuationList = realEstateValuationMapper.getRealEstateValuation(realEstateValuation);

        sqlSession.close();
        return realEstateValuationList;
    }*/

    @GetMapping("/test")
    public List<RealEstateValuation> test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RealEstateValuationMapper realEstateValuationMapper = sqlSession.getMapper(RealEstateValuationMapper.class);

        List<RealEstateValuation> realEstateValuationList = realEstateValuationMapper.getRealEstateValuation();
        sqlSession.close();
        return realEstateValuationList;
    }

}
