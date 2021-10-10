package api;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Pair;

/**
 * Description     :
 */
public class SimpleLexer implements TokenSource {
	public static final int ID = 1; // Token.MIN_USER_TOKEN_TYPE;
	public static final int INT = 2;
	public static final int SEMI = 3;

	CharStream input;
	TokenFactory<?> factory = CommonTokenFactory.DEFAULT;

	int line = 1;
	int charPositionInLine = 0;

	/**
	 * When we start token, track initial coordinates so we can properly
	 * build token objects.
	 */
	int startCharIndex;
	int startLine;
	int startCharPositionInLine;
	char c;        // current character

	public SimpleLexer(CharStream input) {
		this.input = input;
		c = (char) input.LA(1); // prime lookahead
	}



    @Override
    public Token nextToken() {
        while (true) {
            if ( c==(char)CharStream.EOF ) return createToken(Token.EOF);
            while ( Character.isWhitespace(c) ) consume(); // 丢弃空白字符
            startCharIndex = input.index();
            startLine = getLine();
            startCharPositionInLine = getCharPositionInLine();
            if ( c==';' ) {
                consume();
                return createToken(SEMI);
            }
            else if ( c>='0' && c<='9' ) {
                while ( c>='0' && c<='9' ) consume();
                return createToken(INT);
            }
            else if ( c>='a' && c<='z' ) { // VERY simple ID
                while ( c>='a' && c<='z' ) consume();
                return createToken(ID);
            }
            // error; consume and try again
            consume();
        }
    }

    protected Token createToken(int ttype) {
        String text = null; // 我们使用输入字符序列的start...stop子序列
		Pair<TokenSource, CharStream> source =
			new Pair<TokenSource, CharStream>(this, input);
        return factory.create(source, ttype, text, Token.DEFAULT_CHANNEL,
                              startCharIndex, input.index()-1,
                              startLine, startCharPositionInLine);
    }

    protected void consume() {
        if ( c=='\n' ) {
            line++;  // \r 是一个普通字符，\n会使得line++
            charPositionInLine = 0;
        }
        if ( c!=(char)CharStream.EOF ) input.consume();
        c = (char)input.LA(1);
        charPositionInLine++;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getCharPositionInLine() {
        return charPositionInLine;
    }

    @Override
    public CharStream getInputStream() {
        return input;
    }

    @Override
    public String getSourceName() {
        return input.getSourceName();
    }

    @Override
    public void setTokenFactory(TokenFactory<?> factory) {
        this.factory = factory;
    }

    @Override
    public TokenFactory<?> getTokenFactory() {
        return factory;
    }
}
