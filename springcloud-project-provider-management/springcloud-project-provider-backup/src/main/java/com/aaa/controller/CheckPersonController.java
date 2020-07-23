package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_check_person;
import com.aaa.model.T_mapping_unit;
import com.aaa.service.CheckPersonService;
import com.aaa.utils.DateUtils;
import com.aaa.utils.FileNameUtils;
import com.aaa.utils.PageInfoRandom;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CheckPersonController extends CommonController<T_check_person> {
    @Override
    public BaseService<T_check_person> getBaseService() {
        return checkPersonService;
    }

    @Autowired
    private CheckPersonService checkPersonService;

    @PostMapping("/allcheckperson")
    public ResultData selectCheckPersonBypage(@RequestBody T_check_person check_person, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        try {

            PageInfo<T_check_person> checkPerson = checkPersonService.selectAllCheckPerson(check_person, pageNum,pageSize);
            if (checkPerson.getList().size()>0&&checkPerson!=null) {
                return operationSuccess(checkPerson);
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


    @PostMapping("/addCheckPersons")
    public ResultData addCheckPerson(T_check_person check_person){
        check_person.setId(Long.valueOf(FileNameUtils.getFileName()));
        check_person.setCreateTime(DateUtils.getCurrentDate());
        Integer integer = checkPersonService.addCheckPerson(check_person);

        if (integer>0){
            return insertSuccess();
        }else {
            return insertFailed();
        }

    }



    @PostMapping("/updateCheckPersons")
    public ResultData updateCheckPerson(T_check_person check_person){
        check_person.setModifyTime(DateUtils.getCurrentDate());
        Integer integer = checkPersonService.updateCheckPerson(check_person);

        if (integer>0){
            return updateSuccess();
        }else {
            return updateFailed();
        }

    }

    @PostMapping("/delCheckPersons")
    public ResultData delCheckPerson(T_check_person check_person){
        Integer integer = checkPersonService.deleteCheckPerson(check_person);
        if (integer>0){
            return deleteSuccess();
        }else {
            return deleteFailed();
        }

    }




    /**
     * 抽查分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getRandomUnitlimitCheck")
    public ResultData  getRandomUnitlimitCheck(@RequestParam Integer  pageNum, @RequestParam Integer pageSize){
        PageInfoRandom<T_mapping_unit> pageInfo=new PageInfoRandom(CheckPersonService.listcheck,pageNum,pageSize);
        return operationSuccess(pageInfo);
    }

    /**'
     * 抽查表初始化
     * @param scale
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getRandomUnitinitCheck")
    public ResultData  getRandomUnitinitCheck(@RequestParam Double scale,@RequestParam Integer  pageNum,@RequestParam Integer pageSize){
        CheckPersonService.setListcheck(null);
        List<T_check_person> randomUnit = checkPersonService.RandomPerson(scale);
        PageInfoRandom<T_check_person> pageInfo=new PageInfoRandom<T_check_person>(randomUnit,pageNum,pageSize);
        return operationSuccess(pageInfo);
    }


    }

