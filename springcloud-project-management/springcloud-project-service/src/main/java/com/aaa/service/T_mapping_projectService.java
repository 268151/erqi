package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.model.T_dict;
import com.aaa.model.T_mapping_project;
import com.aaa.model.T_resource;
import com.aaa.utils.DateUtils;
import com.aaa.utils.FileNameUtils;
import com.aaa.utils.FtpUtils;
import com.aaa.utils.IdWorker;
import com.aaa.vo.DictVo;
import com.aaa.vo.MappingProjectVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

import static com.aaa.status.FtpIpProperties.*;
import static com.aaa.status.TimeProperties.TIME_TYPE;
import static com.aaa.status.TimeProperties.TIME_TYPE02;

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

    public PageInfo<T_mapping_project> selectProjectByUserId(MappingProjectVo mappingProjectVo,Long user_id,String projectType) throws Exception {
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
            mapping_project.setProjectType(a1.getProjectType());
        }

        mapping_project.setUserId(user_id);
        mapping_project.setProjectType(projectType);
        PageInfo<T_mapping_project> projectPageByUserId = super.selectListByPage(mapping_project, mappingProjectVo.getPageNum(), mappingProjectVo.getPageSize());
        return projectPageByUserId;
    }




    /**
     * @author: dz
     * @createtime: 2020/7/18 11:46
     * @param:
     * @desc: 修改项目审核状态
     */

    public Integer updateMappingProject(T_mapping_project mapping_project) {
        mapping_project.setAuditStatus(0);
        return super.update(mapping_project);
    }

    /**
     * @author: dz
     * @createtime: 2020/7/20 21:16
     * @param:
     * @desc: 项目管理：修改
     */

    public Integer updateProject(T_mapping_project mapping_project){
        Integer integer = super.update(mapping_project);
        if (integer>0){
            return integer;
        }
        return null;
    }


    public Long addMappingProject(T_mapping_project mapping_project){
        Long l = new IdWorker().nextId();
        mapping_project.setId(new IdWorker().nextId());
        mapping_project.setContractTime(DateUtils.formatDate(new Date(),TIME_TYPE));

        Integer addOfResult= super.add(mapping_project);
        return addOfResult >0 ? l : 0;
    }


    @Transactional(rollbackFor = Exception.class)
    public Boolean
    beforeToDo(MultipartFile[] multipartFile,String refBizType,T_resourceService resourceService,Long tyid) throws Exception {
        Integer add=0;
        boolean uploadFileOfResult =false;
        for (MultipartFile file : multipartFile) {
            String filePath = DateUtils.formatDate(new Date(), TIME_TYPE02);
            String suffix = "." + file.getOriginalFilename().split("\\.")[1];
            String newFileName = FileNameUtils.getFileName() + suffix;
            //String createTimeAndModifyTime=DateUtils.formatDate(new Date(),TIME_TYPE);
             uploadFileOfResult = FtpUtils.upload(FTP_HOST, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, filePath, newFileName, file.getInputStream());
            //将数据放到t_resource中
            T_resource resource = new T_resource();
            resource.setId(new IdWorker().nextId())
                    .setName(file.getOriginalFilename())
                    .setSize(file.getSize())
                    .setPath(FTP_IP + "/" + filePath + "/" + newFileName)
                    .setExtName(suffix)
                    .setRefBizType(refBizType)
                    .setRefBizId(tyid)
                    .setCreateTime(new Date())
                    .setModifyTime(new Date());
             add = resourceService.addIsNull(resource);

        }
        if (add >0 && uploadFileOfResult) {
            return true;
        }
        return false;
    }





}
