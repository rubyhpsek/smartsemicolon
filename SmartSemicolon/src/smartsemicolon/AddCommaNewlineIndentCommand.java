package smartsemicolon;

public class AddCommaNewlineIndentCommand extends
		AddSemicolonNewlineIndentCommand {

	@Override
	protected String getDelimiter() {
		return ",";
	}

}
