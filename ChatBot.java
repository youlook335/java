import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ChatBot {
    private Map<String, String> responses;

    public ChatBot() {
        responses = new HashMap<>();
        responses.put("hello", "Hi there! How can I assist you today?");
        responses.put("how are you?", "I'm just a program, but thanks for asking!");
        responses.put("bye", "Goodbye! Have a great day!");
    }

    public String getResponse(String input) {
        input = input.trim().toLowerCase();
        for (String key : responses.keySet()) {
            if (input.equalsIgnoreCase(key)) {
                return responses.get(key);
            }
        }
        return "I'm sorry, I don't understand that.";
    }

    public static void main(String[] args) {
        ChatBot chatBot = new ChatBot();
        try (Scanner scanner = new Scanner(System.in)) {
            String userInput;
            System.out.println("Welcome to the Chat Bot! Type 'bye' to exit.");
            while (true) {
                System.out.print("You: ");
                userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("bye")) {
                    System.out.println(chatBot.getResponse(userInput));
                    break;
                }
                System.out.println("Bot: " + chatBot.getResponse(userInput));
            }
        }
    }
}
