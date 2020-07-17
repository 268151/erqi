package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_dict;
import com.aaa.vo.DictVo;
import com.aaa.service.TDictService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class T_dictController extends CommonController<T_dict> {


    @Autowired
    private TDictService tDictService;


    @Override
    public BaseService<T_dict> getBaseService() {
        return tDictService;
    }

    /**
     * @author: dz
     * @createtime: 2020/7/15 11:10
     * @param:
     * @desc: 
     */
    
    @GetMapping("/al1l")
    public ResultData selectDictByPage(DictVo dictVo){
        try {
            PageInfo<T_dict> tDictPageInfo = tDictService.selectDictByPage(dictVo);
            if (tDictPageInfo.getList().size()>0&&tDictPageInfo!=null) {
                return operationSuccess(tDictPageInfo);
            }else {
                ResultData resultData = new ResultData();
                resultData.setCode("1");
                resultData.setMsg("暂无数据");
                return resultData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operationFailed();
    }



   /* @PostMapping("/add")
    public ResultData add(User user){
        return getBaseService().insertDta(user);
    }

    @PostMapping("/add")
    public ResultData selectAllRoles(){
        return userService.selectAllRoles();
    }*/

    /*@PostMapping("/upload")
    public Boolean upload(MultipartFile file){

    }*/
}
