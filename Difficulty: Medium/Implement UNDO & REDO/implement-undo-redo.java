import java.util.*;

class Solution {
    private StringBuilder doc = new StringBuilder();
    private Stack<Character> undoStack = new Stack<>();
    private Stack<Character> redoStack = new Stack<>();

    public void append(char x) {
        doc.append(x);
        undoStack.push(x);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            char c = undoStack.pop();
            doc.deleteCharAt(doc.length() - 1);
            redoStack.push(c);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            char c = redoStack.pop();
            doc.append(c);
            undoStack.push(c);
        }
    }

    public String read() {
        return doc.toString();
    }
}
