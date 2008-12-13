package smartsemicolon;

import org.eclipse.swt.custom.StyledText;

public class AddSemicolonNewlineIndentCommand extends AbstractAddSemicolonCommand {

	@Override
	protected void doAddSemicolon(StyledText styledText) {
		int caretOffset = styledText.getCaretOffset();
		int lineAtOffset = styledText.getLineAtOffset(caretOffset);
		int offsetAtLine = styledText.getOffsetAtLine(lineAtOffset);
		String line = styledText.getLine(lineAtOffset);
		if (!line.matches(".*" + ";" + "[^;)]*" + "$")) {
			StringBuilder prefix = new StringBuilder();
			for (int i = 0; i < line.length(); i++) {
				char charAt = line.charAt(i);
				if (Character.isWhitespace(charAt)) {
					prefix.append(charAt);
				} else {
					break;
				}
			}
			styledText.setCaretOffset(offsetAtLine + line.length());
			String appendage = ";" + styledText.getLineDelimiter()
					+ prefix;
			styledText.insert(appendage);
			caretOffset = styledText.getCaretOffset();
			int length = appendage.length();
			styledText.setCaretOffset(caretOffset+length);
		}
	}

}
