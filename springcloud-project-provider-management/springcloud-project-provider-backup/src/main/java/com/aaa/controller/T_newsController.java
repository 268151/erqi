package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_news;
import com.aaa.service.T_newsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class T_newsController extends CommonController<T_news> {
    @Autowired
    private T_newsService newsService;
    @Override
    public BaseService<T_news> getBaseService() {
        return null;
    }


    @GetMapping("/selectAllNews")
    public ResultData selectAllNews(T_news t_news, Integer pageNo, Integer pageSize){
        PageInfo<T_news> tNewsPageInfo = newsService.selectAllNews(t_news, pageNo, pageSize);
        if (tNewsPageInfo != null && tNewsPageInfo.getSize()>0){
            return operationSuccess(tNewsPageInfo);
        }
        return operationFailed();

    }


    @PostMapping("/addNews")
    public ResultData addNews(T_news news){
        Integer integer = newsService.addNews(news);

        if (integer>0){
            return insertSuccess();
        }else {
            return insertFailed();
        }

    }

    @PostMapping("/updateNews")
    public ResultData updateNews(T_news news){
        Integer integer = newsService.updateNews(news);

        if (integer>0){
            return updateSuccess();
        }else {
            return updateFailed();
        }

    }


    @PostMapping("/delNews")
    public ResultData delNews(@RequestBody List<Long> ids){
        Integer integer = newsService.delNews(ids);

        if (integer>0){
            return deleteSuccess();
        }else {
            return deleteFailed();
        }

    }

}

