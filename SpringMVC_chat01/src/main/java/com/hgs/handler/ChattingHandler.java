package com.hgs.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class ChattingHandler extends TextWebSocketHandler {
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();


	@Override
	// 채팅 페이지(/chat)에 들어오면 클라이언트가 연결된 후 세션을 sessionList에 추가
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("#ChattingHandler, afterConnectionEstablished");
		sessionList.add(session);
		
		log.info(session.getPrincipal().getName() + "님이 입장하셨습니다.");
	}

	@Override
	// 웹 소켓 서버로 메세지를 전송했을 때마다 메서드 호출
	// 해당 웹 소켓 서버에 접속한 Session 모두에게 메세지 전달을 하므로 loop를 돌아 메세지 전송
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.info("#ChattingHandler, handleMessage");
		log.info(session.getId() + ": " + message);
		
		for(WebSocketSession ws : sessionList)
			ws.sendMessage(new TextMessage(session.getPrincipal().getName() + ": " + message.getPayload()));
	}

	@Override
	// 클라이언트와 연결이 끊어진 경우(채팅방 나가기) remove로 해당 세션 제거
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("#ChattingHandler, afterConnectionClosed");
		sessionList.remove(session);
		log.info(session.getPrincipal().getName() + "님이 퇴장하셨습니다.");
	}


	
	
}
