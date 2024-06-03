package co.edu.uco.skilltrade.api.validator;

import java.util.ArrayList;

import java.util.List;

import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public final class Result {
	
	private List<String> messages;

	private Result(final List<String> messages) {
		setMessages(messages);

	}

	public static Result create() {
		return new Result(new ArrayList<>());
	}

	public static Result create(final List<String> messages) {
		return new Result(messages);
	}

	public void addMessage(String message) {
		if (!TextHelper.isNullOrEmpty(message)) {
			messages.add(TextHelper.applyTrim(message));
		}
	}
	
	public final void addMessages(final List<String> messages) {
		getMessages().addAll(ObjectHelper.getObjectHelper().getDefault(messages, new ArrayList<>()));
	}

	private final void setMessages(List<String> messages) {
		this.messages = ObjectHelper.getObjectHelper().getDefault(messages, new ArrayList<>());
	}

	public final boolean isValid() {
		return messages.isEmpty();
	}

	public final List<String> getMessages() {
		return messages;
	}

}
