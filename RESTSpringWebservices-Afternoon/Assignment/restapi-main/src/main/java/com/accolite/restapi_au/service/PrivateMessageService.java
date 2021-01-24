package com.accolite.restapi_au.service;

import com.accolite.restapi_au.entity.PrivateMessage;

import java.util.List;

public interface PrivateMessageService {
    public PrivateMessage add(PrivateMessage privateMessage);

    public List<PrivateMessage> getMessages(Integer userId);
    
    public PrivateMessage update(PrivateMessage privateMessage, Integer id);
    
    
    public String deleteMessageById(Integer id);
}
