package com.robosoft.FileUpload_JPA.repository;

import com.robosoft.FileUpload_JPA.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String>
{
}
