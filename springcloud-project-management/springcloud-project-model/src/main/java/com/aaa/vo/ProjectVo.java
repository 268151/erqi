package com.aaa.vo;

import com.aaa.model.T_audit;
import com.aaa.model.T_mapping_project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProjectVo {
    private T_mapping_project mapping_project;
    private T_audit audit;
}
