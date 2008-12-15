package smartsemicolon;

public abstract class SemicolonCommand extends AbstractAddSemicolonCommand {

	protected String getDelimiter() {
		return ";";
	}

}
