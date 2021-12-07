package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.jurayev.academy.domain.Attachment;
import uz.jurayev.academy.domain.AttachmentContent;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.AttachmentContentRepository;
import uz.jurayev.academy.repository.AttachmentRepository;
import uz.jurayev.academy.service.AttachmentService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentContentRepository attachmentContentRepository;

    @Override
    public Result upload(List<MultipartFile> multipartFiles) {

        List<Attachment> attachmentList = new ArrayList<>();
        List<AttachmentContent> attachmentContentList = new ArrayList<>();

        if (multipartFiles.size() > 0) {
        for (MultipartFile file : multipartFiles) {

            Attachment attachment = new Attachment();
            attachment.setName(file.getOriginalFilename());
            attachment.setSize(file.getSize());
            attachment.setContentType(file.getContentType());
            attachmentList.add(attachment);
            attachmentRepository.saveAll(attachmentList);

            AttachmentContent attachmentContent = new AttachmentContent();
            for (Attachment attachment1 : attachmentList){
                try {
                    attachmentContent.setAttachmentId(attachment1.getId());
                    attachmentContent.setValue(file.getBytes());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            attachmentContentList.add(attachmentContent);
            attachmentContentRepository.saveAll(attachmentContentList);
        }
            return new Result("file successfully saved", true);
        }
            return new Result("file not found", false);
    }

    @Override
    public Attachment getOneFile(Long id, HttpServletResponse response) throws Exception {

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);

        if (optionalAttachment.isEmpty()) {
            throw new Exception("Could not found attachment with id: " + id);
        }

        Attachment attachment = optionalAttachment.get();
        Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.getAttachmentContent(attachment.getId());

        if (optionalAttachmentContent.isPresent()) {
            AttachmentContent attachmentContent = optionalAttachmentContent.get();

            response.setHeader("Content-Disposition", "attachment; filename=" + attachment.getName());
            response.setContentType(attachment.getContentType());

            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(attachmentContent.getValue());
            outputStream.close();
        }
        return attachment;
    }
}
