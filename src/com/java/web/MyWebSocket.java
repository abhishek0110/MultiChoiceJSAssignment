package com.java.web;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/navData")
public class MyWebSocket {
	
	@OnOpen
	public void onOpen(Session session)
	{
		System.out.println("Inside onOpen: "+session.getId());
	}
	
	@OnMessage
	public void message(String msg, Session session)
	{
		System.out.println("Inside onMessage"+session.getId()+" Message:"+msg );
		
		try {
			session.getBasicRemote().sendText("Hello Client..."+msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void onClose(Session session)
	{
		System.out.println("Inside onClose Method: "+session.getId());
	}

}
