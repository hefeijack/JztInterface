package com.jzt.controller;



import com.jzt.entity.Merchant;
import com.jzt.mapper.MerchantMapper;
import com.jzt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class MerchantController {

    @GetMapping("/api/bankMerchIdentify/{cust_id}/{mer_name}")
    public Map<String,Object> getMerchantInfo(@PathVariable("cust_id") String cust_id,
                                          @PathVariable("mer_name") String mer_name){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MerchantMapper merchantMapper = sqlSession.getMapper(MerchantMapper.class);


        String avg_amt = merchantMapper.getMerchantInfoById(cust_id);

        if(avg_amt == null ||  "".equals(avg_amt)){
            avg_amt = merchantMapper.getMerchantInfoByName(mer_name);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("code","0");
        map.put("msg","请求成功!");
        Map<String,Object> dataInfo = new HashMap<>();
        if(avg_amt == null || "".equals(avg_amt)){
            dataInfo.put("is_bank_merch","0");
            dataInfo.put("daily_sales","0");
        }else{
            dataInfo.put("is_bank_merch","1");
            dataInfo.put("daily_sales", avg_amt);
        }
        map.put("data", dataInfo);

        sqlSession.close();
        return map;
    }

}
