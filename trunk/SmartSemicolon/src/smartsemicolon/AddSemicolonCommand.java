package smartsemicolon;

import org.eclipse.swt.custom.StyledText;

public class AddSemicolonCommand extends AbstractAddSemicolonCommand {

	@Override
	protected void doAddSemicolon(StyledText styledText) {
		int caretOffset = styledText.getCaretOffset();
		int lineAtOffset = styledText.getLineAtOffset(caretOffset);
		int offsetAtLine = styledText.getOffsetAtLine(lineAtOffset);
		String line = styledText.getLine(lineAtOffset);
		if (!line.matches(".*" + ";" + "[^;)]*" + "$")) {
			styledText.setCaretOffset(offsetAtLine + line.length());
			String appendage = ";";
			styledText.insert(appendage);
			styledText.setCaretOffset(caretOffset);
		}		
	}

}
