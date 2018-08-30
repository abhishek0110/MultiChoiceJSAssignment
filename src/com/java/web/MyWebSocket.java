package com.java.web;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
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
		String[] appliances={"TV","Washing Machine"};
		
		try {
			session.getBasicRemote().sendObject(appliances);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@OnClose
	public void onClose(Session session)
	{
		System.out.println("Inside onClose Method: "+session.getId());
	}
	
	@OnError
	public void onError(Throwable t)
	{
		
		System.out.println("Error: "+t.getMessage());
	}

}
