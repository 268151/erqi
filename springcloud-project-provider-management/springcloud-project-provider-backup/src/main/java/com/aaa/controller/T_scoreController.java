package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_mapping_unit;
import com.aaa.model.T_resource;
import com.aaa.model.T_score;
import com.aaa.service.T_mapping_unitService;
import com.aaa.service.T_resourceService;
import com.aaa.service.T_scoreService;
import com.aaa.utils.DateUtils;
import com.aaa.utils.FileNameUtils;
import com.aaa.vo.ScoreVo;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class T_scoreController extends CommonController<T_score> {
    @Override
    public BaseService<T_score> getBaseService() {
        return scoreService;
    }

    @Autowired
    private T_scoreService scoreService;
    @Autowired
    private T_resourceService resourceService;
    @Autowired
    private T_mapping_unitService mapping_unitService;

/**
 * @author: dz
 * @createtime: 2020/7/17 11:33
 * @param:
 * @desc: 查询分数记录
 */

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

    @PostMapping("/updateScore")
    public ResultData updateScore(Integer score_plus,Integer score_subtract, T_score scores, String reason, Date create_time , Date modify_time, String name){
        Long aLong = mapping_unitService.updateScore(score_plus, score_subtract,scores.getUnitId());
        if (aLong != null && aLong>0){
            T_mapping_unit mapping_unit = mapping_unitService.selectOne(new T_mapping_unit().setId(scores.getUnitId()));
            scores.setId(Long.valueOf(FileNameUtils.getFileName()));
            scores.setCreateTime(DateUtils.getCurrentDate());
            Integer integer = scoreService.addScore(scores.getId(),score_plus,score_subtract,mapping_unit.getScore(),scores.getUnitId(),reason,scores.getCreateTime(),modify_time);
            if (integer != null && integer > 0) {
                T_resource tResource = new T_resource();
                tResource.setRefBizId(scores.getUnitId());
                tResource.setCreateTime(new Date()).setId(Long.valueOf(FileNameUtils.getFileName())).setName(name).setPath(FileNameUtils.getFileName()+""+name.substring(name.lastIndexOf(".")));
                Integer add = resourceService.add(tResource);
                if (add != null && add > 0) {
                    return super.operationSuccess("所有操作均完成");
                }
                return super.operationFailed("增加资源表失败");
            }
            return super.operationFailed("增加分值表失败");
        }
        return super.operationFailed("修改单位分值失败");
    }
}
