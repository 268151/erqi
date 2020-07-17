package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_score;
import com.aaa.service.T_scoreService;
import com.aaa.vo.ScoreVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class T_scoreController extends CommonController<T_score> {
    @Override
    public BaseService<T_score> getBaseService() {
        return scoreService;
    }

    @Autowired
    private T_scoreService scoreService;


    @GetMapping("/allScore")
    public ResultData selectScore(ScoreVo scoreVo,Long unit_id){
        try {
            PageInfo<T_score> scorePageInfo = scoreService.selectScoreByPage(scoreVo,unit_id);
            if (scorePageInfo.getList().size()>0&&scorePageInfo!=null) {
                return operationSuccess(scorePageInfo);
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
}
