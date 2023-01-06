package com.uz.shopapi.Service.impl;

import com.uz.shopapi.Model.entity.Message;
import com.uz.shopapi.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public List<Message> getAll(int status) {
        List<Message> list = messageRepository.findAllByFlag(status);
        LocalDateTime dateTime = LocalDateTime.now();
        for (Message message : list) {
            message.setFlag(2);
            message.setSana(dateTime);
        }
        messageRepository.saveAll(list);
        return list;
    }

    public boolean edit(List<Integer> list) {
        List<Message> messageList = messageRepository.findAllById(list);
        for (Message message : messageList) {
            message.setFlag(3);
        }
        List<Message> messages = messageRepository.saveAll(messageList);
        return true;
    }

//    public List<Message> getOne(Long id) {
//
//    }

//    public ApiResponse<Message> add(MessageDTO dto) {
//        Message message = new Message();
//        message.setText(dto.getText());
//        message.setPhone(dto.getPhone());
//        try {
//            message.setStatusType(StatusType.valueOf(dto.getStatusType()));
//        }catch (Exception e){
//            return ApiResponse.<Message>builder().
//                    status(400).
//                    success(false).
//                    message("This enum type not supported").
//                    build();
//        }
//
//        Message save = messageRepository.save(message);
//        return ApiResponse.<Message>builder().
//                status(201).
//                success(true).
//                message("Saved").
//                data(save).
//                build();
//    }
//
//    public ApiResponse<Message> edit(Long id, MessageDTO dto) {
//        Optional<Message> messageOptional = messageRepository.findById(id);
//        if (messageOptional.isEmpty()) {
//            return ApiResponse.<Message>builder().
//                    status(400).
//                    success(false).
//                    message("Not found").
//                    build();
//        }
//        Message message = messageOptional.get();
//        message.setText(dto.getText());
//        message.setPhone(dto.getPhone());
//        try {
//            message.setStatusType(StatusType.valueOf(dto.getStatusType()));
//        }catch (Exception e){
//            return ApiResponse.<Message>builder().
//                    status(400).
//                    success(false).
//                    message("This enum type not supported").
//                    build();
//        }
//
//        Message save = messageRepository.save(message);
//        return ApiResponse.<Message>builder().
//                status(201).
//                success(true).
//                message("Saved").
//                data(save).
//                build();
//    }
//
//    public ApiResponse<?> delete(Long id) {
//        Optional<Message> messageOptional = messageRepository.findById(id);
//        if (messageOptional.isEmpty()) {
//            return ApiResponse.<Message>builder().
//                    status(400).
//                    success(false).
//                    message("Not found").
//                    build();
//        }
//        messageRepository.deleteById(id);
//        return ApiResponse.builder().
//                status(200).
//                success(true).
//                message("Deleted").
//                build();
//    }

//    public ApiResponse<List<Message>> getAllByStatus(String type) {
//        StatusType statusType;
//        try {
//             statusType = StatusType.valueOf(type);
//        }catch (Exception e){
//            return ApiResponse.<List<Message>>builder().
//                    status(400).
//                    success(false).
//                    message("This enum type not supported").
//                    build();
//        }
//
//        List<Message> messageList = messageRepository.findAllByStatusType(statusType);
//        return ApiResponse.<List<Message>>builder().
//                status(200).
//                success(true).
//                message("Here").
//                data(messageList).
//                build();
//    }
}
