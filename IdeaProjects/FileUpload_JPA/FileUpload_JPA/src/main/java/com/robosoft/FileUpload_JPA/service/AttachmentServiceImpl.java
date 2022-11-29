package com.robosoft.FileUpload_JPA.service;

import com.robosoft.FileUpload_JPA.entity.Attachment;
import com.robosoft.FileUpload_JPA.repository.AttachmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService
{
    private AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository)
    {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename()) ;
        try
        {
            if(fileName.contains(". ."))
            {
                throw new Exception("Filename contains invalid path sequence"
                        + fileName);
            }
            Attachment attachment
                    = new Attachment(fileName,
                    file.getContentType(),
                    file.getBytes());
            return attachmentRepository.save(attachment);
        }catch(Exception e){
            throw new Exception("Could not save File" + fileName);
        }
    }
}
