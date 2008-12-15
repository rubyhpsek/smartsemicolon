package smartsemicolon;

import org.eclipse.swt.custom.StyledText;

public class AddSemicolonCommand extends SemicolonCommand {

	@Override
	protected void doAddSemicolon(StyledText styledText) {
		int caretOffset = styledText.getCaretOffset();
		int lineAtOffset = styledText.getLineAtOffset(caretOffset);
		int offsetAtLine = styledText.getOffsetAtLine(lineAtOffset);
		String line = styledText.getLine(lineAtOffset);
		if (lineQualifies(line)) {
			styledText.setCaretOffset(offsetAtLine + line.length());
			String appendage = getDelimiter();
			styledText.insert(appendage);
			styledText.setCaretOffset(caretOffset);
		}
	}

}
