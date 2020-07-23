package com.aaa.controller;


import com.aaa.base.ResultData;
import com.aaa.model.T_check_person;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckPersonController {
    @Autowired
    public IProjectService iProjectService;



    @GetMapping("/allcheckperson")
    public ResultData selectCheckPersonBypage(T_check_person check_person,Integer pageNum,Integer pageSize){
        return iProjectService.selectCheckPersonBypage(check_person,pageNum,pageSize);
    }


    @PostMapping("/addCheckPersons")
    public ResultData addCheckPerson(T_check_person check_person){
        return iProjectService.addCheckPerson(check_person);
    }



    @PostMapping("/updateCheckPersons")
    public ResultData updateCheckPerson(T_check_person check_person){
       return iProjectService.updateCheckPerson(check_person);

    }

    @PostMapping("/delCheckPersons")
    public ResultData delCheckPerson(T_check_person check_person){
        return iProjectService.delCheckPerson(check_person);

    }



    /**
     * 抽查分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */

    @GetMapping("/getRandomUnitlimitCheck")
    public ResultData  getRandomUnitlimitCheck(@RequestParam Integer  pageNum, @RequestParam Integer pageSize){
       return iProjectService.getRandomUnitlimitCheck(pageNum,pageSize);
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
        return iProjectService.getRandomUnitinitCheck(scale,pageNum,pageSize);
    }




    }

