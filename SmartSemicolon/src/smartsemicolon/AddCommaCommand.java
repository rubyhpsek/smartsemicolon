package smartsemicolon;

public class AddCommaCommand extends AddSemicolonCommand {

	@Override
	protected String getDelimiter() {
		return ",";
	}
}
