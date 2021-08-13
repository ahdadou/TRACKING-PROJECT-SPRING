package com.gaming.worspace.controllers;


import com.gaming.worspace.models.Inbox;
import com.gaming.worspace.models.Messages;
import com.gaming.worspace.models.dto.request.MessageRequest;
import com.gaming.worspace.services.InboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/v1/inbox")
public class ChatController {

    private InboxService inboxService;
    private SimpMessagingTemplate simpMessagingTemplate;

    public ChatController(InboxService inboxService, SimpMessagingTemplate simpMessagingTemplate) {
        this.inboxService = inboxService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    //    @PostMapping("/post")
//    public void sendSpecific(
//            @Payload Post post) throws Exception {
//        System.out.println(post.getBody()+"  Work----------------------:"+post.getTo());
//        simpMessagingTemplate.convertAndSendToUser(
//                post.getTo(), "/queue/notifications",post.getBody());
//    }



//    @PostMapping("/add")
//    public void addMessageToInbox(@Payload MessageRequest messageRequest){
//
//        Messages messages = inboxService.addInbox(messageRequest);
//       simpMessagingTemplate.convertAndSendToUser(
//       messageRequest.getReceiver_email(), "/queue/chat",messageRequest.getMessage());
//    }

    @PostMapping("/add")
    public ResponseEntity addMessageToInbox(@RequestBody MessageRequest messageRequest){
        System.out.println(messageRequest.getReceiver_email());
        System.out.println(messageRequest.getSender_email());

        Messages messages = inboxService.addInbox(messageRequest);
        return  ResponseEntity.ok(messages);
    }

    @GetMapping("/{email}")
    public ResponseEntity getInboxByEmail(@PathVariable("email") String email){
        List<Inbox> inbox = inboxService.getInboxByEmail(email);
        return ResponseEntity.ok(inbox);
    }


    @GetMapping("/messages")
    public ResponseEntity getMessagesById(@PathParam("id") Long id){

        List<Messages> inbox = inboxService.getMessagesByInboxId(id);
        return ResponseEntity.ok(inbox);
    }





}
