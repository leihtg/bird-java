package com.bird.web.file.upload.validator;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author liuxx
 * @date 2018/4/27
 */
public interface IFileValidator {

    /**
     * 验证文件是否合法
     * @param file
     * @return
     */
    ValidateResult validate(MultipartFile file);
}
