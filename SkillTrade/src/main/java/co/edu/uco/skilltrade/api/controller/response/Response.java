package co.edu.uco.skilltrade.api.controller.response;

import java.util.ArrayList;

import java.util.List;

import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;

public class Response<T> {
	
	private List<T> data;
	private List<String> messages;

	public Response(final List<T> data, final List<String> messages) {
		this.data = data;
		this.messages = messages;
	}

	public Response() {
		setData(new ArrayList<>());
		setMessages(new ArrayList<>());
	}

	public final List<T> getData() {
		return data;
	}

	public final void setData(List<T> data) {
		this.data = ObjectHelper.getObjectHelper().getDefault(data, new ArrayList<>());
	}

	public final List<String> getMessages() {
		return messages;
	}

	public final List<String> setMessages(List<String> messages) {
		return this.messages = ObjectHelper.getObjectHelper().getDefault(messages, new ArrayList<>());
	}

}
