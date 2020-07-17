package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.model.T_dict;
import com.aaa.model.T_mapping_project;
import com.aaa.vo.DictVo;
import com.aaa.vo.MappingProjectVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class T_mapping_projectService extends BaseService<T_mapping_project> {
    /**
     * @author: dz
     * @createtime: 2020/7/15 20:11
     * @param: MappingProjectVo
     * @desc: 项目表分页，条件查询
     */


    public PageInfo<T_mapping_project> selectProjectByPage(MappingProjectVo mappingProjectVo) throws Exception {
        if (mappingProjectVo.getPageNum()==null){
            mappingProjectVo.setPageNum(1);
        }
        if (mappingProjectVo.getPageSize()==null){
            mappingProjectVo.setPageSize(10);
        }
        PageInfo<T_mapping_project> projectPage = super.selectListByPage(mappingProjectVo.getMapping_project(), mappingProjectVo.getPageNum(), mappingProjectVo.getPageSize());
        return projectPage;
    }


    /**
     * @author: dz
     * @createtime: 2020/7/16 16:24
     * @param:
     * @desc: 根据id查询项目
     */

    public List<T_mapping_project> selectList(Long id){
        T_mapping_project project=new T_mapping_project();
        project.setId(id);

        List<T_mapping_project> projectList = super.selectList(project);

        if (projectList.size()>0 && projectList!=null){
            return projectList;
        }
        return null;
    }

/**
 * @author: dz
 * @createtime: 2020/7/16 16:25
 * @param:
 * @desc: 在单位审核模块，根据user_id查询项目信息
 */

    public PageInfo<T_mapping_project> selectProjectByUserId(MappingProjectVo mappingProjectVo,Long user_id) throws Exception {
        if (mappingProjectVo.getPageNum()==null){
            mappingProjectVo.setPageNum(1);
        }
        if (mappingProjectVo.getPageSize()==null){
            mappingProjectVo.setPageSize(10);
        }

        T_mapping_project mapping_project=new T_mapping_project();
        T_mapping_project a1 = mappingProjectVo.getMapping_project();

        if(a1!=null){
            mapping_project.setUserId(a1.getUserId());
        }

        mapping_project.setUserId(user_id);
        PageInfo<T_mapping_project> projectPageByUserId = super.selectListByPage(mapping_project, mappingProjectVo.getPageNum(), mappingProjectVo.getPageSize());
        return projectPageByUserId;
    }

}
