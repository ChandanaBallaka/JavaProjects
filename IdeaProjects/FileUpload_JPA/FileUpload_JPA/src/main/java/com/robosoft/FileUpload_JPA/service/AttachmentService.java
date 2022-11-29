package com.robosoft.FileUpload_JPA.service;

import com.robosoft.FileUpload_JPA.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService
{
    Attachment saveAttachment(MultipartFile file) throws Exception;
}
