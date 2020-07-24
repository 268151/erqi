package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_mapping_unit;
import com.aaa.model.T_result_commit;
import com.aaa.service.T_mapping_unitService;
import com.aaa.service.T_result_commitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @description: TResuleComitService
 * @author: 彭于晏
 * @create: 2020-07-20 19:59
 **/
public class TResuleComitController extends CommonController<T_result_commit> {

    @Autowired
    private T_result_commitService t_result_commitService;

    @Autowired
    private T_mapping_unitService t_mapping_unitService;
    @Override
    public BaseService<T_result_commit> getBaseService() {
        return t_result_commitService;
    }

    /**
     * 汇交获取
     * @param map
     * @return
     */
    @RequestMapping("/getCommitByid")
    public ResultData getCommitByid(@RequestParam Map map){
        Object id = map.get("id");
        if(null==id){
            operationFailed("数据为获取");
        }
        T_mapping_unit Tunit=new T_mapping_unit();
        T_mapping_unit t_mapping_unit = t_mapping_unitService.selectOne(Tunit.setUserId(Long.parseLong(id.toString())));

        if(t_mapping_unit!=null){
            map.put("refId",t_mapping_unit.getId());
            return  getAllBypageMap(map);
        }
        return operationFailed();

    }

}
